package com.wjh.www.dao;

import com.wjh.www.po.Admin;

/**
 * @author wjh
 */
public interface AdminDao {
    /**
     * 获取admin表中的一条数据
     *
     * @param conditionAdmin 被封装成admin对象的where条件
     * @return 返回一个admin对象
     */
    Admin getAdmin(Admin conditionAdmin);

    /**
     * 删除admin表中的一条数据
     *
     * @param conditionAdmin 被封装成admin对象的where条件
     * @return 返回布尔值（true表示操作成功）
     */
    boolean deleteAdmin(Admin conditionAdmin);

    /**
     * 向insert表插入一条数据
     *
     * @param admin 被插入的一条数据，已经被封装成admin对象
     * @return 返回布尔值（true表示操作成功）
     */
    boolean insertAdmin(Admin admin);
}
