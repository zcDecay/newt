package com.newt.pojo.partial;

import java.io.Serializable;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* Created by Mybatis Generator on 2018/10/26
*/
@Table(name = "user_role")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRole implements Serializable {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 角色:(筑基、开光、融合、心动、金丹、元婴、出窍、分神、合体、洞虚、大乘、渡劫)
     */
    @Column(name = "ROLE")
    private String role;

    private static final long serialVersionUID = 1L;
}