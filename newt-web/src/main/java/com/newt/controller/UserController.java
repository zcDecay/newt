package com.newt.controller;

import com.newt.enums.ResultStatus;
import com.newt.enums.RoleEnum;
import com.newt.pojo.Result;
import com.newt.pojo.ResultGenerator;
import com.newt.pojo.partial.User;
import com.newt.pojo.vo.UserVo;
import com.newt.service.partial.MenuService;
import com.newt.service.partial.RouterService;
import com.newt.service.partial.UserService;
import com.newt.utils.BeanUtil;
import com.newt.utils.EmptyUtil;
import com.newt.utils.MapUtil;
import com.newt.utils.WebUtil;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
    @GetMapping("getUsers")
    public Result getUser(){
        List<UserVo> allUser = null;
        UserVo user = WebUtil.getUser();

        if (user.getRoleId().equals(RoleEnum.SEVEN.getCode())) {
            List<User> users = userService.findAllUser();
            allUser = users.stream().map(BeanUtil::copyUserToUserVo).collect(Collectors.toList());
        }
        return ResultGenerator.getSuccessResult(allUser);
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

    @GetMapping("queryUsers")
    public Result queryUsers() {

        UserVo user = WebUtil.getUser();

        if (!user.getRoleId().equals(RoleEnum.SEVEN.getCode())) {
            return ResultGenerator.getFailResult(ResultStatus.PERMISSION_DENIED.getDesc());
        }

        return ResultGenerator.getSuccessResult(userService.findAllUser());
    }

    @GetMapping("queryLevel")
    public Result queryLevel() {
        Map<Integer, String> roleMap = RoleEnum.getMap();
        return ResultGenerator.getSuccessResult(MapUtil.map2Json(roleMap));
    }

    @PostMapping("updateState")
    public Result updateState(User user) {
        boolean isExist = userService.updateUserState(user);
        if (isExist) {
            return ResultGenerator.getSuccessResult(ResultStatus.SUCCESS.getDesc());
        }
        return ResultGenerator.getFailResult(ResultStatus.SYSTEM_ERROR.getDesc());
    }

    @RequestMapping("/")
    public String hello() {
        return "index";
    }
}
