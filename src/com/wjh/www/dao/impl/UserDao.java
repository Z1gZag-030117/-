package com.wjh.www.dao.impl;

import com.wjh.www.po.User;

public interface UserDao {
    /**
     * 向user表插入一条数据
     *
     * @param user 被封装成一个user对象的一条数据
     * @return 返回布尔值（true表示操作成功）
     */
    boolean insertUser(User user);

    /**
     * 查询user表中的一条数据
     *
     * @param conditionUser 被封装成user对象的where条件
     * @return 返回布尔值（true表示操作成功）
     */
    User getUser(User conditionUser);

    /**
     * 更新user表中的一条数据
     *
     * @param user      被封装成user对象的一条新数据
     * @param loginName where条件，通过loginName来更新
     * @return 返回布尔值（true表示操作成功）
     */
    boolean updateUserByLoginName(User user, String loginName);

    /**
     * 查询user表中是否存在一条指定的数据
     *
     * @param conditionUser 被封装成user对象的where条件
     * @return 返回布尔值（true表示操作成功）
     */
    boolean getIsExistUserName(User conditionUser);
}
