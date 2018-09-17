package com.newt.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description Druid配置
 * @Author zcc
 * @Date 18/09/13
 */
@Configuration
public class DruidConfiguration extends  StatViewServlet{

    @Value("${druid.allow}")
    private String allow;

    @Value("${druid.deny}")
    private String deny;

    @Value("${druid.loginUsername}")
    private String loginUsername;

    @Value("${druid.loginPassword}")
    private String loginPassword;

    @Value("${druid.resetEnable}")
    private String resetEnable;

    /**
     * ConfigurationProperties
     *      通过这个注解把配置文件中的(spring.datasource)数据源映射到该数据源中，不使用默认的数据源
     * Bean
     *      创建自定义Datsource,把springboot默认使用的datasource覆盖
     * @return
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druid(){
        return new DruidDataSource();
    }
    /**
     * 配置Druid监控，配置一个管理后台的Servlet
     * 扩展参数可以在ResourceServlet中找到
     * @return
     */
    @Bean
    public ServletRegistrationBean<StatViewServlet> druidStatViewServlet(){
        /*提供类的进行注册.*/
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(),"/druid/*");

        /*添加初始化参数：initParams*/
        Map<String,String> initParams = new HashMap<>(10);
        /*白名单*/
        initParams.put("allow",allow);
        /*IP黑名单 (存在共同时，deny优先于allow) : 如果满足deny的话提示:Sorry, you are not permitted to view this page.*/
        initParams.put("deny",deny);
        /*登录查看信息的账号密码.*/
        initParams.put("loginUsername",loginUsername);
        initParams.put("loginPassword",loginPassword);
        /*是否能够重置数据*/
        initParams.put("resetEnable",resetEnable);

        bean.setInitParameters(initParams);
        return bean;
    }

    /**
     * 配置一个wen监控的filter
     * 扩展参数可以在WebStatFilter中找到
     * @return
     */
    @Bean
    public FilterRegistrationBean<WebStatFilter> druidStatFilter(){

        FilterRegistrationBean<WebStatFilter> bean = new FilterRegistrationBean<>(new WebStatFilter());
        /*初始化参数*/
        Map<String,String> initParams = new HashMap<>(50);
        initParams.put("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid2/*");

        /*添加过滤规则.*/
        bean.setUrlPatterns(Arrays.asList("/*"));
        bean.setInitParameters(initParams);
        return bean;
    }
}
