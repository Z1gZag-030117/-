package com.wjh.www.service;

import com.wjh.www.po.Admin;

/**
 * @author wjh
 */
public interface AdminService {
    /**
     * 通过约束条件找到一个管理员的个人信息
     *
     * @param conditionAdmin 约束条件，被封装成一个admin集合
     * @return 返回一个被封装好数据的admin集合
     */
    Admin findAdmin(Admin conditionAdmin);

    /**
     * 通过约束条件删除一个管理员
     *
     * @param conditionAdmin 约束条件，被封装成一个admin对象
     * @return 返回布尔值（true表示操作成功）
     */
    boolean removeAdmin(Admin conditionAdmin);

    /**
     * 添加一个管理员
     *
     * @param admin 被添加的管理员的数据，已经被封装成一个admin对象
     * @return 返回布尔值（true表示操作成功）
     */
    boolean saveAdmin(Admin admin);
}
