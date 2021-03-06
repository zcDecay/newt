package com.newt.pojo;

import org.springframework.http.HttpStatus;

/**
 * 响应结果生成工具
 *
 * @author
 */
public class ResultGenerator {

    /**
     * @Description: 成功
     * @return: com.newt.pojo.Result
     */
    public static Result getSuccessResult() {
        return Result.builder().code(HttpStatus.OK.value()).message(HttpStatus.OK.getReasonPhrase()).success(true).build();
    }

    /**
     * @Description: 成功
     * @param: * @param data 携带数据
     * @return: com.newt.pojo.Result
     */
    public static Result getSuccessResult(Object data) {
        return Result.builder().code(HttpStatus.OK.value()).message(HttpStatus.OK.getReasonPhrase()).data(data).success(true).build();
    }

    /**
     * @param attachData 附加数据
     * @Description: 成功
     * @param: * @param data 携带数据
     * @return: com.newt.pojo.Result
     */
    public static Result getSuccessResult(Object data, Object attachData) {
        return Result.builder().code(HttpStatus.OK.value()).message(HttpStatus.OK.getReasonPhrase()).data(data).attachData(attachData).success(true).build();

    }

    /**
     * @Description: 失败
     * @return: com.newt.pojo.Result
     */
    public static Result getFailResult() {
        return Result.builder().code(HttpStatus.BAD_REQUEST.value()).message(HttpStatus.BAD_REQUEST.getReasonPhrase()).success(false).build();

    }

    /**
     * @Description: 失败
     * @param: * @param data 携带数据
     * @return: com.newt.pojo.Result
     */
    public static Result getFailResult(Object data) {
        return Result.builder().code(HttpStatus.BAD_REQUEST.value()).message(HttpStatus.BAD_REQUEST.getReasonPhrase()).data(data).success(false).build();

    }

    /**
     * @param attachData 附加数据
     * @Description: 失败
     * @param: * @param data 携带数据
     * @return: com.newt.pojo.Result
     */
    public static Result getFailResult(Object data, Object attachData) {
        return Result.builder().code(HttpStatus.BAD_REQUEST.value()).message(HttpStatus.BAD_REQUEST.getReasonPhrase()).data(data).attachData(attachData).success(false).build();

    }

    /**
     * @Description: 权限不足
     * @return: com.newt.pojo.Result
     */
    public static Result getUnauthorizedResult() {
        return Result.builder().code(HttpStatus.UNAUTHORIZED.value()).message(HttpStatus.UNAUTHORIZED.getReasonPhrase()).success(false).build();

    }

    /**
     * @Description: 404失败
     * @return: com.newt.pojo.Result
     */
    public static Result getNotFoundResult() {
        return Result.builder().code(HttpStatus.NOT_FOUND.value()).message(HttpStatus.NOT_FOUND.getReasonPhrase()).success(false).build();
    }

    /**
     * @Description: 405失败
     * @return: com.newt.pojo.Result
     */
    public static Result getMethodNotAllowedResult() {
        return Result.builder().code(HttpStatus.METHOD_NOT_ALLOWED.value()).message(HttpStatus.METHOD_NOT_ALLOWED.getReasonPhrase()).success(false).build();
    }

    /**
     * @Description: 500失败
     * @return: com.newt.pojo.Result
     */
    public static Result getServerErrorResult() {
        return Result.builder().code(HttpStatus.INTERNAL_SERVER_ERROR.value()).message(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()).success(false).build();
    }

}
