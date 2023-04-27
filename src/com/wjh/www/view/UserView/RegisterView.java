/*
 * Created by JFormDesigner on Mon Mar 29 12:54:04 CST 2021
 * 该类是用户的注册界面
 */

package com.wjh.www.view.UserView;

import com.wjh.www.po.User;
import com.wjh.www.service.impl.UserServiceImpl;
import com.wjh.www.service.UserService;
import com.wjh.www.util.Md5Utils;
import com.wjh.www.util.StringUtils;
import com.wjh.www.view.AdminView.LoginView;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author wjh
 */
@SuppressWarnings("all")
public class RegisterView extends JFrame {
    private final UserService userService = new UserServiceImpl();

    /**
     * 下面的对象都是swing组件，无关功能的组件（如：标签）的命名未采用驼峰命名法
     */
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label2;
    private JTextField registerLoginNameTextField;
    private JLabel label3;
    private JPasswordField registerPasswordTextField;
    private JLabel label4;
    private JPasswordField checkRegisterPasswordTextField;
    private JLabel label5;
    private JTextField userNameTextField;
    private JLabel label6;
    private JTextField sexTextField;
    private JLabel label7;
    private JTextField birthdayTextField;
    private JLabel label8;
    private JScrollPane scrollPane1;
    private JTextArea descriptionTextArea;
    private JButton registerBtn;
    private JButton resetBtn;
    private JButton loginNowBtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public RegisterView() {
        initComponents();
        //设置窗体可见
        this.setVisible(true);
        //设置关闭该窗体即关闭程序
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }


    /**
     * 重置所有内容的方法
     */
    private void resetMessage() {
        registerLoginNameTextField.setText("");
        registerPasswordTextField.setText("");
        checkRegisterPasswordTextField.setText("");
        userNameTextField.setText("");
        sexTextField.setText("");
        birthdayTextField.setText("");
        descriptionTextArea.setText("");
    }

    /**
     * 给立即登录按钮添加事件监听
     *
     * @param e
     */
    private void loginNowBtnActionPerformed(ActionEvent e) {
        dispose();
        new LoginView();
    }

    /**
     * 给重置按钮添加事件监听
     *
     * @param e
     */
    private void resetBtnActionPerformed(ActionEvent e) {
        resetMessage();
    }

    /**
     * 给注册按钮添加事件监听
     *
     * @param e
     */
    private void registerBtnActionPerformed(ActionEvent e) {
        /*
        获取前端传递的数据
         */
        String registerLoginName = registerLoginNameTextField.getText();
        String registerLoginPwd = registerPasswordTextField.getText();
        String registerUsername = userNameTextField.getText();
        String registerUserSex = sexTextField.getText();
        String registerUserBirthday = birthdayTextField.getText();
        String registerUserDescription = descriptionTextArea.getText();

        /*
        进行简单的前台校验
         */
        if (StringUtils.isEmpty(registerLoginName)) {
            JOptionPane.showMessageDialog(null, "账号不能为空！");
            return;
        }
        if (StringUtils.isEmpty(registerLoginPwd)) {
            JOptionPane.showMessageDialog(null, "密码不能为空！");
            return;
        }
        if (StringUtils.isEmpty(checkRegisterPasswordTextField.getText())) {
            JOptionPane.showMessageDialog(null, "请您确认密码！");
            return;
        }
        if (StringUtils.isEmpty(registerUsername)) {
            JOptionPane.showMessageDialog(null, "用户昵称不能为空！");
            return;
        }
        if (StringUtils.isEmpty(registerUserSex)) {
            JOptionPane.showMessageDialog(null, "性别不能为空！");
            return;
        }
        if (StringUtils.isEmpty(registerUserBirthday)) {
            JOptionPane.showMessageDialog(null, "请输入您的生日！");
            return;
        }
        if (StringUtils.isEmpty(registerUserDescription)) {
            JOptionPane.showMessageDialog(null, "请简单描述一下自己！");
            return;
        }
        if (!registerLoginPwd.equals(checkRegisterPasswordTextField.getText())) {
            JOptionPane.showMessageDialog(null, "输入的两次密码不一样！");
            registerPasswordTextField.setText("");
            checkRegisterPasswordTextField.setText("");
            return;
        }

        /*
        把查询条件封装成一个user对象
         */
        User conditionUser = new User();
        conditionUser.setLoginName(registerLoginName);
        if (userService.findUser(conditionUser) != null) {
            JOptionPane.showMessageDialog(null, "该账号已经被注册了！");
            registerLoginNameTextField.setText("");
            return;
        } else {
            /*
            把注册成功的用户的信息封装成一个user对象
             */
            UserService userService = new UserServiceImpl();
            User user = new User();
            user.setLoginName(registerLoginName);
            user.setLoginPwd(Md5Utils.getMD5(registerLoginPwd));
            user.setUserName(registerUsername);
            user.setUserSex(registerUserSex);
            user.setUserBirthday(registerUserBirthday);
            user.setUserDescription(registerUserDescription);
            if (userService.saveUser(user)) {
                JOptionPane.showMessageDialog(null, "注册成功！");
                new LoginView();
                dispose();
                resetMessage();
            } else {
                JOptionPane.showMessageDialog(null, "该昵称已经被使用了！");
                userNameTextField.setText("");
            }
            return;
        }
    }

