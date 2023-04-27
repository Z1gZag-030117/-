package com.wjh.www.service;

import com.wjh.www.po.User;

/**
 * @author wjh
 */
public interface UserService {
    /**
     * 增加一个用户
     *
     * @param user 被封装成一个user对象的用户的数据
     * @return 返回布尔值（true表示操作成功）
     */
    boolean saveUser(User user);

    /**
     * 查询约束条件下的用户
     *
     * @param conditionUser 被封装成user对象的约束条件
     * @return 返回一个user对象
     */
    User findUser(User conditionUser);

    /**
     * 根据约束条件修改用户信息
     *
     * @param user      新的用户信息，被封装成一个user对象
     * @param loginName 约束条件，根据loginName来修改
     * @return 返回布尔值（true表示操作成功）
     */
    boolean modifyUserByLoginName(User user, String loginName);

    /**
     * 查询指定用户名是否存在
     *
     * @param conditionUser 被封装成成user对象的约束条件
     * @return 返回布尔值（true表示操作成功）
     */
    boolean findIsExistUserName(User conditionUser);
}
