package com.newt.mapper.partial;

import com.newt.pojo.partial.UserMenu;
import com.newt.pojo.partial.UserMenuExample;
import com.newt.utils.mapper.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
* Created by Mybatis Generator on 2018/10/12
*/
public interface UserMenuMapper extends BaseMapper<UserMenu> {
    long countByExample(UserMenuExample example);

    int deleteByExample(UserMenuExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserMenu record);

    int insertSelectiveList(@Param("records") List<UserMenu> records);

    int insertList(@Param("records") List<UserMenu> records);

    int insertSelective(UserMenu record);

    List<UserMenu> selectByExample(UserMenuExample example);

    UserMenu selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserMenu record, @Param("example") UserMenuExample example);

    int updateByExample(@Param("record") UserMenu record, @Param("example") UserMenuExample example);

    int updateByPrimaryKeySelective(UserMenu record);

    int updateByPrimaryKey(UserMenu record);
}