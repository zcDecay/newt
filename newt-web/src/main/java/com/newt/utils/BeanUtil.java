package com.newt.utils;

import com.newt.pojo.partial.User;
import com.newt.pojo.vo.UserVo;

/**
 *  Bean转换
 */
public class BeanUtil {
    public static UserVo copyUserToUserVo (User user){
        UserVo userVo = new UserVo();
        userVo.setId(user.getId());
        userVo.setOldLoginIp(user.getLoginIp());
        userVo.setOldLoginTime(user.getOldLoginTime());
        userVo.setLoginIp(WebUtil.getIP());
        userVo.setLoginNum(user.getLoginNum() + 1);
        userVo.setLoginTime(DateTimeUtil.getTimeStamp());

        return userVo;
    }
}
