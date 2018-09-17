package com.newt.utils.mapper;

import java.io.Serializable;

/**
 * @Description 通用mapper
 * @Author zcc
 * @Date 18/09/17
 */
public interface BaseMapper<T> {

    int deleteByPrimaryKey(Object id);

    int insert(T record);

    int insertSelective(T record);

    T selectByPrimaryKey(Object id);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKeyWithBLOBs(T record);

    int updateByPrimaryKey(T record);

}
