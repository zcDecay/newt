package com.newt.controller;

import com.github.pagehelper.PageInfo;
import com.newt.enums.StateEnum;
import com.newt.pojo.Result;
import com.newt.pojo.ResultGenerator;
import com.newt.pojo.partial.UserMenu;
import com.newt.pojo.vo.UserVo;
import com.newt.service.partial.MenuService;
import com.newt.utils.WebUtil;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
 * @Description 菜单管理
 * @Author zcc
 * @Date 18/10/25
 */
@Slf4j
@RestController
@RequestMapping("/menu")
@Api(value = "menu管理")
public class MenuController {
    @Autowired
    MenuService menuService;

    /**
     * @Description: 查询用户菜单
     * @param: * @param
     * @return: com.newt.pojo.Result 菜单
     */
    @GetMapping("/queryMenus")
    public Result queryMenus() {
        UserVo user = WebUtil.getUser();

        return ResultGenerator.getSuccessResult(menuService.selectMenusByRoleId(user.getRoleId()));
    }

    /**
     * @Description: 查询全部用户--->admin
     * @param: * @param user
     * @return: com.newt.pojo.Result list用户
     */
    @PostMapping("/queryMenus/admin")
    public Result queryUsers(UserMenu menu) throws ParseException {
        UserVo currentUser = WebUtil.getUser();

        int pageNum = WebUtil.getPageNum();
        int pageSize = WebUtil.getPageSize();
        String orderBy = WebUtil.getOrder();

        List<UserMenu> userMenus = menuService.findAllMenus(pageNum, pageSize, orderBy, menu);
        return ResultGenerator.getSuccessResult(new PageInfo<>(userMenus));
    }

    /**
     * @Description: 获取等级
     * @param: * @param
     * @return: com.newt.pojo.Result 等级
     */
    @GetMapping("/queryMap")
    public Result queryState() {
        List<Map<String, String>> roleList = StateEnum.getList();

        return ResultGenerator.getSuccessResult(roleList);
    }
}