    /**
     * swing布局
     */
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label2 = new JLabel();
        registerLoginNameTextField = new JTextField();
        label3 = new JLabel();
        registerPasswordTextField = new JPasswordField();
        label4 = new JLabel();
        checkRegisterPasswordTextField = new JPasswordField();
        label5 = new JLabel();
        userNameTextField = new JTextField();
        label6 = new JLabel();
        sexTextField = new JTextField();
        label7 = new JLabel();
        birthdayTextField = new JTextField();
        label8 = new JLabel();
        scrollPane1 = new JScrollPane();
        descriptionTextArea = new JTextArea();
        registerBtn = new JButton();
        resetBtn = new JButton();
        loginNowBtn = new JButton();

        //======== this ========
        setTitle("\u6ce8\u518c\u754c\u9762");
        Container contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u6b22 \u8fce \u6ce8 \u518c");
        label1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 28));

        //---- label2 ----
        label2.setText("\u8d26        \u53f7\uff1a");
        label2.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        //---- registerLoginNameTextField ----
        registerLoginNameTextField.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 16));

        //---- label3 ----
        label3.setText("\u5bc6        \u7801\uff1a");
        label3.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        //---- registerPasswordTextField ----
        registerPasswordTextField.setFont(new Font(Font.MONOSPACED, Font.BOLD, 16));

        //---- label4 ----
        label4.setText("\u786e\u8ba4\u5bc6\u7801\uff1a");
        label4.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        //---- checkRegisterPasswordTextField ----
        checkRegisterPasswordTextField.setFont(new Font(Font.MONOSPACED, Font.BOLD, 16));

        //---- label5 ----
        label5.setText("\u6635        \u79f0\uff1a");
        label5.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        //---- userNameTextField ----
        userNameTextField.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 16));

        //---- label6 ----
        label6.setText("\u6027        \u522b\uff1a");
        label6.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        //---- sexTextField ----
        sexTextField.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 16));

        //---- label7 ----
        label7.setText("\u751f        \u65e5\uff1a");
        label7.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        //---- birthdayTextField ----
        birthdayTextField.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 16));

        //---- label8 ----
        label8.setText("\u4e2a\u4eba\u63cf\u8ff0\uff1a");
        label8.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        //======== scrollPane1 ========
        {

            //---- descriptionTextArea ----
            descriptionTextArea.setFont(new Font(Font.MONOSPACED, Font.BOLD, 16));
            scrollPane1.setViewportView(descriptionTextArea);
        }

        //---- registerBtn ----
        registerBtn.setText("\u6ce8\u518c");
        registerBtn.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 18));
        registerBtn.addActionListener(e -> registerBtnActionPerformed(e));

        //---- resetBtn ----
        resetBtn.setText("\u91cd\u7f6e");
        resetBtn.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 18));
        resetBtn.addActionListener(e -> resetBtnActionPerformed(e));

        //---- loginNowBtn ----
        loginNowBtn.setText("\u7acb\u5373\u767b\u5f55");
        loginNowBtn.addActionListener(e -> loginNowBtnActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGap(313, 313, 313)
                                                .addComponent(label1))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGap(136, 136, 136)
                                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addComponent(label3)
                                                        .addComponent(label2)
                                                        .addComponent(label4)
                                                        .addComponent(label5)
                                                        .addComponent(label6)
                                                        .addComponent(label7)
                                                        .addComponent(label8))
                                                .addGap(29, 29, 29)
                                                .addGroup(contentPaneLayout.createParallelGroup()
                                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                                .addComponent(registerBtn)
                                                                .addGap(81, 81, 81)
                                                                .addComponent(resetBtn))
                                                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(registerLoginNameTextField, GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                                                                .addComponent(registerPasswordTextField, GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                                                                .addComponent(checkRegisterPasswordTextField, GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                                                                .addComponent(userNameTextField, GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                                                                .addComponent(sexTextField, GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                                                                .addComponent(birthdayTextField, GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                                                                .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)))))
                                .addContainerGap(217, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                .addGap(0, 657, Short.MAX_VALUE)
                                .addComponent(loginNowBtn)
                                .addGap(14, 14, 14))
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label2, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                                        .addComponent(registerLoginNameTextField, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label3, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(registerPasswordTextField, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label4, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(checkRegisterPasswordTextField, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label5, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(userNameTextField, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label6, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(sexTextField, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label7, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(birthdayTextField, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label8, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(resetBtn)
                                        .addComponent(registerBtn))
                                .addGap(3, 3, 3)
                                .addComponent(loginNowBtn)
                                .addContainerGap())
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
}
