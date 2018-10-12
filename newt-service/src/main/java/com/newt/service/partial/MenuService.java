package com.newt.service.partial;

import com.newt.enums.NumberEnum;
import com.newt.enums.StateEnum;
import com.newt.mapper.partial.UserMenuMapper;
import com.newt.pojo.MenuEntity;
import com.newt.pojo.MenuTree;
import com.newt.pojo.partial.UserMenu;
import com.newt.pojo.partial.UserMenuExample;
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
     * @Description: 生成菜单树
     * @param:  * @param pid
     * @param menusMap
     * @return: java.util.List<com.newt.pojo.MenuTree>
     */
    public List<MenuTree> createMenuTrees(Integer pid, Map<Integer, List<UserMenu>> menusMap){

        return Optional
                .ofNullable(menusMap.get(pid))
                .orElseGet(() -> new ArrayList<UserMenu>())
                .stream()
                .filter(n -> n.getMenuPid() == pid).sorted(Comparator.comparing(UserMenu::getMenuOrder))
                .map(n ->{
                        return MenuTree.builder()
                                .entity(MenuEntity.builder()
                                        .id(n.getId())
                                        .pid(n.getMenuPid())
                                        .name(n.getMenuName())
                                        .desc(n.getMenuDesc())
                                        .icon(n.getMenuIcon())
                                        .path(n.getUrl())
                                        .build())
                                .childs(this.createMenuTrees(n.getId(),menusMap)).build();
                        })
                .collect(Collectors.toList());
    }

    /**
     * @Description:  查询菜单，通过角色id
     * @param:  * @param roleId
     * @return: java.util.List<com.newt.pojo.partial.UserMenu>
     */
    public List<MenuTree> selectMenusByRoleId(Integer roleId){

        UserMenuExample example = new UserMenuExample();
        example.createCriteria()
                .andMenuGroupIdLessThanOrEqualTo(roleId)
                .andEnableEqualTo(StateEnum.NORMAL.getCode());
        example.setOrderByClause("MENU_ORDER asc");

        List<UserMenu> userMenus = menuMapper.selectByExample(example);

        Map<Integer, List<UserMenu>> menusMap = userMenus.stream().collect(Collectors.groupingBy(UserMenu::getMenuPid));

        return this.createMenuTrees(NumberEnum.ZERO.getCode(),menusMap);
    }



}
