package com.newt.mapper.partial;

import com.newt.pojo.partial.User;
import com.newt.pojo.partial.UserExample;
import com.newt.utils.mapper.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
* Created by Mybatis Generator on 2018/09/18
*/
public interface UserMapper extends BaseMapper<User> {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int insert(User record);

    int insertSelectiveList(@Param("records") List<User> records);

    int insertList(@Param("records") List<User> records);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);
}