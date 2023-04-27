/*
 * Created by JFormDesigner on Wed Mar 31 00:41:27 CST 2021
 */

package com.wjh.www.view.UserView;

import java.awt.event.*;

import com.wjh.www.po.Collection;
import com.wjh.www.po.Follow;
import com.wjh.www.po.Incident;
import com.wjh.www.service.impl.CollectionServiceImpl;
import com.wjh.www.service.impl.IncidentServiceImpl;
import com.wjh.www.service.impl.FollowServiceImpl;
import com.wjh.www.service.CollectionService;
import com.wjh.www.service.IncidentService;
import com.wjh.www.service.FollowService;
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
public class InquireIncidentView extends JDialog {
    /**
     * 瓜圈名字
     */
    private String circleName;
    /**
     * 对事件发表评论的人或查询当前瓜的评论的人，即当前用户
     */
    private String userName;
    /**
     * 当前用户发表评价的事件的标题或查询当前事件的标题
     */
    private String incidentTitle;
    /**
     * 当前用户发表评价的事件的标题或查询当前事件的内容
     */
    private String incidentContent;
    /**
     * 被评价的事件的发布者
     */
    private String incidentPublisher;
    List<Incident> list = null;


    /**
     * 当前窗体的父窗体
     */
    private JDialog jDialog;

    private final IncidentService incidentService = new IncidentServiceImpl();
    private final CollectionService collectionService = new CollectionServiceImpl();
    private final FollowService followService = new FollowServiceImpl();

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JScrollPane scrollPane1;
    private JTable table;
    private JLabel label2;
    private JTextField incidentTitleTextField;
    private JLabel label3;
    private JTextField incidentPublisherTextField;
    private JLabel label4;
    private JTextField incidentPublishTimeTextField;
    private JLabel label5;
    private JScrollPane scrollPane2;
    private JTextArea incidentContentTextArea;
    private JButton likeBtn;
    private JButton lookCommentBtn;
    private JButton publishCommentBtn;
    private JButton collectIncidentBtn;
    private JButton cancelLikeBtn;
    private JButton reportBtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public InquireIncidentView(JDialog jDialog, String userName, String circleName) {
        super(jDialog, true);
        this.circleName = circleName;
        this.userName = userName;
        this.jDialog = jDialog;
        initComponents();
        this.fillTable();
        this.setVisible(true);
    }

    /**
     * 给表格添加鼠标点击事件监听
     *
     * @param e
     */
    private void tableMousePressed(MouseEvent e) {
        //返回值row表示选择的列的索引
        int row = table.getSelectedRow();
        Incident incident = list.get(row);
        incidentTitleTextField.setText(incident.getIncidentTitle());
        incidentPublisherTextField.setText(incident.getPublisher());
        incidentPublishTimeTextField.setText(incident.getPublishTime());
        incidentContentTextArea.setText(incident.getIncidentContent());

        //获取评论的事件的标题
        incidentTitle = incident.getIncidentTitle();
        //获取当前瓜的发布者
        incidentPublisher = incident.getPublisher();
        //获取内容
        incidentContent = incident.getIncidentContent();

    }

    /**
     * 给发布瓜按钮添加事件监听
     *
     * @param e
     */
    private void publishCommentBtnActionPerformed(ActionEvent e) {
        if (incidentTitle == null) {
            JOptionPane.showMessageDialog(null, "请您先选择瓜！");
            return;
        } else {
            new publishCommentView(this, incidentTitle, userName);
        }
    }

    /**
     * 给查看评论按钮添加事件监听
     *
     * @param e
     */
    private void lookCommentBtnActionPerformed(ActionEvent e) {
        if (incidentTitle == null) {
            JOptionPane.showMessageDialog(null, "请您先选择瓜！");
            return;
        } else {
            new InquireCommentView(this, incidentTitle, userName, incidentPublisher);
        }
    }

    /**
     * 给收藏按钮添加事件监听
     *
     * @param e
     */
    private void collectIncidentBtnActionPerformed(ActionEvent e) {
        if (incidentTitle == null) {
            JOptionPane.showMessageDialog(null, "请您先选择瓜！");
            return;
        } else {
            /*
            把查询条件封装成一个collection对象
             */
            Collection conditionCollection = new Collection();
            conditionCollection.setIncidentTitle(incidentTitle);
            conditionCollection.setCollector(userName);
            if (collectionService.findIsExistCollection(conditionCollection)) {
                JOptionPane.showMessageDialog(null, "您已经收藏过该瓜了！");
            } else {
                int result = JOptionPane.showConfirmDialog(null, "您是否确认收藏该瓜？");
                if (result == 0) {
                    Collection collection = new Collection();
                    collection.setIncidentTitle(incidentTitle);
                    collection.setCollector(userName);
                    if (collectionService.saveCollection(collection)) {
                        JOptionPane.showMessageDialog(null, "收藏成功！");
                    }
                }
            }
        }
    }

