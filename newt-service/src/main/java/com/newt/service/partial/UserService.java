package com.newt.service.partial;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.newt.enums.NumberEnum;
import com.newt.enums.RoleEnum;
import com.newt.enums.StateEnum;
import com.newt.mapper.partial.UserMapper;
import com.newt.pojo.partial.User;
import com.newt.pojo.partial.UserExample;
import com.newt.pojo.vo.UserVo;
import com.newt.utils.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.ParseException;
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
    public List<User> findAllUser(int pageNum, int pageSize, String orderBy,
                                      User user) throws ParseException {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotEmpty(user.getPickName())) {
            criteria.andPickNameLike("%" + user.getPickName() + "%");
        }
        if (StringUtils.isNotEmpty(user.getUserPhone())) {
            criteria.andUserPhoneLike("%" + user.getUserPhone() + "%");
        }
        if (EmptyUtil.isNotEmpty(user.getRoleId())) {
            criteria.andRoleIdEqualTo(user.getRoleId());
        }
        if (EmptyUtil.isNotEmpty(user.getCreateTime())) {
            criteria.andCreateTimeLessThanOrEqualTo(DateUtil.getDayEndTime(user.getCreateTime()));
        }
        if (EmptyUtil.isNotEmpty(user.getLoginTime())) {
            criteria.andLoginTimeLessThanOrEqualTo(DateUtil.getDayEndTime(user.getLoginTime()));
        }


        PageHelper.startPage(pageNum, pageSize, orderBy);
        List<User> userList = userMapper.selectByExample(example);

        return userList;
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
        Date timeStamp = DateTimeUtil.nowTimeStamp();
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


    /**
     * @Description: 更新用户状态
     * @param: * @param user
     * @return: boolean
     */
    public boolean updateUserState(User user) {
        Integer state = StateEnum.reverseCode(user.getState());
        user.setState(state);

        return CommitUtil.isCommit(userMapper.updateByPrimaryKeySelective(user));
    }

    /**
     * @Description: 删除用户
     * @param: * @param id
     * @return: boolean
     */
    public boolean deleteById(Integer id) {

        return CommitUtil.isCommit(userMapper.deleteByPrimaryKey(id));
    }
}
