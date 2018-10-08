package com.newt.controller;

import com.newt.enums.ResultStatus;
import com.newt.pojo.Result;
import com.newt.pojo.ResultGenerator;
import com.newt.pojo.partial.User;
import com.newt.service.partial.LogInfoService;
import com.newt.service.partial.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description 注册
 * @Author zcc
 * @Date 18/10/08
 */
@RequestMapping("/regist")
@RestController
public class RegistController {


    @Autowired
    private UserService userService;

    @Autowired
    private LogInfoService logInfoService;

    /**
     * @Description:  保存注册用户
     * @param:  * @param user
     * @param request
     * @return: com.newt.pojo.Result
     */
    @PostMapping(value = {"/save"})
    public Result login(User user, HttpServletRequest request) {
        Boolean isExist = userService.selectUserByPickName(user);
        if (isExist) {
            return ResultGenerator.getFailResult(ResultStatus.USER_EXIST.getDesc());
        }
        boolean isYesOrNo = userService.saveUser(user);

        if (!isYesOrNo){
            return ResultGenerator.getFailResult(ResultStatus.SYSTEM_ERROR.getDesc());
        }

        return ResultGenerator.getSuccessResult();
    }
}
