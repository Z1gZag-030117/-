/*
 * Created by JFormDesigner on Mon Mar 29 20:55:14 CST 2021
 */

package com.wjh.www.view.UserView;

import java.awt.event.*;

import com.wjh.www.po.*;
import com.wjh.www.service.*;
import com.wjh.www.service.impl.*;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author wjh
 */
@SuppressWarnings("all")
public class AlterUserInformationView extends JDialog {
    /*
    判断是否需要刷新首页
     */
    boolean judge;

    /**
     * 修改个人信息之前的旧昵称，用于把其它表的旧名称改为新名称
     */
    private final String oldUserName;

    UserService userService = new UserServiceImpl();
    IncidentService incidentService = new IncidentServiceImpl();
    CommentService commentService = new CommentServiceImpl();
    CollectionService collectionService = new CollectionServiceImpl();
    FollowService followService = new FollowServiceImpl();
    ReportService reportService = new ReportServiceImpl();
    private User user = null;

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label6;
    private JLabel label1;
    private JTextField loginNameTextField;
    private JLabel label2;
    private JTextField userNameTextField;
    private JLabel label3;
    private JTextField userSexTextField;
    private JLabel label4;
    private JTextField userBirthdayTextField;
    private JLabel label5;
    private JTextArea userDescriptionTextArea;
    private JButton alterBtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables


    /**
     * 修改用户的个体信息
     *
     * @param jFrame
     * @param user
     * @param loginName   当前用户的账号
     * @param oldUserName 就用户名
     */
    public AlterUserInformationView(JFrame jFrame, User user, String loginName, String oldUserName) {
        super(jFrame, "修改个人信息", true);
        this.user = user;
        this.oldUserName = oldUserName;
        initComponents();
        initInformation();
        this.setVisible(true);
    }

    /**
     * 初始化组件显示的数据
     */
    private void initInformation() {
        if (user != null) {
            this.userNameTextField.setText(user.getUserName());
            this.loginNameTextField.setText(user.getLoginName());
            this.userSexTextField.setText(user.getUserSex());
            this.userBirthdayTextField.setText(user.getUserBirthday());
            this.userDescriptionTextArea.setText(user.getUserDescription());
        }
    }

    /**
     * 给确认修改按钮添加事件监听
     *
     * @param e
     */
    private void alterBtnActionPerformed(ActionEvent e) {
        int result = JOptionPane.showConfirmDialog(null, "您是否确认修改信息？");
        if (result == 0) {
            if (!userNameTextField.getText().equals(oldUserName)) {
                /*
                把查询的用户的where条件封装成一个user对象
                 */
                User conditionUser = new User();
                conditionUser.setUserName(userNameTextField.getText());
                if (userService.findIsExistUserName(conditionUser)) {
                    /*
                    提示数据库中已经存在了该昵称
                     */
                    JOptionPane.showMessageDialog(null, "该昵称已存在！");
                    return;
                } else {
                    this.alter();
                }
            } else {
                this.alter();
            }
        }
    }

    /*
    修改个人信息的方法
     */
    private void alter() {
        /*
        把各个表中涉及该用户的个人信息的数据修改过来，where条件封装成各个表对应的数据
         */
        User user = new User();
        user.setUserName(userNameTextField.getText());
        user.setUserSex(userSexTextField.getText());
        user.setUserBirthday(userBirthdayTextField.getText());
        user.setUserDescription(userDescriptionTextArea.getText());

        Incident incident = new Incident();
        incident.setPublisher(userNameTextField.getText());

        Comment comment = new Comment();
        comment.setCommentPublisher(userNameTextField.getText());

        Collection collection = new Collection();
        collection.setCollector(userNameTextField.getText());

        Follow follow = new Follow();
        follow.setFollower(userNameTextField.getText());

        Report report1 = new Report();
        report1.setReporter(userNameTextField.getText());

        Report report2 = new Report();
        report2.setIncidentPublisher(userNameTextField.getText());

        /*
        调用service层方法
         */
        boolean x1 = userService.modifyUserByLoginName(user, loginNameTextField.getText());
        boolean x2 = incidentService.modifyIncidentByPublisher(incident, oldUserName);
        boolean x3 = commentService.modifyCommentByCommentPublisher(comment, oldUserName);
        boolean x4 = collectionService.modifyCollectionByCollector(collection, oldUserName);
        boolean x5 = followService.modifyFollowerByFollower(follow, oldUserName);
        boolean x6 = reportService.modifyReportByReporter(report1, oldUserName);
        boolean x7 = reportService.modifyReportByIncidentPublisher(report2, oldUserName);

        this.judge = x1 || x2 || x3 || x4 || x5 || x6 || x7;
        /*
        如果修改成功则刷新首页
         */
        if (this.judge) {
            JOptionPane.showMessageDialog(null, "修改成功！");
            dispose();
        } else {
            JOptionPane.showMessageDialog(null, "我们的数据库出现了问题，正在维护中，修改失败了~！");
            dispose();
        }
    }

