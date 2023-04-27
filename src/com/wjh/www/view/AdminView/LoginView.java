/*
 * Created by JFormDesigner on Sun Mar 28 22:48:42 CST 2021
 */

package com.wjh.www.view.AdminView;

import com.wjh.www.po.Admin;
import com.wjh.www.po.User;
import com.wjh.www.service.impl.AdminServiceImpl;
import com.wjh.www.service.impl.UserServiceImpl;
import com.wjh.www.service.AdminService;
import com.wjh.www.service.UserService;
import com.wjh.www.util.Md5Utils;
import com.wjh.www.util.StringUtils;
import com.wjh.www.view.UserView.UserHomeView;
import com.wjh.www.view.UserView.RegisterView;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author wjh
 */
@SuppressWarnings("all")
public class LoginView extends JFrame {
    /**
     * 定义的swing组件
     */
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label2;
    private JTextField loginNameTextField;
    private JLabel label3;
    private JLabel label4;
    private JRadioButton userRadioBtn;
    private JRadioButton adminRadioBtn;
    private JButton loginBtn;
    private JButton resetBtn;
    private JPasswordField loginPwdPasswordField;
    private JButton registerBtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public LoginView() {
        initComponents();
        this.setVisible(true);
        //设置关闭该窗体即关闭程序
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    /**
     * 重置所有组件的内容的方法
     */
    private void resetMessage() {
        this.loginNameTextField.setText("");
        this.loginPwdPasswordField.setText("");
    }

    /**
     * 给重置按钮设置事件监听
     *
     * @param e
     */
    private void resetBtnActionPerformed(ActionEvent e) {
        resetMessage();
    }

    /**
     * 给登录按钮设置事件监听
     *
     * @param e
     */
    private void loginBtnActionPerformed(ActionEvent e) {
        /*
        获取前台传递的数据
         */
        String loginName = this.loginNameTextField.getText();
        String loginPwd = this.loginPwdPasswordField.getText();

        /*
        进行简单的前台校验
         */
        if (StringUtils.isEmpty(loginName)) {
            JOptionPane.showMessageDialog(null, "账号不能为空！");
            return;
        }
        if (StringUtils.isEmpty(loginPwd)) {
            JOptionPane.showMessageDialog(null, "密码不能为空！");
            return;
        }
        if (!userRadioBtn.isSelected() && !adminRadioBtn.isSelected()) {
            JOptionPane.showMessageDialog(null, "请选择你的身份！");
            return;
        }

        //如果选择的身份是用户
        if (userRadioBtn.isSelected()) {
            /*
        把查询条件封装成一个user对象
         */
            User conditionUser = new User();
            conditionUser.setLoginName(loginName);
            UserService userService = new UserServiceImpl();
            User user = userService.findUser(conditionUser);
            if (user == null) {
                JOptionPane.showMessageDialog(null, "账号或密码错误!");
                resetMessage();
                return;
            } else {
                if (loginName.equals(user.getLoginName()) && Md5Utils.getMD5(loginPwd).equals(user.getLoginPwd())) {
                    //用户登录成功后进入用户主界面
                    new UserHomeView(loginName);
                    dispose();
                    resetMessage();
                    return;
                } else {
                    JOptionPane.showMessageDialog(null, "账号或密码错误!");
                    resetMessage();
                    return;
                }
            }
        } else {
            /*
            查询该账号或密码是否正确
             */
            AdminService adminService = new AdminServiceImpl();
            Admin foundAdmin = new Admin();
            foundAdmin.setLoginName(loginName);
            Admin admin = adminService.findAdmin(foundAdmin);
            if (admin == null) {
                JOptionPane.showMessageDialog(null, "账号或密码错误!");
                resetMessage();
                return;
            } else {
                if (loginName.equals(admin.getLoginName()) && Md5Utils.getMD5(loginPwd).equals(admin.getLoginPwd())) {
                    dispose();
                    /*
                    如果账号是superadmin的账号
                     */
                    if (loginName.equals("superadmin")) {
                        new SuperAdminHomeView();
                        dispose();
                    } else {
                        new AdminHomeView(loginName);
                        dispose();
                    }
                    resetMessage();
                    return;
                } else {
                    JOptionPane.showMessageDialog(null, "账号或密码错误!");
                    resetMessage();
                    return;
                }
            }
        }
    }

    /**
     * 给立即注册按钮添加事件监听
     *
     * @param e
     */
    private void registerBtnActionPerformed(ActionEvent e) {
        dispose();
        new RegisterView();
    }

    /**
     * swing代码
     */
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label2 = new JLabel();
        loginNameTextField = new JTextField();
        label3 = new JLabel();
        label4 = new JLabel();
        userRadioBtn = new JRadioButton();
        adminRadioBtn = new JRadioButton();
        loginBtn = new JButton();
        resetBtn = new JButton();
        loginPwdPasswordField = new JPasswordField();
        registerBtn = new JButton();

        //======== this ========
        setTitle("\u767b\u5f55\u754c\u9762");
        Container contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u6b22 \u8fce \u767b \u5f55");
        label1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 30));

        //---- label2 ----
        label2.setText("\u8d26 \u53f7\uff1a");
        label2.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        //---- loginNameTextField ----
        loginNameTextField.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 16));

        //---- label3 ----
        label3.setText("\u5bc6 \u7801\uff1a");
        label3.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        //---- label4 ----
        label4.setText("\u8eab \u4efd\uff1a");
        label4.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        //---- userRadioBtn ----
        userRadioBtn.setText("\u7528\u6237");
        userRadioBtn.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 18));

        //---- adminRadioBtn ----
        adminRadioBtn.setText("\u7ba1\u7406\u5458");
        adminRadioBtn.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 18));

        //---- loginBtn ----
        loginBtn.setText("\u767b\u5f55");
        loginBtn.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));
        loginBtn.addActionListener(e -> loginBtnActionPerformed(e));

        //---- resetBtn ----
        resetBtn.setText("\u91cd\u7f6e");
        resetBtn.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));
        resetBtn.addActionListener(e -> resetBtnActionPerformed(e));

        //---- loginPwdPasswordField ----
        loginPwdPasswordField.setFont(new Font(Font.MONOSPACED, Font.BOLD, 16));

        //---- registerBtn ----
        registerBtn.setText("\u7acb\u5373\u6ce8\u518c");
        registerBtn.addActionListener(e -> registerBtnActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGap(131, 131, 131)
                                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(27, 27, 27)
                                                                .addComponent(loginNameTextField, GroupLayout.PREFERRED_SIZE, 249, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                                .addGroup(contentPaneLayout.createParallelGroup()
                                                                        .addComponent(label3, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(label4, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addGroup(contentPaneLayout.createParallelGroup()
                                                                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                                                                .addComponent(userRadioBtn)
                                                                                .addGap(115, 115, 115)
                                                                                .addComponent(adminRadioBtn))
                                                                        .addComponent(loginPwdPasswordField, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 249, GroupLayout.PREFERRED_SIZE)))))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGap(239, 239, 239)
                                                .addComponent(loginBtn)
                                                .addGap(49, 49, 49)
                                                .addComponent(resetBtn)))
                                .addContainerGap(198, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                .addContainerGap(255, Short.MAX_VALUE)
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)
                                                .addGap(216, 216, 216))
                                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                                .addComponent(registerBtn)
                                                .addContainerGap())))
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(loginNameTextField, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label3, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(loginPwdPasswordField, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label4, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(userRadioBtn)
                                        .addComponent(adminRadioBtn))
                                .addGap(53, 53, 53)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(loginBtn)
                                        .addComponent(resetBtn))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                                .addComponent(registerBtn)
                                .addContainerGap())
        );
        pack();
        setLocationRelativeTo(getOwner());

        //---- buttonGroup ----
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(userRadioBtn);
        buttonGroup.add(adminRadioBtn);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

}
