package com.newt.pojo.partial;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* Created by Mybatis Generator on 2018/10/18
*/
@Table(name = "user_menu")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserMenu implements Serializable {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 功能描述
     */
    @Column(name = "MENU_DESC")
    private String menuDesc;

    /**
     * 菜单名称
     */
    @Column(name = "MENU_NAME")
    private String menuName;

    /**
     * 上级菜单ID
     */
    @Column(name = "MENU_PID")
    private Integer menuPid;

    /**
     * 菜单分组ID
     */
    @Column(name = "MENU_GROUP_ID")
    private Integer menuGroupId;

    /**
     * 系统菜单（0：不是，1：是）
     */
    @Column(name = "SYS_DEFAULT")
    private String sysDefault;

    /**
     * 菜单图标
     */
    @Column(name = "MENU_ICON")
    private String menuIcon;

    /**
     * 排序
     */
    @Column(name = "MENU_ORDER")
    private Integer menuOrder;

    /**
     * 创建时间
     */
    @Column(name = "CREATE_TIME")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "UPDATE_TIME")
    private Date updateTime;

    /**
     * 开启状态（0：禁用，1：开启）
     */
    @Column(name = "ENABLE")
    private Integer enable;

    /**
     * 菜单url
     */
    @Column(name = "URL")
    private String url;

    /**
     * 组件
     */
    @Column(name = "COMPONENT")
    private String component;

    private static final long serialVersionUID = 1L;
}