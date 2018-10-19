package com.newt.controller;

import com.github.pagehelper.PageInfo;
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
import com.newt.utils.WebUtil;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
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

    @PostMapping("/queryUsers")
    public Result queryUsers(User user) throws ParseException {
        List<UserVo> allUser = null;
        UserVo currentUser = WebUtil.getUser();

        int pageNum = WebUtil.getPageNum();
        int pageSize = WebUtil.getPageSize();
        String orderBy = WebUtil.getOrder();

        if (currentUser.getRoleId().equals(RoleEnum.SEVEN.getCode())) {
            List<User> userList = userService.findAllUser(pageNum, pageSize, orderBy, user);
            allUser = userList.stream().map(u -> BeanUtil.copyUserToUserVo(u, Boolean.FALSE)).collect(Collectors.toList());
        }
        return ResultGenerator.getSuccessResult(new PageInfo<>(allUser));
    }

    @GetMapping("queryLevel")
    public Result queryLevel() {
        List<Map<String, String>> roleList = RoleEnum.getList();

        return ResultGenerator.getSuccessResult(roleList, RoleEnum.getDescList());
    }

    @PostMapping("updateState")
    public Result updateState(User user) {
        boolean isExist = userService.updateUserState(user);
        if (isExist) {
            return ResultGenerator.getSuccessResult(ResultStatus.SUCCESS.getDesc());
        }
        return ResultGenerator.getFailResult(ResultStatus.SYSTEM_ERROR.getDesc());
    }

    @PostMapping("deleteUser")
    public Result deleteUser(@RequestParam(required = true, value = "id") Integer id) {

        boolean isExist = userService.deleteById(id);
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
