/*
 * Created by JFormDesigner on Tue Mar 30 08:54:37 CST 2021
 */

package com.wjh.www.view.AdminView;

import com.wjh.www.view.Main;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author wjh
 */
@SuppressWarnings("all")
public class SuperAdminHomeView extends JFrame {
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JMenuBar menuBar1;
    private JMenu menu1;
    private JMenuItem exitMenuItem;
    private JMenu menu2;
    private JMenuItem alterAdminMenuItem;
    private JMenuItem createCircleMenuItem;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public SuperAdminHomeView() {
        initComponents();
        this.setVisible(true);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);//最大化
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//设置关闭该窗体即关闭程序
    }

    /**
     * 创建瓜圈的事件监听，跳转到AddCircleView
     *
     * @param e
     */
    private void createCircleMenuItemActionPerformed(ActionEvent e) {
        new AddCircleView(this);
    }

    private void exitMenuItemActionPerformed(ActionEvent e) {
        int result = JOptionPane.showConfirmDialog(null, "是否退出系统？");
        if (result == 0) {//点击”确认“的话返回值是0
            try {
                Main.connectionPool.closeConnectionPool();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            dispose();
            System.exit(0);
            /*
            关闭数据库连接池，释放资源
             */
        }
    }

    /**
     * 删除瓜圈
     *
     * @param e
     */
    private void deleteAdminMenuItemActionPerformed(ActionEvent e) {
        new DeleteCirclesView(this);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        exitMenuItem = new JMenuItem();
        menu2 = new JMenu();
        alterAdminMenuItem = new JMenuItem();
        createCircleMenuItem = new JMenuItem();

        //======== this ========
        setTitle("\u8d85\u7ea7\u7ba1\u7406\u5458\u4e3b\u754c\u9762");
        Container contentPane = getContentPane();

        //======== menuBar1 ========
        {

            //======== menu1 ========
            {
                menu1.setText("\u7cfb\u7edf");
                menu1.setFont(new Font("Microsoft YaHei UI", Font.BOLD | Font.ITALIC, 28));

                //---- exitMenuItem ----
                exitMenuItem.setText("\u9000\u51fa\u7cfb\u7edf");
                exitMenuItem.setFont(new Font("Microsoft YaHei UI", Font.BOLD | Font.ITALIC, 24));
                exitMenuItem.addActionListener(e -> exitMenuItemActionPerformed(e));
                menu1.add(exitMenuItem);
            }
            menuBar1.add(menu1);

            //======== menu2 ========
            {
                menu2.setText("\u4e1a\u52a1\u4e2d\u5fc3");
                menu2.setFont(new Font("Microsoft YaHei UI", Font.BOLD | Font.ITALIC, 28));

                //---- alterAdminMenuItem ----
                alterAdminMenuItem.setText("\u5220\u9664\u74dc\u5708");
                alterAdminMenuItem.setFont(new Font("Microsoft YaHei UI", Font.BOLD | Font.ITALIC, 24));
                alterAdminMenuItem.addActionListener(e -> deleteAdminMenuItemActionPerformed(e));
                menu2.add(alterAdminMenuItem);

                //---- createCircleMenuItem ----
                createCircleMenuItem.setText("\u521b\u5efa\u74dc\u5708");
                createCircleMenuItem.setFont(new Font("Microsoft YaHei UI", Font.BOLD | Font.ITALIC, 24));
                createCircleMenuItem.addActionListener(e -> createCircleMenuItemActionPerformed(e));
                menu2.add(createCircleMenuItem);
            }
            menuBar1.add(menu2);
        }
        setJMenuBar(menuBar1);

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGap(0, 913, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGap(0, 501, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
}
