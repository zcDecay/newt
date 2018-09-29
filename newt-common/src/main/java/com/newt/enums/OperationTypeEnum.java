package com.newt.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

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
