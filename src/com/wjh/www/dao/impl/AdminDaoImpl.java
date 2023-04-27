package com.wjh.www.dao.impl;

import com.wjh.www.annotation.Table;
import com.wjh.www.dao.AdminDao;
import com.wjh.www.dao.BaseDao;
import com.wjh.www.po.Admin;

import java.util.List;


/**
 * @author wjh
 */
public class AdminDaoImpl implements AdminDao {
    private final BaseDao baseDao = new BaseDaoImpl();
    private final String TABLE_NAME = Admin.class.getAnnotation(Table.class).value();

    @Override
    public Admin getAdmin(Admin conditionAdmin) {
        Class clazz = Admin.class;
        String fields = "admin_id,login_name,login_pwd,admin_name,admin_description,admin_circle";
        List<Admin> adminList = baseDao.select(conditionAdmin, Admin.class, fields, TABLE_NAME);
        if (adminList.size() == 0) {
            return null;
        } else {
            return adminList.get(0);
        }
    }

    @Override
    public boolean deleteAdmin(Admin conditionAdmin) {
        return baseDao.delete(conditionAdmin);
    }

    @Override
    public boolean insertAdmin(Admin admin) {
        return baseDao.insert(admin);
    }
}
