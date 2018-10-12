package com.newt.controller;

import com.newt.enums.ResultStatus;
import com.newt.pojo.Result;
import com.newt.pojo.ResultGenerator;
import com.newt.pojo.vo.UserVo;
import com.newt.service.partial.MenuService;
import com.newt.service.partial.RouterService;
import com.newt.service.partial.UserService;
import com.newt.utils.EmptyUtil;
import com.newt.utils.WebUtil;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description user测试Controller
 * @Author zcc
 * @Date 18/09/18
 */
@Slf4j
@RestController
@RequestMapping("/user")
@Api(value = "swagger2测试")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    MenuService menuService;

    @Autowired
    RouterService routerService;


    @PostMapping("/getUserInfo")
    public Result getUserInfo() {

        UserVo user = WebUtil.getUser();
        if (EmptyUtil.isEmpty(user)) {
            return ResultGenerator.getFailResult(ResultStatus.USER_NOT_FOUND.getDesc());
        }

        return ResultGenerator.getSuccessResult(user);
    }

    @GetMapping("/queryMenus")
    public Result queryMenus() {
        UserVo user = WebUtil.getUser();

        return ResultGenerator.getSuccessResult(menuService.selectMenusByRoleId(user.getRoleId()));
    }

    @GetMapping("/queryRouter")
    public Result queryRouter() {
        UserVo user = WebUtil.getUser();

        return ResultGenerator.getSuccessResult(routerService.selectRouterByRoleId(user.getRoleId()));
    }

    @RequestMapping("/")
    public String hello() {
        return "index";

    }
}
