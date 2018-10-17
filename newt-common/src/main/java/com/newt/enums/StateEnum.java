package com.newt.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 状态枚举
 */
@Getter
@AllArgsConstructor
public enum StateEnum {


    FORBIDDEN(0, "禁用", "否"),

    NORMAL(1, "开启", "是");


    /**
     * 枚举状态
     */
    private Integer code;
    /**
     * 枚举详情
     */
    private String desc;

    /**
     * 描述
     */
    private String details;

    /**
     * @Description: 根据状态取反
     * @param:  * @param code
     * @return: java.lang.Integer
     */
    public static Integer reverseCode(Integer code){
        for (StateEnum state : StateEnum.values()) {
            if (!state.code.equals(code)) {
                return state.getCode();
            }
        }
        return null;
    }

    /**
     * @Description: 根据状态获取详情
     * @param:  * @param code 状态
     * @return: java.lang.String
     */
    public static String getDesc(Integer code) {
        for (StateEnum state : StateEnum.values()) {
            if (state.code.equals(code)) {
                return state.desc;
            }
        }
        return null;
    }

    /**
     * @Description: 根据状态获取details
     * @param:  * @param code 状态
     * @return: java.lang.String
     */
    public static String getDetails(Integer code) {
        for (StateEnum state : StateEnum.values()) {
            if (state.code.equals(code)) {
                return state.details;
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
        for (StateEnum state : StateEnum.values()){
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

    public void setDetails(String details) {
        this.details = details;
    }
}
