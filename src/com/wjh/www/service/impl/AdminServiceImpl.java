package com.wjh.www.service.impl;

import com.wjh.www.dao.impl.AdminDaoImpl;
import com.wjh.www.dao.AdminDao;
import com.wjh.www.po.Admin;
import com.wjh.www.service.AdminService;

/**
 * @author wjh
 */
public class AdminServiceImpl implements AdminService {
    private final AdminDao adminDao = new AdminDaoImpl();

    @Override
    public Admin findAdmin(Admin conditionAdmin) {
        return adminDao.getAdmin(conditionAdmin);
    }

    @Override
    public boolean removeAdmin(Admin conditionAdmin) {
        return adminDao.deleteAdmin(conditionAdmin);
    }

    @Override
    public boolean saveAdmin(Admin admin) {
        return adminDao.insertAdmin(admin);
    }
}
