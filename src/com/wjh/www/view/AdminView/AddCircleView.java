/*
 * Created by JFormDesigner on Sat Apr 03 12:03:41 CST 2021
 */

package com.wjh.www.view.AdminView;

import com.wjh.www.po.Admin;
import com.wjh.www.po.Circles;
import com.wjh.www.service.impl.AdminServiceImpl;
import com.wjh.www.service.impl.CirclesServiceImpl;
import com.wjh.www.service.AdminService;
import com.wjh.www.service.CirclesService;
import com.wjh.www.util.BaseUtils;
import com.wjh.www.util.StringUtils;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author wjh
 */
@SuppressWarnings("all")
public class AddCircleView extends JDialog {
    private final CirclesService circlesService = new CirclesServiceImpl();
    private final AdminService adminService = new AdminServiceImpl();

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label2;
    private JTextField loginNameTextField;
    private JLabel label3;
    private JTextField pwdTextField;
    private JLabel label4;
    private JTextField adminNameTextField;
    private JLabel label5;
    private JTextField adminDescriptionTextField;
    private JLabel label6;
    private JTextField circleNameTextField;
    private JLabel label7;
    private JTextField descriptionTextField;
    private JButton addCircleBtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public AddCircleView(Window owner) {
        super(owner);
        initComponents();
        this.setVisible(true);
    }

    /**
     * 添加瓜圈的事件监听
     *
     * @param e
     */
    private void addCircleBtnActionPerformed(ActionEvent e) {
        /*
        先进行简单的前台校验
         */
        if (StringUtils.isEmpty(circleNameTextField.getText())) {
            JOptionPane.showMessageDialog(null, "请输入新瓜圈的名字！");
            return;
        }
        if (StringUtils.isEmpty(descriptionTextField.getText())) {
            JOptionPane.showMessageDialog(null, "请简单描述一下瓜圈！");
            return;
        }
        if (StringUtils.isEmpty(loginNameTextField.getText())) {
            JOptionPane.showMessageDialog(null, "请注册新瓜圈管理员的账号！");
            return;
        }
        if (StringUtils.isEmpty(pwdTextField.getText())) {
            JOptionPane.showMessageDialog(null, "请输入新瓜圈管理员的登录密码！");
            return;
        }
        if (StringUtils.isEmpty(adminNameTextField.getText())) {
            JOptionPane.showMessageDialog(null, "请输入新瓜圈管理员的昵称！");
            return;
        }
        if (StringUtils.isEmpty(adminDescriptionTextField.getText())) {
            JOptionPane.showMessageDialog(null, "请简单描述一下新管理员！");
            return;
        }

        int result = JOptionPane.showConfirmDialog(null, "您是否确认创建新瓜圈？");
        if (result == 0) {
            /*
            封装新瓜圈的管理员
             */
            Admin admin = new Admin();
            admin.setLoginName(loginNameTextField.getText());
            admin.setLoginPwd(pwdTextField.getText());
            admin.setAdminName(adminNameTextField.getText());
            admin.setAdminDescription(adminDescriptionTextField.getText());
            admin.setAdminCircle(circleNameTextField.getText());

            /*
            封装新瓜圈的相关数据
             */
            Circles circles = new Circles();
            circles.setCircleName(circleNameTextField.getText());
            circles.setCreateTime(BaseUtils.getTime());
            circles.setCircleAdmin(adminNameTextField.getText());
            circles.setCircleDescription(descriptionTextField.getText());

            /*
            先查询管理员账号或瓜圈是否已经存在了，把查询的where条件封装成对象
             */
            Admin conditionAdmin1 = new Admin();
            Admin conditionAdmin2 = new Admin();
            conditionAdmin1.setLoginName(loginNameTextField.getText());
            conditionAdmin2.setAdminCircle(circleNameTextField.getText());
            if (adminService.findAdmin(conditionAdmin1) != null || adminService.findAdmin(conditionAdmin2) != null) {
                JOptionPane.showMessageDialog(null, "瓜圈或管理员账号已经存在");
            } else {
                /*
                  调用service层的方法，两个方法都返回true的话就代表添加瓜圈成功
                */
                if (circlesService.saveCircle(circles) && adminService.saveAdmin(admin)) {
                    JOptionPane.showMessageDialog(null, "创建新瓜圈成功！");
                } else {
                    JOptionPane.showMessageDialog(null, "我们的数据库出现了问题，正在维护中，添加失败了~");
                }
            }

            dispose();
        }
    }