    /**
     * 给点赞按钮添加事件监听
     *
     * @param e
     */
    private void likeBtnActionPerformed(ActionEvent e) {
        if (incidentTitle == null) {
            JOptionPane.showMessageDialog(null, "请您先选择瓜！");
            return;
        }
        /*
        把查询条件封装成一个follow对象
         */
        Follow condotionFollow = new Follow();
        condotionFollow.setFollower(userName);
        condotionFollow.setIncidentTitle(incidentTitle);
        if (followService.findIsExistFollower(condotionFollow)) {
            JOptionPane.showMessageDialog(null, "你已经点赞过该瓜了!");
            return;
        } else {
            Follow follow = new Follow();
            follow.setFollower(userName);
            follow.setIncidentTitle(incidentTitle);
            if (followService.saveFollower(follow)) {
                Incident incident = new Incident();
                incident.setIncidentTitle(incidentTitle);
                /*
                赞加1
                 */
                if (incidentService.modifyPlusOneLikeNum(incident)) {
                    JOptionPane.showMessageDialog(null, "点赞成功！");
                } else {
                    JOptionPane.showMessageDialog(null, "我们的数据库出现了问题，点赞失败了，正在维护中~");
                }
                dispose();
                new InquireIncidentView(jDialog, userName, circleName);
            }
        }
    }

    /**
     * 给取消点赞添加事件监听
     *
     * @param e
     */
    private void cancelLikeBtnActionPerformed(ActionEvent e) {
        if (incidentTitle == null) {
            JOptionPane.showMessageDialog(null, "请您先选择瓜！");
            return;
        }

        /*
        把查询条件封装成一个follow对象
         */
        Follow condotionFollow = new Follow();
        condotionFollow.setFollower(userName);
        condotionFollow.setIncidentTitle(incidentTitle);
        if (!followService.findIsExistFollower(condotionFollow)) {
            JOptionPane.showMessageDialog(null, "你还没有点赞该瓜!");
            return;
        } else {
            /*
            把取消点赞者的相关信息封装成一个对象
             */
            Follow conditionFollow = new Follow();
            conditionFollow.setFollower(userName);
            conditionFollow.setIncidentTitle(incidentTitle);
            if (followService.removeFollower(conditionFollow)) {
                Incident incident = new Incident();
                incident.setIncidentTitle(incidentTitle);
                if (incidentService.modifyMinusOneLikeNum(incident)) {
                    JOptionPane.showMessageDialog(null, "取消点赞成功！");
                } else {
                    JOptionPane.showMessageDialog(null, "我们的数据库出现了问题，取消点赞失败了，正在维护中~");
                }
                dispose();
                new InquireIncidentView(jDialog, userName, circleName);
            }
        }
    }

    /**
     * 给举报按钮添加事件监听
     *
     * @param e
     */
    private void reportBtnActionPerformed(ActionEvent e) {
        if (StringUtils.isEmpty(incidentTitle)) {
            JOptionPane.showMessageDialog(null, "请先选择要举报的瓜！");
            return;
        } else {
            new ReportView(this, incidentTitle, incidentContent, circleName, userName, incidentPublisher);
        }
    }

