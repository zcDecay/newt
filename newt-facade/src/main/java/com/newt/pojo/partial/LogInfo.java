package com.newt.pojo.partial;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* Created by Mybatis Generator on 2018/09/30
*/
@Table(name = "log_info")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LogInfo implements Serializable {
    /**
     * 记录id
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 操作用户
     */
    @Column(name = "USER_ID")
    private Integer userId;

    /**
     * 操作接口
     */
    @Column(name = "OPERATION_FUNCTION")
    private String operationFunction;

    /**
     * IP地址
     */
    @Column(name = "IP")
    private String ip;

    /**
     * 操作类型(1:登录，2：新增，3：删除，4：修改，5：查看)
     */
    @Column(name = "OPERATION_TYPE")
    private Integer operationType;

    /**
     * 操作结果（1：成功，2：失败）
     */
    @Column(name = "OPERATION_RESULT")
    private Integer operationResult;

    /**
     * 操作用户名称
     */
    @Column(name = "OPERATION_PICK_NAME")
    private String operationPickName;

    /**
     * 记录创建时间
     */
    @Column(name = "GMT_CREATE")
    private String gmtCreate;

    /**
     * 记录修改时间
     */
    @Column(name = "GMT_MODIFIED")
    private String gmtModified;

    /**
     * 消息（操作信息）
     */
    @Column(name = "OPERATION_MSG")
    private String operationMsg;

    @Column(name = "OPERATION_TIME")
    private Date operationTime;

    private static final long serialVersionUID = 1L;
}