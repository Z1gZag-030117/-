package com.wjh.www.service.impl;

import com.wjh.www.dao.impl.UserDaoImpl;
import com.wjh.www.dao.impl.UserDao;
import com.wjh.www.po.User;
import com.wjh.www.service.UserService;

/**
 * @author wjh
 */
public class UserServiceImpl implements UserService {
    private final UserDao userDao = new UserDaoImpl();

    @Override
    public boolean saveUser(User user) {
        return userDao.insertUser(user);
    }

    @Override
    public User findUser(User conditionUser) {
        return userDao.getUser(conditionUser);
    }

    @Override
    public boolean modifyUserByLoginName(User user, String loginName) {
        return userDao.updateUserByLoginName(user, loginName);
    }

    @Override
    public boolean findIsExistUserName(User conditionUser) {
        return userDao.getIsExistUserName(conditionUser);
    }
}
