package com.newt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description 使用MapperScan批量扫描所有的Mapper接口；
 * @Author zcc
 * @Date 18/09/14
 */
@SpringBootApplication
@MapperScan(value = {"com.newt.mapper.**"})
public class WebApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class,args);
    }
}
