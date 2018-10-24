package com.newt.utils;

import com.newt.enums.RoleEnum;
import com.newt.pojo.partial.User;
import com.newt.pojo.vo.UserVo;

/**
 * Bean转换
 */
public class BeanUtil {
    public static UserVo copyUserToUserVo(User user, Boolean isAlter) {
        UserVo userVo = new UserVo();
        userVo.setId(user.getId());
        userVo.setLoginNum(user.getLoginNum() + 1);
        if (isAlter) {
            userVo.setLoginIp(WebUtil.getIP());
            userVo.setOldLoginIp(user.getLoginIp());
            userVo.setLoginTime(DateTimeUtil.nowTimeStamp());
            userVo.setOldLoginTime(user.getLoginTime());
            userVo.setRoleId(user.getRoleId());

        } else {
            userVo.setLoginIp(user.getLoginIp());
            userVo.setOldLoginIp(user.getOldLoginIp());
            userVo.setLoginTime(user.getLoginTime());
            userVo.setOldLoginTime(user.getOldLoginTime());
            userVo.setRoleId(RoleEnum.getNum(user.getRoleId()));
        }
        userVo.setEmail(user.getEmail());
        userVo.setPickName(user.getPickName());
        userVo.setSignature(user.getSignature());
        userVo.setState(user.getState());
        userVo.setUserIcon(user.getUserIcon());
        userVo.setFavicon(user.getFavicon());
        userVo.setUserPhone(user.getUserPhone());
        userVo.setCreateTime(user.getCreateTime());
        userVo.setUpdateTime(user.getUpdateTime());
        userVo.setCause(user.getCause());

        return userVo;
    }
}
