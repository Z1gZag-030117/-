/*
 * Created by JFormDesigner on Sat Apr 03 20:23:19 CST 2021
 */

package com.wjh.www.view.UserView;

import com.wjh.www.po.Report;
import com.wjh.www.service.impl.ReportServiceImpl;
import com.wjh.www.service.ReportService;
import com.wjh.www.util.StringUtils;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author wjh
 */
@SuppressWarnings("all")
public class ReportView extends JDialog {
    /**
     * 被举报的事件的标题
     */
    private String incidentTitle;
    /**
     * 被举报的事件的内容
     */
    private String incidentContent;
    /**
     * 被举报的事件所属瓜圈
     */
    private String circleName;
    /**
     * 用户的昵称
     */
    private String userName;
    /**
     * 被举报的事件的发布者
     */
    private String incidentPublisher;

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label2;
    private JTextField incidentTitleTextField;
    private JLabel label3;
    private JScrollPane scrollPane1;
    private JTextArea reasonTextArea;
    private JButton reportBtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public ReportView(JDialog jDialog, String incidentTitle, String incidentContent, String circleName, String userName, String incidentPublisher) {
        super(jDialog, true);
        this.incidentTitle = incidentTitle;
        this.incidentContent = incidentContent;
        this.circleName = circleName;
        this.userName = userName;
        this.incidentPublisher = incidentPublisher;
        initComponents();
        incidentTitleTextField.setText(incidentTitle);
        this.setVisible(true);
    }

    /**
     * 给举报按钮添加事件监听
     *
     * @param e
     */
    private void reportBtnActionPerformed(ActionEvent e) {
        if (StringUtils.isEmpty(reasonTextArea.getText())) {
            JOptionPane.showMessageDialog(null, "请输入举报原因！");
            return;
        }
        int result = JOptionPane.showConfirmDialog(null, "你是否确认举报");
        if (result == 0) {
            /*
            把该举报事件封装成一个report对象
             */
            ReportService reportService = new ReportServiceImpl();
            Report report = new Report();
            report.setIncidentTitle(incidentTitle);
            report.setIncidentContent(incidentContent);
            report.setReportReason(reasonTextArea.getText());
            report.setBelongCircle(circleName);
            report.setReporter(userName);
            report.setIncidentPublisher(incidentPublisher);
            if (reportService.saveReport(report)) {
                JOptionPane.showMessageDialog(null, "举报成功，请等待管理员处理...");
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "我们的数据库出现问题了，正在维护中，举报失败了~");
            }
        }
    }

    /*
    swing布局
     */
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label2 = new JLabel();
        incidentTitleTextField = new JTextField();
        label3 = new JLabel();
        scrollPane1 = new JScrollPane();
        reasonTextArea = new JTextArea();
        reportBtn = new JButton();

        //======== this ========
        setTitle("\u4e3e\u62a5\u74dc");
        Container contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u4e3e\u62a5");
        label1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 28));

        //---- label2 ----
        label2.setText("\u4e3e\u62a5\u7684\u74dc\uff1a");
        label2.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        //---- incidentTitleTextField ----
        incidentTitleTextField.setEditable(false);
        incidentTitleTextField.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        //---- label3 ----
        label3.setText("\u4e3e\u62a5\u539f\u56e0\uff1a");
        label3.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        //======== scrollPane1 ========
        {

            //---- reasonTextArea ----
            reasonTextArea.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
            scrollPane1.setViewportView(reasonTextArea);
        }

        //---- reportBtn ----
        reportBtn.setText("\u786e\u8ba4\u4e3e\u62a5");
        reportBtn.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));
        reportBtn.addActionListener(e -> reportBtnActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGap(302, 302, 302)
                                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGap(69, 69, 69)
                                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(label3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(label2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(incidentTitleTextField, GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
                                                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGap(260, 260, 260)
                                                .addComponent(reportBtn, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(175, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(label2, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                                        .addComponent(incidentTitleTextField, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
                                .addGap(120, 120, 120)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label3, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(reportBtn, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(54, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

}
