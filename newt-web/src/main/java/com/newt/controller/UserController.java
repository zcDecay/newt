package com.newt.controller;

import com.newt.mapper.partial.UserMapper;
import com.newt.pojo.partial.User;
import com.newt.pojo.partial.UserExample;
import com.newt.utils.AppContextUtil;
import com.newt.utils.IDUtil;
import com.newt.utils.IpUtil;
import com.sun.org.apache.bcel.internal.generic.NEW;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.xml.crypto.dsig.keyinfo.X509IssuerSerial;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description user测试Controller
 * @Author zcc
 * @Date 18/09/18
 */
@Slf4j
@RestController
public class UserController {
    @Autowired
    UserMapper userMapper;

    @GetMapping("/user")
    public List<User> getUser (){

        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        log.info("测试热部署");

        return userMapper.selectByExample(example);
    }

//    @GetMapping("/addUser")
//    public int insertUser(HttpServletRequest request){
//
//        return userMapper.insert();
//    }
}
