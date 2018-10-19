package com.newt.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.*;

/**
 * 角色枚举
 */
@Getter
@AllArgsConstructor
public enum RoleEnum {

    ONE(1001, 1, "凝气"),

    TWO(1002, 2, "筑基"),

    THREE(1003, 3, "结丹"),

    FOUR(1004, 4, "元婴"),

    FIVE(1005, 5, "化神"),

    SIX(1006, 6, "婴变"),

    SEVEN(1007, 7, "问鼎");
    /**
     * 枚举状态
     */
    private Integer code;
    /**
     *
     */
    private Integer num;
    /**
     * 枚举详情
     */
    private String desc;


    public void setCode(int code) {
        this.code = code;
    }

    public void setNum(Integer num) {
        this.num = num;
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
        for (RoleEnum state : RoleEnum.values()) {
            if (state.code.equals(code)) {
                return state.desc;
            }
        }
        return null;
    }

    /**
     * @Description: 根据编号得到code
     * @param: * @param num 编号
     * @return: java.lang.Integer
     */
    public static Integer getCode(Integer num) {
        for (RoleEnum state : RoleEnum.values()) {
            if (state.num.equals(num)) {
                return state.code;
            }
        }
        return null;
    }

    /**
     * @Description: 根据code得到编号
     * @param: * @param code
     * @return: java.lang.Integer
     */
    public static Integer getNum(Integer code) {
        for (RoleEnum state : RoleEnum.values()) {
            if (state.code.equals(code)) {
                return state.num;
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
        for (RoleEnum state : RoleEnum.values()) {
            map.put(state.getNum(), state.getDesc());
        }
        return map;
    }

    public static List<Map<String, String>> getList() {

        ArrayList<Map<String, String>> list = new ArrayList<>(RoleEnum.values().length);
        for (RoleEnum state : RoleEnum.values()) {
            Map<String, String> map = new LinkedHashMap<>();
            map.put("value", state.getCode().toString());
            map.put("label", state.getDesc());
            list.add(map);
        }
        return list;
    }

    public static Object[] getDescList() {

        return Arrays.stream(RoleEnum.values()).map(element -> element.desc).toArray();
    }
}
