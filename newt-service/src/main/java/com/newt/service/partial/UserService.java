package com.newt.service.partial;

import com.newt.mapper.partial.UserMapper;
import com.newt.pojo.partial.User;
import com.newt.pojo.partial.UserExample;
import com.newt.utils.CommitUtil;
import com.newt.utils.EmptyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description user
 * @Author zcc
 * @Date 18/09/29
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * @Description: 查找用户
     * @param:  * @param pickName
     * @return: com.newt.pojo.partial.User
     */
    public User findByLoginName (String pickName){
        UserExample example = new UserExample();
        example.createCriteria().andPickNameLikeInsensitive(pickName);
        List<User> users = userMapper.selectByExample(example);

        return EmptyUtil.isEmpty(users) ? null : users.get(0);
    }
    /**
     * @Description: 更新用户信息
     * @param:  * @param user
     * @return: boolean
     */
    public boolean updateUser(User user){
        return CommitUtil.isCommit(userMapper.updateByPrimaryKeySelective(user));
    }

    /**
     * @Description: 查找用户
     * @return: com.newt.pojo.partial.User
     */
    public User findAllUser (){
        UserExample example = new UserExample();
        List<User> users = userMapper.selectByExample(example);

        return EmptyUtil.isEmpty(users) ? null : users.get(0);
    }
}
