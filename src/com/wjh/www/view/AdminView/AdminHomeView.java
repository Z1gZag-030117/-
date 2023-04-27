/*
 * Created by JFormDesigner on Mon Mar 29 23:38:25 CST 2021
 */

package com.wjh.www.view.AdminView;

import com.wjh.www.po.Admin;
import com.wjh.www.service.impl.AdminServiceImpl;
import com.wjh.www.service.AdminService;
import com.wjh.www.view.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

/**
 * @author wjh
 */
@SuppressWarnings("all")
public class AdminHomeView extends JFrame {
    /*
    当前登录的管理员
     */
    private String loginName;
    /**
     * 当前管理员的昵称
     */
    private String userName;
    /**
     * 当前管理员管理的瓜圈
     */
    private String adminCircle;
    private final AdminService adminService = new AdminServiceImpl();

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JMenuBar menuBar1;
    private JMenu menu1;
    private JMenuItem myInformationMenuItem;
    private JMenuItem exitMenuItem;
    private JMenu menu2;
    private JMenuItem incidentMenuItem;
    private JMenuItem reportMenuItem;
    private JLabel mainLabel;
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public AdminHomeView(String loginName) {
        this.loginName = loginName;
        initComponents();
        this.setVisible(true);
        //最大化
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //设置关闭该窗体即关闭程序
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    /**
     * 退出系统的事件监听
     *
     * @param e
     */
    private void exitMenuItemActionPerformed(ActionEvent e) {
        int result = JOptionPane.showConfirmDialog(null, "是否退出系统？");
        //点击”确认“的话返回值是0
        if (result == 0) {
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
     * 管理员查询个人信息
     *
     * @param e
     */
    private void myInformationMenuItemActionPerformed(ActionEvent e) {
        /*
        把where条件封装成一个admin对象
         */
        Admin conditionAdmin = new Admin();
        conditionAdmin.setLoginName(loginName);
        /*
        admin是被返回的的管理员对象，已经被封装了相关信息,把该对象传递给InquiryAdminInformationView界面
         */
        Admin admin = adminService.findAdmin(conditionAdmin);
        new InquiryAdminInformationView(this, admin);
    }

    /**
     * 管理员查询自己所管圈的事件监听
     *
     * @param e
     */
    private void incidentMenuItemActionPerformed(ActionEvent e) {
        new AdminInquireIncidentView(this, adminCircle);
    }

    /**
     * 处理用户举报的事件的事件监听
     *
     * @param e
     */
    private void reportMenuItemActionPerformed(ActionEvent e) {
        new DealReportView(this, adminCircle);
    }

    /*
    swing布局
     */
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        myInformationMenuItem = new JMenuItem();
        exitMenuItem = new JMenuItem();
        menu2 = new JMenu();
        incidentMenuItem = new JMenuItem();
        reportMenuItem = new JMenuItem();
        mainLabel = new JLabel();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();
        label1 = new JLabel();

        //======== this ========
        setTitle("\u7ba1\u7406\u5458\u754c\u9762");
        Container contentPane = getContentPane();

        //======== menuBar1 ========
        {

            //======== menu1 ========
            {
                menu1.setText("\u4e2a\u4eba\u4e2d\u5fc3");
                menu1.setFont(new Font("Microsoft YaHei UI", Font.BOLD | Font.ITALIC, 28));

                //---- myInformationMenuItem ----
                myInformationMenuItem.setText("\u4e2a\u4eba\u4fe1\u606f");
                myInformationMenuItem.setFont(new Font("Microsoft YaHei UI", Font.BOLD | Font.ITALIC, 24));
                myInformationMenuItem.addActionListener(e -> myInformationMenuItemActionPerformed(e));
                menu1.add(myInformationMenuItem);

                //---- exitMenuItem ----
                exitMenuItem.setText("\u9000\u51fa\u7cfb\u7edf");
                exitMenuItem.setFont(new Font("Microsoft YaHei UI", Font.BOLD | Font.ITALIC, 24));
                exitMenuItem.addActionListener(e -> exitMenuItemActionPerformed(e));
                menu1.add(exitMenuItem);
            }
            menuBar1.add(menu1);

            //======== menu2 ========
            {
                menu2.setText("\u7ba1\u7406\u4e2d\u5fc3");
                menu2.setFont(new Font("Microsoft YaHei UI", Font.BOLD | Font.ITALIC, 28));

                //---- incidentMenuItem ----
                incidentMenuItem.setText("\u4e8b\u4ef6\u7ba1\u7406");
                incidentMenuItem.setFont(new Font("Microsoft YaHei UI", Font.BOLD | Font.ITALIC, 24));
                incidentMenuItem.addActionListener(e -> incidentMenuItemActionPerformed(e));
                menu2.add(incidentMenuItem);

                //---- reportMenuItem ----
                reportMenuItem.setText("\u7528\u6237\u4e3e\u62a5\u5904\u7406");
                reportMenuItem.setFont(new Font("Microsoft YaHei UI", Font.BOLD | Font.ITALIC, 24));
                reportMenuItem.addActionListener(e -> reportMenuItemActionPerformed(e));
                menu2.add(reportMenuItem);
            }
            menuBar1.add(menu2);
        }
        setJMenuBar(menuBar1);

        //---- mainLabel ----
        mainLabel.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 26));

        //======== scrollPane1 ========
        {

            //---- textArea1 ----
            textArea1.setEditable(false);
            textArea1.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
            scrollPane1.setViewportView(textArea1);
        }

        //---- label1 ----
        label1.setText("\u58f0  \u660e");
        label1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addContainerGap(194, Short.MAX_VALUE)
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(mainLabel, GroupLayout.PREFERRED_SIZE, 633, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 395, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addComponent(mainLabel, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(79, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

        /*
        把查询条件封装成一个admin对象
         */
        Admin conditionAdmin = new Admin();
        conditionAdmin.setLoginName(loginName);
        /*
        查询当前管理员的昵称、管理的瓜圈
         */
        userName = adminService.findAdmin(conditionAdmin).getAdminName();
        adminCircle = adminService.findAdmin(conditionAdmin).getAdminCircle();
        /*
        设置欢迎内容
         */
        mainLabel.setText("亲爱的 " + userName + "，欢迎您登录瓜王系统...");
        textArea1.setText("1.不得从删库到跑路。\n" +
                "2.客观对待吃瓜群众。\n" +
                "3.管理不能简单粗暴。\n" +
                "4.不能滥用职权。\n" +
                "5.客观管理用户做的瓜和评论。\n" +
                "6.不能和用户发生利益交易。\n" +
                "7.您无权修改你的个人信息。");
    }
}