    /*
    swing布局方法
     */
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label2 = new JLabel();
        loginNameTextField = new JTextField();
        label3 = new JLabel();
        pwdTextField = new JTextField();
        label4 = new JLabel();
        adminNameTextField = new JTextField();
        label5 = new JLabel();
        adminDescriptionTextField = new JTextField();
        label6 = new JLabel();
        circleNameTextField = new JTextField();
        label7 = new JLabel();
        descriptionTextField = new JTextField();
        addCircleBtn = new JButton();

        //======== this ========
        setTitle("\u6dfb\u52a0\u7ba1\u7406\u5458\u754c\u9762");
        Container contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u6dfb\u52a0\u74dc\u5708");
        label1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 28));

        //---- label2 ----
        label2.setText("\u7ba1\u7406\u5458\u8d26\u53f7\uff1a");
        label2.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        //---- loginNameTextField ----
        loginNameTextField.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        //---- label3 ----
        label3.setText("\u7ba1\u7406\u5458\u5bc6\u7801\uff1a");
        label3.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        //---- pwdTextField ----
        pwdTextField.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        //---- label4 ----
        label4.setText("\u7ba1\u7406\u5458\u6635\u79f0\uff1a");
        label4.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        //---- adminNameTextField ----
        adminNameTextField.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        //---- label5 ----
        label5.setText("\u7ba1\u7406\u5458\u63cf\u8ff0\uff1a");
        label5.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        //---- adminDescriptionTextField ----
        adminDescriptionTextField.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        //---- label6 ----
        label6.setText("\u74dc \u5708 \u540d \u79f0\uff1a");
        label6.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        //---- circleNameTextField ----
        circleNameTextField.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        //---- label7 ----
        label7.setText("\u74dc \u5708 \u63cf \u8ff0\uff1a");
        label7.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        //---- descriptionTextField ----
        descriptionTextField.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        //---- addCircleBtn ----
        addCircleBtn.setText("\u521b\u5efa\u74dc\u5708");
        addCircleBtn.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 16));
        addCircleBtn.addActionListener(e -> addCircleBtnActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGap(280, 280, 280)
                                                .addComponent(label1)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGap(31, 31, 31)
                                                .addGroup(contentPaneLayout.createParallelGroup()
                                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                                .addGap(1, 1, 1)
                                                                .addComponent(label7)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(circleNameTextField, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
                                                                        .addComponent(descriptionTextField)))
                                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                                .addGroup(contentPaneLayout.createParallelGroup()
                                                                        .addGroup(contentPaneLayout.createParallelGroup()
                                                                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                                        .addComponent(label4, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
                                                                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                                                                .addGap(1, 1, 1)
                                                                                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)))
                                                                                .addComponent(label3, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE))
                                                                        .addComponent(label5))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(contentPaneLayout.createParallelGroup()
                                                                        .addComponent(adminNameTextField, GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                                                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                                                .addGroup(contentPaneLayout.createParallelGroup()
                                                                                        .addComponent(loginNameTextField, GroupLayout.PREFERRED_SIZE, 379, GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(pwdTextField, GroupLayout.PREFERRED_SIZE, 379, GroupLayout.PREFERRED_SIZE))
                                                                                .addGap(0, 1, Short.MAX_VALUE))
                                                                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                                                                .addGap(0, 1, Short.MAX_VALUE)
                                                                                .addComponent(adminDescriptionTextField, GroupLayout.PREFERRED_SIZE, 379, GroupLayout.PREFERRED_SIZE))))
                                                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                                                .addComponent(label6)
                                                                .addGap(424, 424, 424)))))
                                .addGap(135, 135, 135))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                .addGap(0, 304, Short.MAX_VALUE)
                                .addComponent(addCircleBtn, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
                                .addGap(296, 296, 296))
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label6, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(circleNameTextField, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
                                .addGap(16, 16, 16)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(descriptionTextField, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label7, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
                                .addGap(19, 19, 19)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(loginNameTextField, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label3, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(pwdTextField, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
                                .addGap(23, 23, 23)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(adminNameTextField, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label4, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(adminDescriptionTextField, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label5, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29)
                                .addComponent(addCircleBtn)
                                .addContainerGap(50, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
}
