package com.newt.pojo.partial;

import java.io.Serializable;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* Created by Mybatis Generator on 2018/10/18
*/
@Table(name = "user_home_link")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserHomeLink implements Serializable {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户id
     */
    @Column(name = "USER_ID")
    private Integer userId;

    /**
     * 链接
     */
    @Column(name = "LINK")
    private String link;

    private static final long serialVersionUID = 1L;
}