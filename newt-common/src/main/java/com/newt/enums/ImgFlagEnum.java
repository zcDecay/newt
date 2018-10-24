package com.newt.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.LinkedHashMap;
import java.util.Map;

@Getter
@AllArgsConstructor
public enum ImgFlagEnum {

    ICON("userIcon", "用户头像"),

    FAVICON("favicon", "favicon");
    /**
     * 枚举状态
     */
    private String code;
    /**
     * 枚举详情
     */
    private String desc;

    public void setCode(String code) {
        this.code = code;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * @Description: 输入code,判断是否存在
     * @param:  * @param flag
     * @return: boolean
     */
    public static boolean isExist(String flag){
        for (ImgFlagEnum state : ImgFlagEnum.values()) {
            if (state.getCode().equals(flag)){
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }
    /**
     * @Description: 根据状态获取详情
     * @param: * @param code 状态
     * @return: java.lang.String
     */
    public static String getDesc(Integer code) {
        for (ImgFlagEnum state : ImgFlagEnum.values()) {
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
    public static Map<String, String> getMap() {
        Map<String, String> map = new LinkedHashMap<>();
        for (ImgFlagEnum state : ImgFlagEnum.values()) {
            map.put(state.getCode(), state.getDesc());
        }
        return map;
    }
}
