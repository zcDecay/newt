package com.newt.controller;

import com.newt.enums.ResultStatus;
import com.newt.enums.UserStateEnum;
import com.newt.pojo.Result;
import com.newt.pojo.ResultGenerator;
import com.newt.pojo.partial.User;
import com.newt.pojo.vo.UserVo;
import com.newt.service.partial.LogInfoService;
import com.newt.service.partial.UserService;
import com.newt.utils.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;

/**
 * @Description login
 * @Author zcc
 * @Date 18/09/29
 */
@Slf4j
@RestController
@RequestMapping("/login")
@Api(value = "login")
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private LogInfoService logInfoService;

    /**
     * @Description: 用户登录
     * @param:  * @param pickName
     * @param userPwd
     * @param request
     * @return: com.newt.pojo.Result
     */
    @PostMapping(value = {"","/getToken"})
    @ApiImplicitParam(paramType = "query",name= "pickName" ,value = "用户名",dataType = "string")
    @ApiOperation(value = "登录", notes="登录")
    public Result login (@RequestParam(value = "pickName", required = true) String pickName,
                         @RequestParam(value = "userPwd", required = true) String userPwd,
                         HttpServletRequest request){
        String url = WebUtil.getURL(request);

        User user = userService.findByLoginName(pickName);
        if (EmptyUtil.isEmpty(user)){
            return ResultGenerator.getFailResult(ResultStatus.USER_NOT_FOUND.getDesc());
        }
        userPwd = PasswordUtil.encryptPassword(user.getSalt(), userPwd);

        if (!userPwd.equals(user.getUserPwd())){
            return ResultGenerator.getFailResult(ResultStatus.PICKNAME_OR_PASSWORD_ERROR.getDesc());
        }

        if (user.getState().equals(UserStateEnum.FORBIDDEN.getCode())){
            return ResultGenerator.getFailResult(ResultStatus.FORBIDDEN.getDesc());
        }

        HashMap<String, String> reqMap = new HashMap<>();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String key = headerNames.nextElement();
            String value = request.getHeader(key);
            reqMap.put(key,value);
        }
        /*对象封装*/
        UserVo newUser = BeanUtil.copyUserToUserVo(user);
        /*更新user表*/
        boolean isYesOrNo = userService.updateUser(newUser);
        /*判断是否成功*/
        if(!isYesOrNo){
            return ResultGenerator.getFailResult(ResultStatus.SYSTEM_ERROR.getDesc());
        }
        /*更新loginfo表*/
        isYesOrNo = logInfoService.saveLogForLogin(newUser, WebUtil.getIP(), url, reqMap.get("user-agent"));
        /*判断是否成功*/
        if(!isYesOrNo){
            return ResultGenerator.getFailResult(ResultStatus.SYSTEM_ERROR.getDesc());
        }


        return ResultGenerator.getSuccessResult(JwtUtil.generateToken(newUser));
    }
}
