/*
 * Created by JFormDesigner on Tue Mar 30 00:31:21 CST 2021
 */

package com.wjh.www.view.AdminView;

import com.wjh.www.po.Admin;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author wjh
 */
@SuppressWarnings("all")
public class InquiryAdminInformationView extends JDialog {
    /*
    把查询到的管理员的信息存放到该admin对象
     */
    private Admin admin = null;

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JTextField myAdminIdTextField;
    private JLabel label2;
    private JTextField myLoginNameTextField;
    private JLabel label3;
    private JTextField myAdminNameTextField;
    private JLabel label4;
    private JLabel label6;
    private JTextField myDescriptionTextField;
    private JLabel label7;
    private JTextField myCircleTextField;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public InquiryAdminInformationView(JFrame jFrame, Admin admin) {
        super(jFrame, "查询个人信息", true);
        this.admin = admin;
        initComponents();
        initInformation();
        this.setVisible(true);
    }

    /**
     * 初始化展示的数据
     */
    private void initInformation() {
        if (admin != null) {
            this.myAdminIdTextField.setText(String.valueOf(admin.getAdminId()));
            this.myLoginNameTextField.setText(admin.getLoginName());
            this.myAdminNameTextField.setText(admin.getAdminName());
            this.myDescriptionTextField.setText(admin.getAdminDescription());
            this.myCircleTextField.setText(admin.getAdminCircle());
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        myAdminIdTextField = new JTextField();
        label2 = new JLabel();
        myLoginNameTextField = new JTextField();
        label3 = new JLabel();
        myAdminNameTextField = new JTextField();
        label4 = new JLabel();
        label6 = new JLabel();
        myDescriptionTextField = new JTextField();
        label7 = new JLabel();
        myCircleTextField = new JTextField();

        //======== this ========
        Container contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u6211\u7684\u5de5\u53f7\uff1a");
        label1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        //---- myAdminIdTextField ----
        myAdminIdTextField.setEditable(false);
        myAdminIdTextField.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        //---- label2 ----
        label2.setText("\u6211\u7684\u8d26\u53f7\uff1a");
        label2.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        //---- myLoginNameTextField ----
        myLoginNameTextField.setEditable(false);
        myLoginNameTextField.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        //---- label3 ----
        label3.setText("\u6211\u7684\u6635\u79f0\uff1a");
        label3.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        //---- myAdminNameTextField ----
        myAdminNameTextField.setEditable(false);
        myAdminNameTextField.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        //---- label4 ----
        label4.setText("\u6211\u7684\u4fe1\u606f");
        label4.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 28));

        //---- label6 ----
        label6.setText("\u6211\u7684\u804c\u8d23\uff1a");
        label6.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        //---- myDescriptionTextField ----
        myDescriptionTextField.setEditable(false);
        myDescriptionTextField.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        //---- label7 ----
        label7.setText("\u7ba1\u7406\u7684\u5708\uff1a");
        label7.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        //---- myCircleTextField ----
        myCircleTextField.setEditable(false);
        myCircleTextField.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGap(278, 278, 278)
                                                .addComponent(label4, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGap(70, 70, 70)
                                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(label2, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                                                        .addComponent(label1, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                                                        .addComponent(label3, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                                                        .addComponent(label6)
                                                        .addComponent(label7))
                                                .addGap(29, 29, 29)
                                                .addGroup(contentPaneLayout.createParallelGroup()
                                                        .addComponent(myAdminIdTextField, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(myLoginNameTextField, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(myAdminNameTextField, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(myDescriptionTextField, GroupLayout.PREFERRED_SIZE, 426, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(myCircleTextField, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(134, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(label4, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(myAdminIdTextField, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
                                .addGap(38, 38, 38)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(myLoginNameTextField, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
                                .addGap(43, 43, 43)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label3, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(myAdminNameTextField, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                                .addGap(37, 37, 37)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label6, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(myDescriptionTextField, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
                                .addGap(37, 37, 37)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label7, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(myCircleTextField, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(85, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
}
