package com.newt.controller;

import com.newt.enums.ResultStatus;
import com.newt.enums.UserStateEnum;
import com.newt.pojo.Result;
import com.newt.pojo.ResultGenerator;
import com.newt.pojo.partial.User;
import com.newt.service.partial.LogInfoService;
import com.newt.service.partial.UserService;
import com.newt.utils.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.generator.internal.util.EqualsUtil;
import org.springframework.beans.BeanUtils;
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

    @PostMapping(value = {"","/getToken"})
    @ApiImplicitParam(paramType = "query",name= "pickName" ,value = "用户名",dataType = "string")
    @ApiOperation(value = "登录", notes="登录")
    public Result login (@RequestParam(value = "pickName", required = true) String pickName,
                         @RequestParam(value = "userPwd", required = true) String userPwd){

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
        HttpServletRequest request = WebUtil.getRequest();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String key = headerNames.nextElement();
            String value = request.getHeader(key);
            reqMap.put(key,value);
        }
        User newUser = new User()
                .builder()
                .id(user.getId())
                .oldLoginIp(user.getLoginIp())
                .oldLoginTime(user.getOldLoginTime())
                .loginIp(WebUtil.getIP())
                .loginNum(user.getLoginNum() + 1)
                .loginTime(DateTimeUtil.getTimeStamp()).build();
        boolean isYesOrNo = userService.updateUser(newUser);
        if(isYesOrNo){
            return ResultGenerator.getFailResult(ResultStatus.SYSTEM_ERROR.getDesc());
        }
        User newtUser = new User();
        BeanUtils.copyProperties(user,newtUser);

        String ip = WebUtil.getIP();
        logInfoService.saveLogForLogin(newtUser,ip,"/login/getToken",reqMap.get("user-agent"));

        return ResultGenerator.getSuccessResult(JwtUtil.generateToken(newtUser));
    }
}