    /**
     * 初始化表格数据
     */
    private void fillTable() {
        /*
        把查询条件封装成一个incident对象
         */
        Incident conditionIncident = new Incident();
        conditionIncident.setBelongCircle(circleName);
        list = incidentService.findListIncidents(conditionIncident);
        if (list != null) {
            int i = 0;
            DefaultTableModel dtm = (DefaultTableModel) table.getModel();
            dtm.setRowCount(0);
            for (Incident incident : list) {
                i = i + 1;
                Vector<String> vector = new Vector<String>();
                vector.add(String.valueOf(i));
                vector.add(incident.getIncidentTitle());
                vector.add(incident.getPublisher());
                vector.add(String.valueOf(incident.getLikeNum()));
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
        label2 = new JLabel();
        incidentTitleTextField = new JTextField();
        label3 = new JLabel();
        incidentPublisherTextField = new JTextField();
        label4 = new JLabel();
        incidentPublishTimeTextField = new JTextField();
        label5 = new JLabel();
        scrollPane2 = new JScrollPane();
        incidentContentTextArea = new JTextArea();
        likeBtn = new JButton();
        lookCommentBtn = new JButton();
        publishCommentBtn = new JButton();
        collectIncidentBtn = new JButton();
        cancelLikeBtn = new JButton();
        reportBtn = new JButton();

        //======== this ========
        setTitle("\u5403\u74dc\u754c\u9762");
        Container contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u6b22\u8fce\u5403\u74dc");
        label1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 28));

        //======== scrollPane1 ========
        {

            //---- table ----
            table.setModel(new DefaultTableModel(
                    new Object[][]{
                            {null, null, null, null},
                            {null, null, null, null},
                            {null, null, null, null},
                            {null, null, null, null},
                    },
                    new String[]{
                            "\u7f16\u53f7", "\u74dc\u7684\u6807\u9898", "\u74dc\u7684\u53d1\u5e03\u8005", "\u70b9\u8d5e\u6570"
                    }
            ) {
                boolean[] columnEditable = new boolean[]{
                        false, false, false, false
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

        //---- label2 ----
        label2.setText("\u6807   \u9898\uff1a");
        label2.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        //---- incidentTitleTextField ----
        incidentTitleTextField.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));
        incidentTitleTextField.setEditable(false);

        //---- label3 ----
        label3.setText("\u53d1\u5e03\u8005\uff1a");
        label3.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        //---- incidentPublisherTextField ----
        incidentPublisherTextField.setEditable(false);
        incidentPublisherTextField.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        //---- label4 ----
        label4.setText("\u53d1\u5e03\u65f6\u95f4\uff1a");
        label4.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        //---- incidentPublishTimeTextField ----
        incidentPublishTimeTextField.setEditable(false);
        incidentPublishTimeTextField.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        //---- label5 ----
        label5.setText("\u5185   \u5bb9\uff1a");
        label5.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        //======== scrollPane2 ========
        {

            //---- incidentContentTextArea ----
            incidentContentTextArea.setEditable(false);
            incidentContentTextArea.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
            scrollPane2.setViewportView(incidentContentTextArea);
        }

        //---- likeBtn ----
        likeBtn.setText("\u70b9\u8d5e");
        likeBtn.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 16));
        likeBtn.addActionListener(e -> likeBtnActionPerformed(e));

        //---- lookCommentBtn ----
        lookCommentBtn.setText("\u67e5\u770b\u8bc4\u8bba");
        lookCommentBtn.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 16));
        lookCommentBtn.addActionListener(e -> lookCommentBtnActionPerformed(e));

        //---- publishCommentBtn ----
        publishCommentBtn.setText("\u6211\u8981\u8bc4\u8bba");
        publishCommentBtn.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 16));
        publishCommentBtn.addActionListener(e -> publishCommentBtnActionPerformed(e));

        //---- collectIncidentBtn ----
        collectIncidentBtn.setText("\u6536\u85cf");
        collectIncidentBtn.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 16));
        collectIncidentBtn.addActionListener(e -> collectIncidentBtnActionPerformed(e));

        //---- cancelLikeBtn ----
        cancelLikeBtn.setText("\u53d6\u6d88\u70b9\u8d5e");
        cancelLikeBtn.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 16));
        cancelLikeBtn.addActionListener(e -> {
            //	cancleLikeBtnActionPerformed(e);
            cancelLikeBtnActionPerformed(e);
        });

        //---- reportBtn ----
        reportBtn.setText("\u4e3e\u62a5");
        reportBtn.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 16));
        reportBtn.addActionListener(e -> reportBtnActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addComponent(label5, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(scrollPane2))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addComponent(label3)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(incidentPublisherTextField, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(label4)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(incidentPublishTimeTextField, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 733, Short.MAX_VALUE)
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGroup(contentPaneLayout.createParallelGroup()
                                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                                .addComponent(label2)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(incidentTitleTextField, GroupLayout.PREFERRED_SIZE, 469, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                                .addComponent(likeBtn, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(cancelLikeBtn, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(22, 22, 22)
                                                                .addComponent(lookCommentBtn, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(publishCommentBtn, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(29, 29, 29)
                                                                .addComponent(collectIncidentBtn, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(reportBtn, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)))
                                                .addGap(0, 1, Short.MAX_VALUE)))
                                .addGap(84, 84, 84))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                .addContainerGap(371, Short.MAX_VALUE)
                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
                                .addGap(297, 297, 297))
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
                                .addGap(57, 57, 57)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label2)
                                        .addComponent(incidentTitleTextField, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label3)
                                        .addComponent(incidentPublisherTextField, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(incidentPublishTimeTextField, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label4, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGap(34, 34, 34)
                                                .addComponent(label5))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGap(44, 44, 44)
                                                .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(likeBtn)
                                                .addComponent(lookCommentBtn)
                                                .addComponent(publishCommentBtn)
                                                .addComponent(cancelLikeBtn))
                                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(collectIncidentBtn)
                                                .addComponent(reportBtn)))
                                .addGap(32, 32, 32))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
}
