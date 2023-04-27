/*
 * Created by JFormDesigner on Mon Mar 29 16:45:14 CST 2021
 */

package com.wjh.www.view.UserView;

import java.awt.event.*;

import com.wjh.www.po.User;
import com.wjh.www.service.impl.UserServiceImpl;
import com.wjh.www.service.UserService;
import com.wjh.www.view.Main;

import java.awt.*;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author wjh
 */
@SuppressWarnings("all")
public class UserHomeView extends JFrame {
    /**
     * 用户登录时的账号
     */
    private String loginName;
    /**
     * 用户对应的昵称
     */
    private String userName;
    User user = null;

    private final UserService userService = new UserServiceImpl();

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JMenuBar menuBar1;
    private JMenu menu1;
    private JMenuItem inquireMenuItem;
    private JMenuItem alterMenuItem;
    private JMenuItem myLikeIncidentMenuItemActionPerformed;
    private JMenuItem myPublishIncidentMenuItem;
    private JMenuItem exitMenuItem;
    private JMenu menu2;
    private JMenuItem inquireIncidentMenuItem;
    private JMenuItem createIncidentMenuItem;
    private JLabel mainLabel;
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables


    public UserHomeView(String loginName) {
        this.loginName = loginName;
        initComponents();
        this.setVisible(true);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);//最大化
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//设置关闭该窗体即关闭程序
    }

    /**
     * 个人中心下的退出登录选项
     *
     * @param e
     */
    private void exitMenuItemActionPerformed(ActionEvent e) {
        int result = JOptionPane.showConfirmDialog(null, "是否退出系统？");
        if (result == 0) {//点击”确认“的话返回值是0
            /*
            关闭数据库连接池，释放资源
             */
            try {
                Main.connectionPool.closeConnectionPool();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            dispose();
            System.exit(0);
        }
    }

    /**
     * 个人中心下的查询个人信息选项
     *
     * @param e
     */
    private void inquireMenuItemActionPerformed(ActionEvent e) {
        /*
        把查询条件封装成一个user对象
         */
        User conditionUser = new User();
        conditionUser.setLoginName(loginName);
        user = userService.findUser(conditionUser);
        new InquiryUserInformationView(this, user);
    }

    /**
     * 个人中心下的修改个人信息选项
     *
     * @param e
     */
    private void alterMenuItemActionPerformed(ActionEvent e) {
        /*
        把查询条件封装成一个user对象
         */
        User conditionUser = new User();
        conditionUser.setLoginName(loginName);
        user = userService.findUser(conditionUser);
        AlterUserInformationView alterUserInformationView = new AlterUserInformationView(this, user, loginName, userName);
        if (alterUserInformationView.getResult()) {
            dispose();
            new UserHomeView(loginName);
        }
    }

    /**
     * 造瓜下的选择瓜圈
     *
     * @param e
     */
    private void createIncidentMenuItemActionPerformed(ActionEvent e) {
        new ChoicePublishCircleView(this, "选择瓜圈", userName);
    }

    /**
     * 吃瓜下的选择瓜圈
     *
     * @param e
     */
    private void inquireIncidentMenuItemActionPerformed(ActionEvent e) {
        new ChoiceLookCircleView(this, "选择瓜圈", userName);
    }

    /**
     * 查询我收藏的瓜的事件监听
     *
     * @param e
     */
    private void myLikeIncidentMenuItemActionPerformedActionPerformed(ActionEvent e) {
        new InquireCollectionView(this, userName);
    }

    /**
     * 查询我发布的瓜的事件监听
     *
     * @param e
     */
    private void myPublishIncidentMenuItemActionPerformed(ActionEvent e) {
        new InquireMyPublishIncidentView(this, userName);
    }

    /*
    swing布局
     */
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        inquireMenuItem = new JMenuItem();
        alterMenuItem = new JMenuItem();
        myLikeIncidentMenuItemActionPerformed = new JMenuItem();
        myPublishIncidentMenuItem = new JMenuItem();
        exitMenuItem = new JMenuItem();
        menu2 = new JMenu();
        inquireIncidentMenuItem = new JMenuItem();
        createIncidentMenuItem = new JMenuItem();
        mainLabel = new JLabel();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();
        label1 = new JLabel();

        //======== this ========
        setResizable(false);
        setTitle("\u5403\u74dc\u7fa4\u4f17\u4e3b\u754c\u9762");
        setIconImage(null);
        Container contentPane = getContentPane();

        //======== menuBar1 ========
        {

            //======== menu1 ========
            {
                menu1.setText("\u4e2a\u4eba\u4e2d\u5fc3");
                menu1.setFont(new Font("Microsoft YaHei UI", Font.BOLD | Font.ITALIC, 28));

                //---- inquireMenuItem ----
                inquireMenuItem.setText("\u67e5\u8be2\u4e2a\u4eba\u4fe1\u606f");
                inquireMenuItem.setFont(new Font("Microsoft YaHei UI", Font.BOLD | Font.ITALIC, 24));
                inquireMenuItem.addActionListener(e -> inquireMenuItemActionPerformed(e));
                menu1.add(inquireMenuItem);

                //---- alterMenuItem ----
                alterMenuItem.setText("\u4fee\u6539\u4e2a\u4eba\u4fe1\u606f");
                alterMenuItem.setFont(new Font("Microsoft YaHei UI", Font.BOLD | Font.ITALIC, 24));
                alterMenuItem.addActionListener(e -> alterMenuItemActionPerformed(e));
                menu1.add(alterMenuItem);

                //---- myLikeIncidentMenuItemActionPerformed ----
                myLikeIncidentMenuItemActionPerformed.setText("\u6536  \u85cf  \u7684  \u74dc");
                myLikeIncidentMenuItemActionPerformed.setFont(new Font("Microsoft YaHei UI", Font.BOLD | Font.ITALIC, 24));
                myLikeIncidentMenuItemActionPerformed.addActionListener(e -> myLikeIncidentMenuItemActionPerformedActionPerformed(e));
                menu1.add(myLikeIncidentMenuItemActionPerformed);

                //---- myPublishIncidentMenuItem ----
                myPublishIncidentMenuItem.setText("\u53d1  \u5e03  \u7684  \u74dc");
                myPublishIncidentMenuItem.setFont(new Font("Microsoft YaHei UI", Font.BOLD | Font.ITALIC, 24));
                myPublishIncidentMenuItem.addActionListener(e -> myPublishIncidentMenuItemActionPerformed(e));
                menu1.add(myPublishIncidentMenuItem);

                //---- exitMenuItem ----
                exitMenuItem.setText("\u9000  \u51fa  \u767b  \u5f55");
                exitMenuItem.setFont(new Font("Microsoft YaHei UI", Font.BOLD | Font.ITALIC, 24));
                exitMenuItem.addActionListener(e -> exitMenuItemActionPerformed(e));
                menu1.add(exitMenuItem);
            }
            menuBar1.add(menu1);

            //======== menu2 ========
            {
                menu2.setText("\u74dc\u74dc\u4e2d\u5fc3");
                menu2.setFont(new Font("Microsoft YaHei UI", Font.BOLD | Font.ITALIC, 28));

                //---- inquireIncidentMenuItem ----
                inquireIncidentMenuItem.setText("\u5403\u74dc");
                inquireIncidentMenuItem.setFont(new Font("Microsoft YaHei UI", Font.BOLD | Font.ITALIC, 24));
                inquireIncidentMenuItem.addActionListener(e -> inquireIncidentMenuItemActionPerformed(e));
                menu2.add(inquireIncidentMenuItem);

                //---- createIncidentMenuItem ----
                createIncidentMenuItem.setText("\u9020\u74dc");
                createIncidentMenuItem.setFont(new Font("Microsoft YaHei UI", Font.BOLD | Font.ITALIC, 24));
                createIncidentMenuItem.addActionListener(e -> {
                    //menuItem1ActionPerformed(e);
                    createIncidentMenuItemActionPerformed(e);
                });
                menu2.add(createIncidentMenuItem);
            }
            menuBar1.add(menu2);
        }
        setJMenuBar(menuBar1);

        //---- mainLabel ----
        mainLabel.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 28));

        //======== scrollPane1 ========
        {

            //---- textArea1 ----
            textArea1.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
            textArea1.setEditable(false);
            scrollPane1.setViewportView(textArea1);
        }

        //---- label1 ----
        label1.setText("\u74dc\u738b\u7cfb\u7edf\u89c4\u7ea6");
        label1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGap(578, 578, 578)
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(mainLabel, GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGroup(contentPaneLayout.createParallelGroup()
                                                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 411, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 288, GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 98, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addComponent(mainLabel, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
                                .addGap(73, 73, 73)
                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(45, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

        /*
        把查询条件封装成一个user对象
         */
        User conditionUser = new User();
        conditionUser.setLoginName(loginName);
        userName = userService.findUser(conditionUser).getUserName();
        /*
        设置登录标语
         */
        mainLabel.setText("亲爱的 " + userName + "，欢迎您登录瓜王系统...");
        textArea1.setText("1.不得发表有政治性错误的言论。\n" +
                "2.不得辱骂其它吃瓜群众。\n" +
                "3.请尊重我们的瓜王，不要过分把瓜做大。\n" +
                "4.本系统不负有任何法律责任。\n" +
                "5.请各位用户文明用语。\n" +
                "6.不得恶意损坏瓜王的形象，要实事求是。\n" +
                "7.忘记密码请与超级管理员联系。");
    }

}
