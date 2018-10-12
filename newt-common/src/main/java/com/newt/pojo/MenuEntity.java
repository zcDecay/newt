package com.newt.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description 惨淡书
 * @Author zcc
 * @Date 18/10/10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MenuEntity {

    private Integer id;

    private Integer pid;

    private String name;

    private String desc;

    private String icon;

    private String path;


}
