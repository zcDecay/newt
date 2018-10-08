package com.newt.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 用户状态枚举
 */
@Getter
@AllArgsConstructor
public enum UserStateEnum {

    NORMAL(1, "正常"),

    FORBIDDEN(2, "禁用");


    /**
     * 枚举状态
     */
    private Integer code;
    /**
     * 枚举详情
     */
    private String desc;

    /**
     * @Description: 根据状态获取详情
     * @param:  * @param code 状态
     * @return: java.lang.String
     */
    public static String getDesc(Integer code) {
        for (UserStateEnum state : UserStateEnum.values()) {
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
        for (UserStateEnum state : UserStateEnum.values()){
            map.put(state.getCode(),state.getDesc());
        }
        return map;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
