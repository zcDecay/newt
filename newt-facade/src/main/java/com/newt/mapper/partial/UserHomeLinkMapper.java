package com.newt.mapper.partial;

import com.newt.pojo.partial.UserHomeLink;
import com.newt.pojo.partial.UserHomeLinkExample;
import com.newt.utils.mapper.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
* Created by Mybatis Generator on 2018/10/18
*/
public interface UserHomeLinkMapper extends BaseMapper<UserHomeLink> {
    long countByExample(UserHomeLinkExample example);

    int deleteByExample(UserHomeLinkExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserHomeLink record);

    int insertSelectiveList(@Param("records") List<UserHomeLink> records);

    int insertList(@Param("records") List<UserHomeLink> records);

    int insertSelective(UserHomeLink record);

    List<UserHomeLink> selectByExample(UserHomeLinkExample example);

    UserHomeLink selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserHomeLink record, @Param("example") UserHomeLinkExample example);

    int updateByExample(@Param("record") UserHomeLink record, @Param("example") UserHomeLinkExample example);

    int updateByPrimaryKeySelective(UserHomeLink record);

    int updateByPrimaryKey(UserHomeLink record);
}