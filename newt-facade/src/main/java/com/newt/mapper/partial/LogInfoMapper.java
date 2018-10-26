package com.newt.mapper.partial;

import com.newt.pojo.partial.LogInfo;
import com.newt.pojo.partial.LogInfoExample;
import com.newt.utils.mapper.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
* Created by Mybatis Generator on 2018/10/26
*/
public interface LogInfoMapper extends BaseMapper<LogInfo> {
    long countByExample(LogInfoExample example);

    int deleteByExample(LogInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LogInfo record);

    int insertSelectiveList(@Param("records") List<LogInfo> records);

    int insertList(@Param("records") List<LogInfo> records);

    int insertSelective(LogInfo record);

    List<LogInfo> selectByExample(LogInfoExample example);

    LogInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") LogInfo record, @Param("example") LogInfoExample example);

    int updateByExample(@Param("record") LogInfo record, @Param("example") LogInfoExample example);

    int updateByPrimaryKeySelective(LogInfo record);

    int updateByPrimaryKey(LogInfo record);
}