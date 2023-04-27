/*
 * Created by JFormDesigner on Wed Mar 31 20:38:31 CST 2021
 */

package com.wjh.www.view.UserView;

import java.awt.event.*;

import com.wjh.www.po.Comment;
import com.wjh.www.service.impl.CommentServiceImpl;
import com.wjh.www.service.CommentService;
import com.wjh.www.util.StringUtils;

import java.awt.*;
import java.util.List;
import java.util.Vector;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.*;

/**
 * @author wjh
 */
@SuppressWarnings("all")
public class InquireCommentView extends JDialog {
    /**
     * 事件发布者
     */
    private String incidentPublisher;
    /**
     * 被评论的事件的标题
     */
    private String incidentTitle;
    /**
     * 当前评论的评论人
     */
    private String commentPublisher;
    /**
     * 当前评论的内容
     */
    private String commentContent;
    /**
     * 当前用户
     */
    private String userName;
    /**
     * 当前窗体的父窗体
     */
    private JDialog jDialog = null;
    /*
    被表格展示的评论
     */
    private List<Comment> list = null;

    private final CommentService commentService = new CommentServiceImpl();

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JScrollPane scrollPane1;
    private JTable table;
    private JScrollPane scrollPane2;
    private JTextArea commentContentTextArea;
    private JButton deleteCommentBtn;
    private JButton deleteAllCommentBtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public InquireCommentView(JDialog jDialog, String incidentTitle, String userName, String incidentPublisher) {
        super(jDialog, true);
        this.incidentPublisher = incidentPublisher;
        this.incidentTitle = incidentTitle;
        this.userName = userName;
        this.jDialog = jDialog;
        initComponents();
        this.fillTable();
        this.setVisible(true);
    }

    /**
     * 给表格添加鼠标点击事件
     *
     * @param e
     */
    private void tableMousePressed(MouseEvent e) {
        int row = table.getSelectedRow();//返回值row表示选择的列的索引
        commentContentTextArea.setText((String) table.getValueAt(row, 1));
        commentContent = (String) table.getValueAt(row, 1);
        commentPublisher = (String) table.getValueAt(row, 2);
    }

    /**
     * 给删除该评论按钮添加事件监听
     *
     * @param e
     */
    private void deleteCommentBtnActionPerformed(ActionEvent e) {
        if (StringUtils.isEmpty(commentContent)) {
            JOptionPane.showMessageDialog(null, "请您先选择要删除的评论！");
            return;
        }
        if (!userName.equals(commentPublisher)) {
            JOptionPane.showMessageDialog(null, "您无权删除他人的评论！");
            return;
        } else {
            int result = JOptionPane.showConfirmDialog(null, "是否删除该条评论？");
            if (result == 0) {
                /*
                把删除瓜的where条件封装成一个对象
                 */
                Comment conditionComment = new Comment();
                conditionComment.setCommentPublisher(userName);
                conditionComment.setCommentContent(commentContent);
                conditionComment.setIncidentTitle(incidentTitle);
                if (commentService.removeComment(conditionComment)) {
                    JOptionPane.showMessageDialog(null, "删除该条评论成功！");
                    dispose();
                    new InquireCommentView(jDialog, incidentTitle, userName, incidentPublisher);
                } else {
                    JOptionPane.showMessageDialog(null, "我们的数据库出现了问题，正在维护中，删除失败啦~！");
                }
            }
        }
    }

    /**
     * 删除所有评论按钮添加事件监听
     *
     * @param e
     */
    private void deleteAllCommentBtnActionPerformed(ActionEvent e) {
        /*
        进行简单的前台校验
         */
        if (!userName.equals(incidentPublisher) || !userName.equals(incidentPublisher)) {
            JOptionPane.showMessageDialog(null, "您无权删除他人发布的瓜下的所有评论！");
            return;
        } else {
            int result = JOptionPane.showConfirmDialog(null, "是否删除全部评论？");
            if (result == 0) {
                /*
                把删除的瓜的where条件封装成一个对象
                 */
                Comment conditionComment = new Comment();
                conditionComment.setIncidentTitle(incidentTitle);
                if (commentService.removeComment(conditionComment)) {
                    JOptionPane.showMessageDialog(null, "删除全部评论成功！");
                    dispose();
                    new InquireCommentView(jDialog, incidentTitle, userName, incidentPublisher);
                } else {
                    JOptionPane.showMessageDialog(null, "我们的数据库出现了问题，正在维护中，删除失败啦~！");
                }
            }
        }
    }

