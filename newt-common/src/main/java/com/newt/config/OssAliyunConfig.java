package com.newt.config;

import com.newt.pojo.alibaba.OssAliyunField;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description aliyun配置类
 * @Author zcc
 * @Date 18/10/22
 */
@Configuration
public class OssAliyunConfig {

    @Bean(value = "defaultOssAliyunField")
    @ConfigurationProperties("oss.aliyun.defalut")
    public OssAliyunField defaultOssAliyunField() {
        return new OssAliyunField();
    }

    @Bean(value = "firstOssAliyuField")
    @ConfigurationProperties("oss.aliyun.first")
    public OssAliyunField firstOssAliyuField() {
        return new OssAliyunField();
    }

    @Bean(value = "secondOssAliyuField")
    @ConfigurationProperties("oss.aliyun.second")
    public OssAliyunField secondOssAliyuField() {
        return new OssAliyunField();
    }
}
