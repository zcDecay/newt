package com.newt.pojo.partial;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

public class User implements Serializable {
    /**
     * 用户id
     */
    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    /**
     * 创建用户时间
     */
    @Column(name = "CREATE_TIME")
    private Date createTime;

    /**
     * 邮件
     */
    @Column(name = "EMAIL")
    private String email;

    /**
     * 登录IP
     */
    @Column(name = "LOGIN_IP")
    private Date loginIp;

    /**
     * 登录次数
     */
    @Column(name = "LOGIN_NUM")
    private Integer loginNum;

    /**
     * 登录时间
     */
    @Column(name = "LOGIN_TIME")
    private Date loginTime;

    /**
     * 上一次登录IP
     */
    @Column(name = "OLD_LOGIN_IP")
    private Date oldLoginIp;

    /**
     * 上一次登录时间
     */
    @Column(name = "OLG_LOGIN_TIME")
    private Date olgLoginTime;

    /**
     * 昵称
     */
    @Column(name = "PICK_NAME")
    private String pickName;

    /**
     * 角色ID
     */
    @Column(name = "ROLE_ID")
    private String roleId;

    /**
     * 盐值
     */
    @Column(name = "SALT")
    private String salt;

    /**
     * 个性签名
     */
    @Column(name = "SIGNATURE")
    private String signature;

    /**
     * 用户状态
     */
    @Column(name = "STATE")
    private Integer state;

    /**
     * 更新时间
     */
    @Column(name = "UPDATE_TIME")
    private Date updateTime;

    /**
     * 用户头像
     */
    @Column(name = "USER_ICON")
    private String userIcon;

    /**
     * 用户手机号
     */
    @Column(name = "USER_PHONE")
    private String userPhone;

    /**
     * 用户密码
     */
    @Column(name = "USER_PWD")
    private String userPwd;

    private static final long serialVersionUID = 1L;

    /**
     * 获取用户id
     *
     * @return USER_ID - 用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取创建用户时间
     *
     * @return CREATE_TIME - 创建用户时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建用户时间
     *
     * @param createTime 创建用户时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取邮件
     *
     * @return EMAIL - 邮件
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮件
     *
     * @param email 邮件
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 获取登录IP
     *
     * @return LOGIN_IP - 登录IP
     */
    public Date getLoginIp() {
        return loginIp;
    }

    /**
     * 设置登录IP
     *
     * @param loginIp 登录IP
     */
    public void setLoginIp(Date loginIp) {
        this.loginIp = loginIp;
    }

    /**
     * 获取登录次数
     *
     * @return LOGIN_NUM - 登录次数
     */
    public Integer getLoginNum() {
        return loginNum;
    }

    /**
     * 设置登录次数
     *
     * @param loginNum 登录次数
     */
    public void setLoginNum(Integer loginNum) {
        this.loginNum = loginNum;
    }

    /**
     * 获取登录时间
     *
     * @return LOGIN_TIME - 登录时间
     */
    public Date getLoginTime() {
        return loginTime;
    }

    /**
     * 设置登录时间
     *
     * @param loginTime 登录时间
     */
    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    /**
     * 获取上一次登录IP
     *
     * @return OLD_LOGIN_IP - 上一次登录IP
     */
    public Date getOldLoginIp() {
        return oldLoginIp;
    }

    /**
     * 设置上一次登录IP
     *
     * @param oldLoginIp 上一次登录IP
     */
    public void setOldLoginIp(Date oldLoginIp) {
        this.oldLoginIp = oldLoginIp;
    }

    /**
     * 获取上一次登录时间
     *
     * @return OLG_LOGIN_TIME - 上一次登录时间
     */
    public Date getOlgLoginTime() {
        return olgLoginTime;
    }

    /**
     * 设置上一次登录时间
     *
     * @param olgLoginTime 上一次登录时间
     */
    public void setOlgLoginTime(Date olgLoginTime) {
        this.olgLoginTime = olgLoginTime;
    }

    /**
     * 获取昵称
     *
     * @return PICK_NAME - 昵称
     */
    public String getPickName() {
        return pickName;
    }

    /**
     * 设置昵称
     *
     * @param pickName 昵称
     */
    public void setPickName(String pickName) {
        this.pickName = pickName == null ? null : pickName.trim();
    }

    /**
     * 获取角色ID
     *
     * @return ROLE_ID - 角色ID
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * 设置角色ID
     *
     * @param roleId 角色ID
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    /**
     * 获取盐值
     *
     * @return SALT - 盐值
     */
    public String getSalt() {
        return salt;
    }

    /**
     * 设置盐值
     *
     * @param salt 盐值
     */
    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    /**
     * 获取个性签名
     *
     * @return SIGNATURE - 个性签名
     */
    public String getSignature() {
        return signature;
    }

    /**
     * 设置个性签名
     *
     * @param signature 个性签名
     */
    public void setSignature(String signature) {
        this.signature = signature == null ? null : signature.trim();
    }

    /**
     * 获取用户状态
     *
     * @return STATE - 用户状态
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置用户状态
     *
     * @param state 用户状态
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 获取更新时间
     *
     * @return UPDATE_TIME - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取用户头像
     *
     * @return USER_ICON - 用户头像
     */
    public String getUserIcon() {
        return userIcon;
    }

    /**
     * 设置用户头像
     *
     * @param userIcon 用户头像
     */
    public void setUserIcon(String userIcon) {
        this.userIcon = userIcon == null ? null : userIcon.trim();
    }

    /**
     * 获取用户手机号
     *
     * @return USER_PHONE - 用户手机号
     */
    public String getUserPhone() {
        return userPhone;
    }

    /**
     * 设置用户手机号
     *
     * @param userPhone 用户手机号
     */
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    /**
     * 获取用户密码
     *
     * @return USER_PWD - 用户密码
     */
    public String getUserPwd() {
        return userPwd;
    }

    /**
     * 设置用户密码
     *
     * @param userPwd 用户密码
     */
    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd == null ? null : userPwd.trim();
    }
}