    /**
     * 初始化表格信息
     */
    private void fillTable() {
        /*
        把查询条件封装成一个对象
         */
        Comment conditionComment = new Comment();
        conditionComment.setIncidentTitle(incidentTitle);
        list = commentService.findListComment(conditionComment);
        if (list != null) {
            int i = 0;
            DefaultTableModel dtm = (DefaultTableModel) table.getModel();
            dtm.setRowCount(0);
            for (Comment comment : list) {
                i++;
                Vector<String> vector = new Vector<String>();
                vector.add(i + "楼");
                vector.add(comment.getCommentContent());
                vector.add(comment.getCommentPublisher());
                dtm.addRow(vector);
            }
        }
    }

    /*
    swing布局
     */
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        scrollPane1 = new JScrollPane();
        table = new JTable();
        scrollPane2 = new JScrollPane();
        commentContentTextArea = new JTextArea();
        deleteCommentBtn = new JButton();
        deleteAllCommentBtn = new JButton();

        //======== this ========
        setTitle("\u67e5\u770b\u8bc4\u8bba");
        Container contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u7528\u6237\u8bc4\u8bba");
        label1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 26));

        //======== scrollPane1 ========
        {

            //---- table ----
            table.setModel(new DefaultTableModel(
                    new Object[][]{
                            {null, null, ""},
                            {null, null, null},
                            {null, null, null},
                            {null, null, null},
                            {null, null, null},
                            {null, null, null},
                            {null, null, null},
                            {null, null, null},
                            {null, null, null},
                            {null, null, null},
                            {null, null, null},
                            {null, null, null},
                            {null, null, null},
                            {null, null, null},
                    },
                    new String[]{
                            "\u7f16\u53f7", "\u8bc4\u8bba", "\u8bc4\u8bba\u7528\u6237"
                    }
            ) {
                boolean[] columnEditable = new boolean[]{
                        false, false, false
                };

                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return columnEditable[columnIndex];
                }
            });
            table.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    tableMousePressed(e);
                }
            });
            scrollPane1.setViewportView(table);
        }

        //======== scrollPane2 ========
        {

            //---- commentContentTextArea ----
            commentContentTextArea.setEditable(false);
            commentContentTextArea.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
            scrollPane2.setViewportView(commentContentTextArea);
        }

        //---- deleteCommentBtn ----
        deleteCommentBtn.setText("\u5220\u9664\u6539\u8bc4\u8bba");
        deleteCommentBtn.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 16));
        deleteCommentBtn.addActionListener(e -> deleteCommentBtnActionPerformed(e));

        //---- deleteAllCommentBtn ----
        deleteAllCommentBtn.setText("\u5220\u9664\u5168\u90e8\u8bc4\u8bba");
        deleteAllCommentBtn.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 16));
        deleteAllCommentBtn.addActionListener(e -> deleteAllCommentBtnActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addContainerGap(391, Short.MAX_VALUE)
                                                .addGroup(contentPaneLayout.createParallelGroup()
                                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 165, Short.MAX_VALUE))
                                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                                .addGap(0, 51, Short.MAX_VALUE)
                                                                .addComponent(deleteCommentBtn, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(deleteAllCommentBtn))))
                                        .addGroup(GroupLayout.Alignment.LEADING, contentPaneLayout.createSequentialGroup()
                                                .addGap(17, 17, 17)
                                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 701, Short.MAX_VALUE)
                                                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 701, Short.MAX_VALUE))))
                                .addContainerGap(30, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 312, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(deleteAllCommentBtn)
                                        .addComponent(deleteCommentBtn))
                                .addContainerGap(7, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
}
