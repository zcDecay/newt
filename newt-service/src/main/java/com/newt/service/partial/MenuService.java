package com.newt.service.partial;

import com.github.pagehelper.PageHelper;
import com.newt.enums.NumberEnum;
import com.newt.enums.StateEnum;
import com.newt.mapper.partial.UserMenuMapper;
import com.newt.pojo.MenuEntity;
import com.newt.pojo.MenuTree;
import com.newt.pojo.partial.UserMenu;
import com.newt.pojo.partial.UserMenuExample;
import com.newt.utils.EmptyUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Description 菜单Service
 * @Author zcc
 * @Date 18/10/10
 */
@Service
public class MenuService {

    @Autowired
    private UserMenuMapper menuMapper;

    /**
     * @param menusMap
     * @Description: 生成菜单树
     * @param: * @param pid
     * @return: java.util.List<com.newt.pojo.MenuTree>
     */
    public List<MenuTree> createMenuTrees(Integer pid, Map<Integer, List<UserMenu>> menusMap) {

        return Optional
                .ofNullable(menusMap.get(pid))
                .orElseGet(() -> new ArrayList<UserMenu>())
                .stream()
                .filter(n -> Objects.equals(n.getMenuPid(), pid)).sorted(Comparator.comparing(UserMenu::getMenuOrder))
                .map(n -> {
                    return MenuTree.builder()
                            .entity(MenuEntity.builder()
                                    .id(n.getId())
                                    .pid(n.getMenuPid())
                                    .name(n.getMenuName())
                                    .desc(n.getMenuDesc())
                                    .icon(n.getMenuIcon())
                                    .path(n.getUrl())
                                    .build())
                            .childs(this.createMenuTrees(n.getId(), menusMap)).build();
                })
                .collect(Collectors.toList());
    }

    /**
     * @Description: 查询菜单，通过角色id
     * @param: * @param roleId
     * @return: java.util.List<com.newt.pojo.partial.UserMenu>
     */
    public List<MenuTree> selectMenusByRoleId(Integer roleId) {

        UserMenuExample example = new UserMenuExample();
        example.createCriteria()
                .andMenuGroupIdLessThanOrEqualTo(roleId)
                .andEnableEqualTo(StateEnum.NORMAL.getCode());
        example.setOrderByClause("MENU_ORDER ASC");

        List<UserMenu> userMenus = menuMapper.selectByExample(example);

        Map<Integer, List<UserMenu>> menusMap = userMenus.stream().collect(Collectors.groupingBy(UserMenu::getMenuPid));

        return this.createMenuTrees(NumberEnum.ZERO.getCode(), menusMap);
    }

    /**
     * @Description: 查询全部菜单
     * @param: * @param
     * @return: java.util.List<com.sun.glass.ui.Menu>
     */
    public List<UserMenu> selectMenus() {
        UserMenuExample example = new UserMenuExample();
        return menuMapper.selectByExample(example);
    }

    /**
     * @Description: 查询全部菜单
     * @param: * @param
     * @return: java.util.List<com.sun.glass.ui.Menu>
     */
    public List<UserMenu> findAllMenus(int pageNum, int pageSize, String orderBy,
                                       UserMenu menu) {
        UserMenuExample example = new UserMenuExample();
        UserMenuExample.Criteria criteria = example.createCriteria();

        if (StringUtils.isNotEmpty(menu.getMenuName())){
            criteria.andMenuNameLike("%" + menu.getMenuName() + "%");
        }
        if (EmptyUtil.isNotEmpty(menu.getMenuGroupId())){
            criteria.andMenuGroupIdEqualTo(menu.getMenuGroupId());
        }
        if (EmptyUtil.isNotEmpty(menu.getSysDefault())) {
            criteria.andSysDefaultEqualTo(menu.getSysDefault());
        }
        if (EmptyUtil.isNotEmpty(menu.getEnable())) {
            criteria.andEnableEqualTo(menu.getEnable());
        }
        example.setOrderByClause("MENU_ORDER ASC");
        PageHelper.startPage(pageNum, pageSize, orderBy);
        return menuMapper.selectByExample(example);
    }

}
