package com.wjh.www.dao.impl;

import com.wjh.www.annotation.Table;
import com.wjh.www.dao.BaseDao;
import com.wjh.www.po.User;

import java.util.List;

/**
 * @author wjh
 */
public class UserDaoImpl implements UserDao {
    private final BaseDao baseDao = new BaseDaoImpl();
    private final String TABLE_NAME = User.class.getAnnotation(Table.class).value();

    @Override
    public boolean insertUser(User user) {
        return baseDao.insert(user);
    }

    @Override
    public User getUser(User conditionUser) {
        String fields = "login_name,login_pwd,user_name,user_sex,user_birthday,user_description";
        List<User> userList = baseDao.select(conditionUser, User.class, fields, TABLE_NAME);
        if (userList.size() == 0) {
            return null;
        } else {
            return userList.get(0);
        }
    }

    @Override
    public boolean updateUserByLoginName(User user, String loginName) {
        return baseDao.update(user, Thread.currentThread().getStackTrace()[1].getMethodName(), loginName);
    }

    @Override
    public boolean getIsExistUserName(User conditionUser) {
        String fields = "user_name";
        List<User> userList = baseDao.select(conditionUser, User.class, fields, TABLE_NAME);
        return userList.size() > 0;
    }
}
