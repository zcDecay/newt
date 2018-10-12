package com.newt.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 请求状态枚举
 */
@Getter
@AllArgsConstructor
public enum ResultStatus {

    SUCCESS(100,"成功"),

    PICKNAME_OR_PASSWORD_ERROR(-1000,"用户名或密码错误！"),

    USER_NOT_FOUND(-1001,"用户不存在！"),

    USER_NOT_LOGIN(-1002,"用户未登录！"),

    USER_EXIST(-1003,"用户已存在！"),

    FORBIDDEN(-1004,"用户被禁用，请联系管理员！"),

    SYSTEM_ERROR(-1005,"系统错误，请联系管理员！");


    /**
     * 枚举状态
     */
    private Integer code;
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

    /**
     * @Description: 根据状态获取详情
     * @param:  * @param code 状态
     * @return: java.lang.String
     */
    public static String getDesc(Integer code) {
        for (ResultStatus state : ResultStatus.values()) {
            if (state.code.equals(code)) {
                return state.desc;
            }
        }
        return null;
    }

    /**
     * @Description: 获取map集合
     * @param:  * @param
     * @return: java.util.Map<java.lang.String,java.lang.String>
     */
    public static Map<Integer,String> getMap(){
        Map<Integer,String> map = new LinkedHashMap<>();
        for (ResultStatus state : ResultStatus.values()){
            map.put(state.getCode(),state.getDesc());
        }
        return map;
    }
}
