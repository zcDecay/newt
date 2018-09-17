package com.newt.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description SpringWeb配置
 * @Author zcc
 * @Date 18/09/13
 */
public class WebAppConfiguration implements WebMvcConfigurer {


    /**
     * @Description:   设置跨域
     * @param:  * @param registry
     * @return: void
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "DELETE", "PUT","PATCH")
                .allowedHeaders("Origin","Content-Type","Accept","X-Requested-With","Access-Control-Allow-Methods","Access-Control-Allow-Headers")
                .allowCredentials(true)
                .maxAge(3600);
    }

    /**
     * @Description: 修改自定义消息转换器，所用FastJson解析
     * @param:  * @param converters
     * @return: void
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        /*创建FastJson消息转换器*/
        FastJsonHttpMessageConverter jsonHttpConverter = new FastJsonHttpMessageConverter();
        /*创建配置类*/
        FastJsonConfig jsonConfig = new FastJsonConfig();
        /*修改内容返回的过滤,实体调用setSerializerFeatures方法可以配置多个过滤方式*/
        jsonConfig.setSerializerFeatures(
                SerializerFeature.PrettyFormat,
                SerializerFeature.WriteDateUseDateFormat,
                SerializerFeature.WriteNullStringAsEmpty,
                SerializerFeature.WriteNullNumberAsZero,
                SerializerFeature.WriteNullBooleanAsFalse,
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteNullListAsEmpty
        );
        List<MediaType> mediaTypes = new  ArrayList<>();
        mediaTypes.add(MediaType.APPLICATION_JSON_UTF8);

        jsonHttpConverter.setSupportedMediaTypes(mediaTypes);
        jsonHttpConverter.setFastJsonConfig(jsonConfig);
        converters.add(jsonHttpConverter);
    }

    /**
     * @Description:   日期格式处理
     * @param:  * @param registry
     * @return: void
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new DateConverterConfiguration());
    }

    /**
     * @Description: 静态资源映射
     * @param:  * @param registry
     * @return: void
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX + "/static/");
    }
}
