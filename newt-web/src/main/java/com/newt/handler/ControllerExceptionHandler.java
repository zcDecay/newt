package com.newt.handler;

import com.newt.pojo.ResultGenerator;
import com.newt.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.core.util.JsonUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description ControllerExceptionHandler
 * @Author zcc
 * @Date 18/09/26
 */
@Slf4j
@RestControllerAdvice
public class ControllerExceptionHandler {

    /**
     * 404
     *
     * @param request
     * @param response
     * @param ex
     * @return
     */
    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNoHandlerFoundException(HttpServletRequest request,
                                                HttpServletResponse response,
                                                NoHandlerFoundException ex) {
        log.error(ex.getMessage(), ex);
        return JsonUtil.objectToJson(ResultGenerator.getNotFoundResult());
    }

    /**
     * 405
     *
     * @param request
     * @param response
     * @param ex
     * @return
     */
    @ExceptionHandler
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public String handleMethodNotSupportedException(HttpServletRequest request,
                                                    HttpServletResponse response,
                                                    HttpRequestMethodNotSupportedException ex) {
        log.error(ex.getMessage(), ex);
        return JsonUtil.objectToJson(ResultGenerator.getMethodNotAllowedResult());
    }

    /**
     * 500
     *
     * @param request
     * @param response
     * @param ex
     * @return
     */
    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handle(HttpServletRequest request, HttpServletResponse response, Exception ex) {
        log.error(ex.getMessage(), ex);
        return JsonUtil.objectToJson(ResultGenerator.getServerErrorResult());
    }


}
