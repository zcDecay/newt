package com.newt.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 数字枚举
 */
@Getter
@AllArgsConstructor
public enum NumberEnum {

    ZERO(0,"0"),

    ONE(1, "1"),

    TWO(2, "2"),

    THEREE(3, "3"),

    FOUR(4, "4"),

    FIVE(5, "5"),

    SIX(6, "6"),

    SEVEN(7, "7"),

    EIGHT(8, "8"),

    NINE(9, "9"),

    TEN(10,"10");

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
     * @param: * @param code 状态
     * @return: java.lang.String
     */
    public static String getDesc(Integer code) {
        for (NumberEnum state : NumberEnum.values()) {
            if (state.code.equals(code)) {
                return state.desc;
            }
        }
        return null;
    }

    /**
     * @Description: 获取map集合
     * @param: * @param
     * @return: java.util.Map<java.lang.String,java.lang.String>
     */
    public static Map<Integer, String> getMap() {
        Map<Integer, String> map = new LinkedHashMap<>();
        for (NumberEnum state : NumberEnum.values()) {
            map.put(state.getCode(), state.getDesc());
        }
        return map;
    }
    }
