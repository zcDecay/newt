package com.newt.pojo.vo;

import com.newt.pojo.partial.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Description UserVo
 * @Author zcc
 * @Date 18/09/26
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVo extends User{
    /**
     * 用户id
     */
    private Integer id;

    /**
     * 创建用户时间
     */
    private Date createTime;

    /**
     * 邮件
     */
    private String email;

    /**
     * 登录IP
     */
    private String loginIp;

    /**
     * 登录次数
     */
    private Integer loginNum;

    /**
     * 登录时间
     */
    private Date loginTime;

    /**
     * 上一次登录IP
     */
    private String oldLoginIp;

    /**
     * 上一次登录时间
     */
    private Date oldLoginTime;

    /**
     * 昵称
     */
    private String pickName;

    /**
     * 角色ID
     */
    private Integer roleId;


    /**
     * 个性签名
     */
    private String signature;

    /**
     * 用户状态
     */
    private Integer state;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 用户头像
     */
    private String userIcon;

    /**
     * ico
     */
    private String favicon;

    /**
     * 用户手机号
     */
    private String userPhone;

    /**
     * 禁封/解封原因
     */
    private String cause;
}
