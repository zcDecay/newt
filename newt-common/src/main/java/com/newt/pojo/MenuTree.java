package com.newt.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Description MenuTree
 * @Author zcc
 * @Date 18/10/12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MenuTree {

    private MenuEntity entity;

    private List<MenuTree> childs;
}
