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
        userVo.setOldLoginTime(user.getLoginTime());
        userVo.setLoginIp(WebUtil.getIP());
        userVo.setLoginNum(user.getLoginNum() + 1);
        userVo.setLoginTime(DateTimeUtil.getTimeStamp());
        userVo.setEmail(user.getEmail());
        userVo.setPickName(user.getPickName());
        userVo.setRoleId(user.getRoleId());
        userVo.setSignature(user.getSignature());
        userVo.setState(user.getState());
        userVo.setUserIcon(user.getUserIcon());
        userVo.setFavicon(user.getFavicon());
        userVo.setUserPhone(user.getUserPhone());
        userVo.setCreateTime(user.getCreateTime());
        userVo.setUpdateTime(user.getUpdateTime());

        return userVo;
    }
}