    /**
     * 根据返回结果判断是否需要刷新用户主界面
     */
    public boolean getResult() {
        if (this.judge) return true;
        else return false;
    }

    /*
    swing布局
     */
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label6 = new JLabel();
        label1 = new JLabel();
        loginNameTextField = new JTextField();
        label2 = new JLabel();
        userNameTextField = new JTextField();
        label3 = new JLabel();
        userSexTextField = new JTextField();
        label4 = new JLabel();
        userBirthdayTextField = new JTextField();
        label5 = new JLabel();
        userDescriptionTextArea = new JTextArea();
        alterBtn = new JButton();

        //======== this ========
        Container contentPane = getContentPane();

        //---- label6 ----
        label6.setText("\u4e2a\u4eba\u4fe1\u606f");
        label6.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 28));

        //---- label1 ----
        label1.setText("\u8d26\u53f7\uff1a");
        label1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        //---- loginNameTextField ----
        loginNameTextField.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));
        loginNameTextField.setEditable(false);

        //---- label2 ----
        label2.setText("\u7528\u6237\u540d\uff1a");
        label2.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        //---- userNameTextField ----
        userNameTextField.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        //---- label3 ----
        label3.setText("\u6027\u522b\uff1a");
        label3.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        //---- userSexTextField ----
        userSexTextField.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        //---- label4 ----
        label4.setText("\u751f    \u65e5\uff1a");
        label4.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        //---- userBirthdayTextField ----
        userBirthdayTextField.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        //---- label5 ----
        label5.setText("\u4e2a\u4eba\u63cf\u8ff0\uff1a");
        label5.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        //---- userDescriptionTextArea ----
        userDescriptionTextArea.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));

        //---- alterBtn ----
        alterBtn.setText("\u786e\u8ba4\u4fee\u6539");
        alterBtn.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));
        alterBtn.addActionListener(e -> alterBtnActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addComponent(label5)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(userDescriptionTextArea, GroupLayout.PREFERRED_SIZE, 539, GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(52, Short.MAX_VALUE))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGroup(contentPaneLayout.createParallelGroup()
                                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(loginNameTextField, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                                .addComponent(label3, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(userSexTextField, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)))
                                                .addGap(76, 76, 76)
                                                .addGroup(contentPaneLayout.createParallelGroup()
                                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                                .addComponent(label4, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                                                                .addComponent(userBirthdayTextField, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                                .addComponent(label2)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                                                                .addComponent(userNameTextField, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)))
                                                .addGap(35, 35, 35))))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                .addContainerGap(319, Short.MAX_VALUE)
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                                .addComponent(label6, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE)
                                                .addGap(208, 208, 208))
                                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                                .addComponent(alterBtn, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
                                                .addGap(306, 306, 306))))
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addComponent(label6, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(loginNameTextField, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(userNameTextField, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
                                .addGap(39, 39, 39)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label4, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(userBirthdayTextField, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label3, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(userSexTextField, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
                                .addGap(46, 46, 46)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label5, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(userDescriptionTextArea, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                                .addComponent(alterBtn, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
}
