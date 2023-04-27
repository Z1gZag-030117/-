package com.wjh.www.view;

import com.wjh.www.util.ConnectionPool;
import com.wjh.www.view.AdminView.LoginView;

public class Main {
    public static ConnectionPool connectionPool = null;

    public Main() {
        /*
        创建数据库连接池
         */
        connectionPool = new ConnectionPool();
    }

    /**
     * 主方法，程序的入口
     */
    public static void main(String[] args) {
        /*
        在用户执行登录操作之前就需要创建数据库连接池了
         */
        new Main();
        new LoginView();
    }
}
