package com.newt.service.partial;

import com.newt.enums.NumberEnum;
import com.newt.enums.StateEnum;
import com.newt.mapper.partial.UserMenuMapper;
import com.newt.pojo.MenuTree;
import com.newt.pojo.RouterTree;
import com.newt.pojo.partial.UserMenu;
import com.newt.pojo.partial.UserMenuExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Description Router
 * @Author zcc
 * @Date 18/10/12
 */
@Service
public class RouterService {

    @Autowired
    private UserMenuMapper menuMapper;

    /**
     * @param menusMap
     * @Description: 生成菜单树
     * @param: * @param pid
     * @return: java.util.List<com.newt.pojo.MenuTree>
     */
    public List<RouterTree> createRouterTrees(Integer pid, Map<Integer, List<UserMenu>> menusMap) {

        return Optional
                .ofNullable(menusMap.get(pid))
                .orElseGet(() -> new ArrayList<UserMenu>())
                .stream()
                .filter(n -> Objects.equals(n.getMenuPid(), pid)).sorted(Comparator.comparing(UserMenu::getMenuOrder))
                .map(n -> {
                    return RouterTree.builder()
                            .name(n.getMenuName())
                            .path(n.getUrl())
                            .component(n.getComponent())
                            .children(this.createRouterTrees(n.getId(), menusMap)).build();
                })
                .collect(Collectors.toList());
    }

    /**
     * @Description: 查询菜单，通过角色id
     * @param: * @param roleId
     * @return: java.util.List<com.newt.pojo.partial.UserMenu>
     */
    public List<RouterTree> selectRouterByRoleId(Integer roleId) {

        UserMenuExample example = new UserMenuExample();
        example.createCriteria()
                .andMenuGroupIdLessThanOrEqualTo(roleId)
                .andEnableEqualTo(StateEnum.NORMAL.getCode());
        example.setOrderByClause("MENU_ORDER ASC");

        List<UserMenu> userMenus = menuMapper.selectByExample(example);

        Map<Integer, List<UserMenu>> menusMap = userMenus.stream().collect(Collectors.groupingBy(UserMenu::getMenuPid));

        return this.createRouterTrees(NumberEnum.ZERO.getCode(), menusMap);
    }

}
