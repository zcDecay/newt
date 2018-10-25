package com.newt.controller;

import com.github.pagehelper.PageInfo;
import com.newt.enums.ResultStatus;
import com.newt.enums.RoleEnum;
import com.newt.pojo.Result;
import com.newt.pojo.ResultGenerator;
import com.newt.pojo.partial.User;
import com.newt.pojo.vo.UserVo;
import com.newt.service.partial.RouterService;
import com.newt.service.partial.UserService;
import com.newt.utils.BeanUtil;
import com.newt.utils.DateUtil;
import com.newt.utils.EmptyUtil;
import com.newt.utils.WebUtil;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.ArrayList;
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
    RouterService routerService;


    /**
     * @Description: 获取用户信息
     * @param: * @param
     * @return: com.newt.pojo.Result 用户
     */
    @PostMapping("/getUserInfo")
    public Result getUserInfo() {

        UserVo user = WebUtil.getUser();
        if (EmptyUtil.isEmpty(user)) {
            return ResultGenerator.getFailResult(ResultStatus.USER_NOT_FOUND.getDesc());
        }

        return ResultGenerator.getSuccessResult(user);
    }


    /**
     * @Description: 查询用户动态路由
     * @param: * @param
     * @return: com.newt.pojo.Result 路由
     */
    @GetMapping("/queryRouter")
    public Result queryRouter() {
        UserVo user = WebUtil.getUser();

        return ResultGenerator.getSuccessResult(routerService.selectRouterByRoleId(user.getRoleId()));
    }

    /**
     * @Description: 查询全部用户
     * @param: * @param user
     * @return: com.newt.pojo.Result list用户
     */
    @PostMapping("/queryUsers")
    public Result queryUsers(User user) throws ParseException {
        List<UserVo> allUser = new ArrayList<>();
        UserVo currentUser = WebUtil.getUser();

        int pageNum = WebUtil.getPageNum();
        int pageSize = WebUtil.getPageSize();
        String orderBy = WebUtil.getOrder();

        if (currentUser.getRoleId().equals(RoleEnum.SEVEN.getCode())) {
            List<User> userList = userService.findAllUser(pageNum, pageSize, orderBy, user);
            allUser = userList
                    .stream()
                    .map(u -> BeanUtil.copyUserToUserVo(u, Boolean.FALSE))
                    .collect(Collectors.toList());
        }
        return ResultGenerator.getSuccessResult(new PageInfo<>(allUser));
    }

    /**
     * @Description: 获取等级
     * @param: * @param
     * @return: com.newt.pojo.Result 等级
     */
    @GetMapping("/queryLevel")
    public Result queryLevel() {
        List<Map<String, String>> roleList = RoleEnum.getList();

        return ResultGenerator.getSuccessResult(roleList, RoleEnum.getDescList());
    }

    /**
     * @Description: 更新用户状态
     * @param: * @param user 用户
     * @return: com.newt.pojo.Result 状态
     */
    @PostMapping("/updateState")
    public Result updateState(User user) {
        boolean isExist = userService.updateUserState(user);
        if (isExist) {
            return ResultGenerator.getSuccessResult(ResultStatus.SUCCESS.getDesc());
        }
        return ResultGenerator.getFailResult(ResultStatus.SYSTEM_ERROR.getDesc());
    }

    /**
     * @Description: 删除用户
     * @param: * @param id 用户id
     * @return: com.newt.pojo.Result 成功与否提示
     */
    @PostMapping("/deleteUser")
    public Result deleteUser(@RequestParam(required = true, value = "id") Integer id) {

        boolean isExist = userService.deleteById(id);
        if (isExist) {
            return ResultGenerator.getSuccessResult(ResultStatus.SUCCESS.getDesc());
        }
        return ResultGenerator.getFailResult(ResultStatus.SYSTEM_ERROR.getDesc());
    }

    /**
     * @param request
     * @Description: 保存注册用户
     * @param: * @param user 注册用户
     * @return: com.newt.pojo.Result  成功与否提示
     */
    @PostMapping(value = {"/updateUser/admin"})
    public Result update(User user, HttpServletRequest request) {
        user.setUpdateTime(DateUtil.getNowTime());
        user.setRoleId(RoleEnum.getCode(user.getRoleId()));
        boolean isYesOrNo = userService.updateUser(user);

        if (!isYesOrNo) {
            return ResultGenerator.getFailResult(ResultStatus.SYSTEM_ERROR.getDesc());
        }

        return ResultGenerator.getSuccessResult();
    }

    @RequestMapping("/")
    public String hello() {
        return "index";
    }
}
