package com.newt.controller;

import com.newt.mapper.partial.UserMapper;
import com.newt.pojo.partial.User;
import com.newt.pojo.partial.UserExample;
import com.newt.utils.AppContextUtil;
import com.newt.utils.IDUtil;
import com.newt.utils.IpUtil;
import com.sun.org.apache.bcel.internal.generic.NEW;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.xml.crypto.dsig.keyinfo.X509IssuerSerial;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Description user测试Controller
 * @Author zcc
 * @Date 18/09/18
 */
@Slf4j
@Controller
@Api(value = "swagger2测试")
public class UserController {
    @Autowired
    UserMapper userMapper;

    @GetMapping("/user")
    @ApiImplicitParam(paramType = "query",name= "username" ,value = "用户名",dataType = "string")
    @ApiOperation(value = "获取用户列表，目前没有分页", notes="返回全部用户")
    public List<User> getUser (){

        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        log.info("测试热部署");

        return userMapper.selectByExample(example);
    }
    @RequestMapping("/")
    public String hello( ){
        return "index";

    }
}
