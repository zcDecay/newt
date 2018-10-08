package com.newt.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 角色枚举
 */
@Getter
@AllArgsConstructor
public enum RoleEnum {

    ONE(1001, "凝气"),

    TWO(1002, "筑基"),

    THREE(1003, "结丹"),

    FOUR(1004, "元婴"),

    FIVE(1005, "化神"),

    SIX(1006, "婴变"),

    SEVEN(1007, "问鼎");
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
        for (RoleEnum state : RoleEnum.values()) {
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
}
