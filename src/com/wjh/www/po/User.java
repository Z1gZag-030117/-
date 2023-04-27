package com.wjh.www.po;

import com.wjh.www.annotation.Column;
import com.wjh.www.annotation.Table;

import java.util.Objects;

/**
 * 该实体类对应数据库中的user表
 * @author 26913
 */
@Table(value = "user")
public class User {
    /**
     * user表的主键，不具有业务逻辑
     */
    @Column(value = "user_id")
    private String userId;
    /**
     * 用户的登录账号
     */
    @Column(value = "login_name")
    private String loginName;
    /**
     * 用户的登录密码
     */
    @Column(value = "login_pwd")
    private String loginPwd;
    /**
     * 用户的昵称
     */
    @Column(value = "user_name")
    private String userName;
    /**
     * 用户的性别
     */
    @Column(value = "user_sex")
    private String userSex;
    /**
     * 用户的生日
     */
    @Column(value = "user_birthday")
    private String userBirthday;
    /**
     * 用户的个人描述
     */
    @Column(value = "user_description")
    private String userDescription;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(String userBirthday) {
        this.userBirthday = userBirthday;
    }

    public String getUserDescription() {
        return userDescription;
    }

    public void setUserDescription(String userDescription) {
        this.userDescription = userDescription;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", loginName='" + loginName + '\'' +
                ", loginPwd='" + loginPwd + '\'' +
                ", userName='" + userName + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userBirthday='" + userBirthday + '\'' +
                ", userDescription='" + userDescription + '\'' +
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
        User user = (User) o;
        return Objects.equals(userId, user.userId) && Objects.equals(loginName, user.loginName) && Objects.equals(loginPwd, user.loginPwd) && Objects.equals(userName, user.userName) && Objects.equals(userSex, user.userSex) && Objects.equals(userBirthday, user.userBirthday) && Objects.equals(userDescription, user.userDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, loginName, loginPwd, userName, userSex, userBirthday, userDescription);
    }
}
