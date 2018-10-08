package com.newt.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 操作类型枚举
 */
@Getter
@AllArgsConstructor
public enum OperationTypeEnum {

    LOGIN(1, "登录"),

    ADD(2, "新增"),

    DELETE(3,"删除"),

    UPDATE(4,"修改"),

    SEE(5,"查看"),

    QUERY(6,"查询");

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
        for (OperationTypeEnum state : OperationTypeEnum.values()) {
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
