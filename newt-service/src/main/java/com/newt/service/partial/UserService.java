package com.newt.service.partial;

import com.newt.enums.NumberEnum;
import com.newt.enums.RoleEnum;
import com.newt.enums.StateEnum;
import com.newt.mapper.partial.UserMapper;
import com.newt.pojo.partial.User;
import com.newt.pojo.partial.UserExample;
import com.newt.pojo.vo.UserVo;
import com.newt.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    @Value("${favicon}")
    private String favicon;

    @Value("${userIcon}")
    private String userIcon;

    /**
     * @Description: 查找用户
     * @param: * @param pickName
     * @return: com.newt.pojo.partial.User
     */
    public User findByLoginName(String pickName) {
        UserExample example = new UserExample();
        example.createCriteria().andPickNameLikeInsensitive(pickName);
        List<User> users = userMapper.selectByExample(example);

        return EmptyUtil.isEmpty(users) ? null : users.get(NumberEnum.ZERO.getCode());
    }

    /**
     * @Description: 更新用户信息
     * @param: * @param user
     * @return: boolean
     */
    public boolean updateUser(User user) {
        return CommitUtil.isCommit(userMapper.updateByPrimaryKeySelective(user));
    }

    /**
     * @Description: 查找用户
     * @return: com.newt.pojo.partial.User
     */
    public List<User> findAllUser() {
        UserExample example = new UserExample();
        List<User> users = userMapper.selectByExample(example);

        return users;
    }

    /**
     * @Description: 查找用户通过昵称
     * @return: com.newt.pojo.partial.User
     */
    public Boolean selectUserByPickName(User user) {
        UserExample example = new UserExample();
        if (EmptyUtil.isEmpty(user)) {
            return null;
        }
        if (EmptyUtil.isEmpty(user.getPickName())) {
            return null;
        }
        example.createCriteria().andPickNameEqualTo(user.getPickName());
        List<User> users = userMapper.selectByExample(example);

        return EmptyUtil.isNotEmpty(users);
    }

    /**
     * @Description: 保存注册用户
     * @param: * @param user
     * @return: com.newt.pojo.partial.User
     */
    public boolean saveUser(User user) {
        Date timeStamp = DateTimeUtil.getTimeStamp();
        String salt = IDUtil.getRandomNumberByLength(NumberEnum.FIVE.getCode());
        String userPwd = PasswordUtil.encryptPassword(salt, user.getUserPwd());

        user = User.builder()
                .createTime(timeStamp)
                .salt(salt)
                .roleId(RoleEnum.ONE.getCode())
                .favicon(favicon)
                .state(StateEnum.NORMAL.getCode())
                .userIcon(userIcon)
                .userPwd(userPwd)
                .pickName(user.getPickName())
                .email(user.getEmail())
                .userPhone(user.getUserPhone())
                .build();

        return CommitUtil.isCommit(userMapper.insertSelective(user));
    }


    public boolean updateUserState(User user) {
        Integer state = StateEnum.reverseCode(user.getState());
        user.setState(state);

        return CommitUtil.isCommit(userMapper.updateByPrimaryKeySelective(user));
    }
}
