package com.newt.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 操作枚举
 */
@Getter
@AllArgsConstructor
public enum OperationEnum {

    SUCCESS(1, "成功"),

    FAILD(2, "失败");

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
