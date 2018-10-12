package com.newt.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Description 路由
 * @Author zcc
 * @Date 18/10/12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RouterTree {

    private String path;

    private String component;

    private String name;

    private List<RouterTree> children;
}
