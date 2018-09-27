package com.newt.handler;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.newt.pojo.Result;
import com.newt.pojo.ResultGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
/**
 * @Description ResponseBodyHandler
 * @Author zcc

 * @Date 18/09/26
 */
@Slf4j
@ControllerAdvice
public class ResponseBodyHandler implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> converterType) {
        return FastJsonHttpMessageConverter.class.isAssignableFrom(converterType);
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType,
                                  MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  ServerHttpRequest request, ServerHttpResponse response) {
        if (body != null && !(body instanceof Result)) {
            return ResultGenerator.getSuccessResult(body);
        }
        return body;
    }
}
