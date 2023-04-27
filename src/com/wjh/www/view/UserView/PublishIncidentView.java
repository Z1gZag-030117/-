/*
 * Created by JFormDesigner on Tue Mar 30 10:32:02 CST 2021
 */

package com.wjh.www.view.UserView;

import com.wjh.www.po.Incident;
import com.wjh.www.service.impl.IncidentServiceImpl;
import com.wjh.www.service.IncidentService;
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
public class PublishIncidentView extends JDialog {
    /**
     * 发布瓜时所属的瓜圈
     */
    private String circleName;
    /**
     * 事件的发布者
     */
    private String publisher;

    private IncidentService incidentService = new IncidentServiceImpl();
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label2;
    private JTextField incidentTitleTextField;
    private JLabel label3;
    private JScrollPane scrollPane1;
    private JTextArea contentTextArea;
    private JButton publishBtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public PublishIncidentView(JDialog jDialog, String userName, String circleName) {
        super(jDialog, true);
        this.circleName = circleName;
        this.publisher = userName;
        initComponents();
        this.setVisible(true);
    }

    /**
     * 给发布按钮添加事件监听
     *
     * @param e
     */
    private void publishBtnActionPerformed(ActionEvent e) {
        /*
        进行简单的前台校验
         */
        int x = 0;
        if (StringUtils.isEmpty(incidentTitleTextField.getText())) {
            JOptionPane.showMessageDialog(null, "标题不能为空！");
            return;
        }
        if (StringUtils.isEmpty(contentTextArea.getText())) {
            JOptionPane.showMessageDialog(null, "内容不能为空！");
            return;
        }
        int result = JOptionPane.showConfirmDialog(null, "是否确定发布瓜？");
        if (result == 0) {
            /*
            把发布的瓜的数据封装成一个incident对象
             */
            Incident incident = new Incident();
            incident.setIncidentTitle(incidentTitleTextField.getText());
            incident.setIncidentContent(contentTextArea.getText());
            incident.setPublisher(publisher);
            incident.setPublishTime(BaseUtils.getTime());
            incident.setLikeNum(new Integer(0));
            incident.setBelongCircle(circleName);
            if (incidentService.saveIncident(incident)) {
                incidentTitleTextField.setText("");
                contentTextArea.setText("");
                JOptionPane.showMessageDialog(null, "发布瓜成功！");
                dispose();
                return;
            } else {
                JOptionPane.showMessageDialog(null, "我们的数据库出现了问题，正在维护中，发布失败了~");
                return;
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
        contentTextArea = new JTextArea();
        publishBtn = new JButton();

        //======== this ========
        setTitle("\u53d1\u8868\u4e8b\u4ef6\u754c\u9762");
        Container contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u53d1\u8868\u4e8b\u4ef6");
        label1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 28));

        //---- label2 ----
        label2.setText("\u6807\u9898\uff1a");
        label2.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 24));

        //---- incidentTitleTextField ----
        incidentTitleTextField.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 24));

        //---- label3 ----
        label3.setText("\u5185\u5bb9\uff1a");
        label3.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 24));

        //======== scrollPane1 ========
        {

            //---- contentTextArea ----
            contentTextArea.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
            scrollPane1.setViewportView(contentTextArea);
        }

        //---- publishBtn ----
        publishBtn.setText("\u53d1\u8868");
        publishBtn.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 18));
        publishBtn.addActionListener(e -> publishBtnActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGap(94, 94, 94)
                                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(label3, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                                                        .addComponent(label2, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(contentPaneLayout.createParallelGroup()
                                                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 505, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(incidentTitleTextField)))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGap(350, 350, 350)
                                                .addComponent(publishBtn, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(133, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                .addGap(0, 346, Short.MAX_VALUE)
                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
                                .addGap(269, 269, 269))
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(incidentTitleTextField, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGap(26, 26, 26)
                                                .addComponent(label3, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGap(35, 35, 35)
                                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                                .addComponent(publishBtn)
                                .addGap(25, 25, 25))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
}
