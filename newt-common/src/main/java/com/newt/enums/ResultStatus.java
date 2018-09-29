package com.newt.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 请求状态枚举
 */
@Getter
@AllArgsConstructor
public enum ResultStatus {

    SUCCESS(100,"成功"),

    PICKNAME_OR_PASSWORD_ERROR(-1000,"用户名或密码错误"),

    USER_NOT_FOUND(-1001,"用户不存在"),

    USER_NOT_LOGIN(-1002,"用户未登录"),

    FORBIDDEN(-1003,"用户被禁用，请联系管理员"),

    SYSTEM_ERROR(-1004,"系统错误，请联系管理员");


    /**
     * 枚举状态
     */
    private int code;
    /**
     * 枚举详情
     */
    private String desc;

    public void setCode(int code) {
        this.code = code;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
