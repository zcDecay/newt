package com.newt.service.partial;

import com.newt.enums.OperationEnum;
import com.newt.enums.OperationTypeEnum;
import com.newt.mapper.partial.LogInfoMapper;
import com.newt.pojo.partial.LogInfo;
import com.newt.pojo.partial.User;
import com.newt.utils.DateTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description LogInfo
 * @Author zcc
 * @Date 18/09/29
 */
public class LogInfoService {

    @Autowired
    private LogInfoMapper logInfoMapper;

    /**
     * @Description: 保存登录日志
     * @param:  * @param user
     * @param ip
     * @param function
     * @param msg
     * @return: void
     */
    public void saveLogForLogin (User user,String ip, String function, String msg){
        LogInfo log = LogInfo.builder()
                .ip(ip)
                .operationFunction(function)
                .operationMsg(msg)
                .operationResult(OperationEnum.SUCCESS.getCode())
                .operationTime(DateTimeUtil.getTimeStamp())
                .operationType(OperationTypeEnum.LOGIN.getCode())
                .userId(user.getId())
                .operationPickName(user.getPickName())
                .build();
        logInfoMapper.insertSelective(log);
    }
}
