/*
 * Created by JFormDesigner on Wed Mar 31 19:21:52 CST 2021
 */

package com.wjh.www.view.UserView;

import com.wjh.www.po.Comment;
import com.wjh.www.service.impl.CommentServiceImpl;
import com.wjh.www.service.CommentService;
import com.wjh.www.util.StringUtils;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author wjh
 */
@SuppressWarnings("all")
public class publishCommentView extends JDialog {
    /**
     * 被评论的事件的标题
     */
    private String commentTitle;
    /**
     * 评论的发布者
     */
    private String commentPublisher;

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label2;
    private JTextField incidentTitleTextField;
    private JLabel label3;
    private JScrollPane scrollPane1;
    private JTextArea commentContentTextArea;
    private JLabel label4;
    private JButton publishBtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public publishCommentView(JDialog jDialog, String commentTitle, String commentPublisher) {
        super(jDialog, "发表我的评论", true);
        this.commentTitle = commentTitle;
        this.commentPublisher = commentPublisher;
        initComponents();
        this.incidentTitleTextField.setText(this.commentTitle);
        this.setVisible(true);
    }

    /**
     * 给发布瓜按钮添加事件监听
     *
     * @param e
     */
    private void publishBtnActionPerformed(ActionEvent e) {
        /*
        进行简单的前台校验
         */
        if (StringUtils.isEmpty(commentContentTextArea.getText())) {
            JOptionPane.showMessageDialog(null, "评论内容不能为空！");
            return;
        }
        int result = JOptionPane.showConfirmDialog(null, "您是否确认发表该条评论？");
        if (result == 0) {
            /*
            把添加的数据封装成一个commemt对象
             */
            Comment comment = new Comment();
            comment.setCommentPublisher(commentPublisher);
            comment.setCommentContent(commentContentTextArea.getText());
            comment.setIncidentTitle(commentTitle);
            CommentService commentService = new CommentServiceImpl();
            if (commentService.saveComment(comment)) {
                JOptionPane.showMessageDialog(null, "发表评论成功！");
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "我们的数据库出现问题，正在维护中，发布失败啦~");
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
        commentContentTextArea = new JTextArea();
        label4 = new JLabel();
        publishBtn = new JButton();

        //======== this ========
        setTitle("\u53d1\u8868\u8bc4\u4ef7");
        Container contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u53d1\u8868\u8bc4\u4ef7");
        label1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 26));

        //---- label2 ----
        label2.setText("\u74dc\u7684\u6807\u9898\uff1a");
        label2.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        //---- incidentTitleTextField ----
        incidentTitleTextField.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));
        incidentTitleTextField.setEditable(false);

        //---- label3 ----
        label3.setText("\u6211\u7684\u8bc4\u8bba\uff1a");
        label3.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        //======== scrollPane1 ========
        {

            //---- commentContentTextArea ----
            commentContentTextArea.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
            scrollPane1.setViewportView(commentContentTextArea);
        }

        //---- label4 ----
        label4.setText("\u6e29\u99a8\u63d0\u793a\uff1a\u5927\u5bb6\u90fd\u662f\u6587\u660e\u4eba\uff0c\u8bf7\u6ce8\u610f\u7528\u8bed\u6587\u660e\uff01");
        label4.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        //---- publishBtn ----
        publishBtn.setText("\u53d1\u8868");
        publishBtn.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));
        publishBtn.addActionListener(e -> {
            //button1ActionPerformed(e);
            publishBtnActionPerformed(e);
        });

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addContainerGap(130, Short.MAX_VALUE)
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addComponent(label3)
                                                        .addComponent(label2))
                                                .addGap(18, 18, 18)
                                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
                                                        .addComponent(incidentTitleTextField, GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE))
                                                .addGap(123, 123, 123))
                                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
                                                .addGap(319, 319, 319))
                                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                                .addComponent(publishBtn)
                                                .addGap(325, 325, 325))
                                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                                .addComponent(label4)
                                                .addGap(167, 167, 167))))
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(incidentTitleTextField, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGap(37, 37, 37)
                                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGap(27, 27, 27)
                                                .addComponent(label3, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                                .addComponent(label4, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(publishBtn)
                                .addGap(42, 42, 42))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
}
