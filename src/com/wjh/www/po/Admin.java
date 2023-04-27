package com.wjh.www.po;

import com.wjh.www.annotation.Column;
import com.wjh.www.annotation.Table;

import java.util.Objects;

/**
 * 该实体类对应数据库中的admin表
 * @author 26913
 */
@Table(value = "admin")
public class Admin {
    /**
     * admin表的主键，不具有业务效应，仅保证唯一性
     */
    @Column(value = "admin_id")
    private String adminId;
    /**
     * 管理员的登录账号
     */
    @Column(value = "login_name")
    private String loginName;
    /**
     * 管理员的登录密码
     */
    @Column(value = "login_pwd")
    private String loginPwd;
    /**
     * 管理员的昵称
     */
    @Column(value = "admin_name")
    private String adminName;
    /**
     * 管理员的个人介绍、描述
     */
    @Column(value = "admin_description")
    private String adminDescription;
    /**
     * 管理员所管理的瓜圈
     */
    @Column(value = "admin_circle")
    private String adminCircle;

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = new String(String.valueOf(adminId));
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminDescription() {
        return adminDescription;
    }

    public void setAdminDescription(String adminDescription) {
        this.adminDescription = adminDescription;
    }

    public String getAdminCircle() {
        return adminCircle;
    }

    public void setAdminCircle(String adminCircle) {
        this.adminCircle = adminCircle;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminId='" + adminId + '\'' +
                ", loginName='" + loginName + '\'' +
                ", loginPwd='" + loginPwd + '\'' +
                ", adminName='" + adminName + '\'' +
                ", adminDescription='" + adminDescription + '\'' +
                ", adminCircle='" + adminCircle + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Admin admin = (Admin) o;
        return Objects.equals(adminId, admin.adminId) && Objects.equals(loginName, admin.loginName) && Objects.equals(loginPwd, admin.loginPwd) && Objects.equals(adminName, admin.adminName) && Objects.equals(adminDescription, admin.adminDescription) && Objects.equals(adminCircle, admin.adminCircle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adminId, loginName, loginPwd, adminName, adminDescription, adminCircle);
    }
}
