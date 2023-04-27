/*
 * Created by JFormDesigner on Mon Mar 29 19:59:13 CST 2021
 */

package com.wjh.www.view.UserView;

import com.wjh.www.po.User;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author wjh
 */
@SuppressWarnings("all")
public class InquiryUserInformationView extends JDialog {
    /*
    存放当前用户的个人信息
     */
    private User user = null;

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JTextField loginNameTextField;
    private JLabel label2;
    private JTextField userNameTextField;
    private JLabel label3;
    private JTextField userSexTextField;
    private JLabel label4;
    private JTextField userBirthdayTextField;
    private JLabel label5;
    private JScrollPane scrollPane1;
    private JTextArea userDescriptionTextArea;
    private JLabel label6;
    // JFormDesigner - End of variables declaration  //GEN-END:variables


    public InquiryUserInformationView(JFrame jFrame, User user) {
        super(jFrame, "查询个人信息", true);
        this.user = user;
        initComponents();
        initInformation();
        this.setVisible(true);
    }


    /**
     * 用于初始化查询个人信息界面的个人信息
     */
    private void initInformation() {
        if (user != null) {
            this.loginNameTextField.setText(user.getLoginName());
            this.userNameTextField.setText(user.getUserName());
            this.userSexTextField.setText(user.getUserSex());
            this.userBirthdayTextField.setText(user.getUserBirthday());
            this.userDescriptionTextArea.setText(user.getUserDescription());
        }
    }

    /*
    swing布局
     */
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        loginNameTextField = new JTextField();
        label2 = new JLabel();
        userNameTextField = new JTextField();
        label3 = new JLabel();
        userSexTextField = new JTextField();
        label4 = new JLabel();
        userBirthdayTextField = new JTextField();
        label5 = new JLabel();
        scrollPane1 = new JScrollPane();
        userDescriptionTextArea = new JTextArea();
        label6 = new JLabel();

        //======== this ========
        Container contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u8d26\u53f7\uff1a");
        label1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        //---- loginNameTextField ----
        loginNameTextField.setEditable(false);
        loginNameTextField.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        //---- label2 ----
        label2.setText("\u7528\u6237\u540d\uff1a");
        label2.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        //---- userNameTextField ----
        userNameTextField.setEditable(false);
        userNameTextField.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        //---- label3 ----
        label3.setText("\u6027\u522b\uff1a");
        label3.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        //---- userSexTextField ----
        userSexTextField.setEditable(false);
        userSexTextField.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        //---- label4 ----
        label4.setText("\u751f    \u65e5\uff1a");
        label4.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        //---- userBirthdayTextField ----
        userBirthdayTextField.setEditable(false);
        userBirthdayTextField.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        //---- label5 ----
        label5.setText("\u4e2a\u4eba\u63cf\u8ff0\uff1a");
        label5.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        //======== scrollPane1 ========
        {

            //---- userDescriptionTextArea ----
            userDescriptionTextArea.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
            userDescriptionTextArea.setEditable(false);
            scrollPane1.setViewportView(userDescriptionTextArea);
        }

        //---- label6 ----
        label6.setText("\u4e2a\u4eba\u4fe1\u606f");
        label6.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 28));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(label3, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(label5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGroup(contentPaneLayout.createParallelGroup()
                                                        .addComponent(userSexTextField, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(loginNameTextField, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE))
                                                .addGap(84, 84, 84)
                                                .addGroup(contentPaneLayout.createParallelGroup()
                                                        .addComponent(label4, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                                .addComponent(label2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addGap(19, 19, 19)))
                                                .addGap(20, 20, 20)
                                                .addGroup(contentPaneLayout.createParallelGroup()
                                                        .addComponent(userBirthdayTextField, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(userNameTextField, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE))
                                                .addContainerGap(107, Short.MAX_VALUE))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 541, GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 127, Short.MAX_VALUE))))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                .addContainerGap(337, Short.MAX_VALUE)
                                .addComponent(label6, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE)
                                .addGap(265, 265, 265))
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(label6, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(loginNameTextField, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(userNameTextField, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label3, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(userSexTextField, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label4, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(userBirthdayTextField, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
                                .addGap(51, 51, 51)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label5, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(79, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
}
