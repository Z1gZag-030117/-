/*
 * Created by JFormDesigner on Thu Apr 01 21:36:03 CST 2021
 */

package com.wjh.www.view.UserView;

import java.awt.event.*;

import com.wjh.www.po.*;
import com.wjh.www.service.*;
import com.wjh.www.service.impl.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.*;

/**
 * @author wjh
 */
@SuppressWarnings("all")
public class InquireMyPublishIncidentView extends JDialog {
    /**
     * 用户的昵称
     */
    private String userName;
    /*
    事件标题
     */
    private String incidentTitle;
    /*
    存放展示的数据的集合
     */
    private List<Incident> list = new ArrayList<Incident>();
    /**
     * 当前窗体的父窗体
     */
    private JFrame jFrame = null;

    private final IncidentService incidentService = new IncidentServiceImpl();
    private final CommentService commentService = new CommentServiceImpl();
    private final CollectionService collectionService = new CollectionServiceImpl();
    private final FollowService followService = new FollowServiceImpl();
    private final ReportService reportService = new ReportServiceImpl();


    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTable table;
    private JLabel label1;
    private JLabel label2;
    private JTextField titleTextField;
    private JTextField timeTextField;
    private JLabel label3;
    private JTextField likeNumTextField;
    private JLabel label4;
    private JTextField belongTextField;
    private JLabel label5;
    private JScrollPane scrollPane2;
    private JTextArea contentTextArea;
    private JButton deleteBtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public InquireMyPublishIncidentView(JFrame jFrame, String userName) {
        super(jFrame, true);
        this.userName = userName;
        this.jFrame = jFrame;
        initComponents();
        this.fillTable();
        this.setVisible(true);
    }

    /**
     * 给表格添加事件监听
     *
     * @param e
     */
    private void tableMousePressed(MouseEvent e) {
        int row = table.getSelectedRow();
        Incident incident = list.get(row);
        titleTextField.setText(incident.getIncidentTitle());
        incidentTitle = incident.getIncidentTitle();
        timeTextField.setText(incident.getPublishTime());
        likeNumTextField.setText(Integer.toString(incident.getLikeNum()));
        belongTextField.setText(incident.getBelongCircle());
        contentTextArea.setText(incident.getIncidentContent());
    }

    /**
     * 给删除瓜按钮添加事件监听
     *
     * @param e
     */
    private void deleteBtnActionPerformed(ActionEvent e) {
        int result = JOptionPane.showConfirmDialog(null, "您是否确认删除该瓜？");
        if (result == 0) {
            /*
            把删除的瓜的where条件封装成一个对象
             */
            Incident conditionIncident = new Incident();
            conditionIncident.setIncidentTitle(incidentTitle);
            conditionIncident.setPublisher(userName);

            Comment conditionComment = new Comment();
            conditionComment.setIncidentTitle(incidentTitle);

            Collection conditionCollection = new Collection();
            conditionCollection.setIncidentTitle(incidentTitle);

            Follow conditionFollow = new Follow();
            conditionFollow.setIncidentTitle(incidentTitle);

            Report conditionReport = new Report();
            conditionReport.setIncidentTitle(incidentTitle);
            conditionReport.setReporter(userName);

            boolean x1 = incidentService.removePublishIncident(conditionIncident);
            boolean x2 = commentService.removeComment(conditionComment);
            boolean x3 = collectionService.removeCollectionIncident(conditionCollection);
            boolean x4 = followService.removeFollower(conditionFollow);
            boolean x5 = reportService.removeReport(conditionReport);
            if (x1 || x2 || x3 || x4 || x5) {
                JOptionPane.showMessageDialog(null, "删除成功！");
                dispose();
                new InquireMyPublishIncidentView(jFrame, userName);
            } else {
                JOptionPane.showMessageDialog(null, "我们的数据出现了问题，正在维护中，删除失败啦~");
                return;
            }
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
        conditionIncident.setPublisher(userName);
        list = incidentService.findListIncidents(conditionIncident);
        /*
        把查询的数据展示在表格
         */
        if (list != null) {
            int i = 0;
            DefaultTableModel dtm = (DefaultTableModel) table.getModel();
            dtm.setRowCount(0);
            for (Incident incident : list) {
                i = i + 1;
                Vector<String> vector = new Vector<String>();
                vector.add(String.valueOf(i));
                vector.add(incident.getIncidentTitle());
                vector.add(incident.getBelongCircle());
                dtm.addRow(vector);
            }
        }
    }

    /*
    swing布局
     */
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        table = new JTable();
        label1 = new JLabel();
        label2 = new JLabel();
        titleTextField = new JTextField();
        timeTextField = new JTextField();
        label3 = new JLabel();
        likeNumTextField = new JTextField();
        label4 = new JLabel();
        belongTextField = new JTextField();
        label5 = new JLabel();
        scrollPane2 = new JScrollPane();
        contentTextArea = new JTextArea();
        deleteBtn = new JButton();

        //======== this ========
        Container contentPane = getContentPane();

        //======== scrollPane1 ========
        {

            //---- table ----
            table.setModel(new DefaultTableModel(
                    new Object[][]{
                            {null, null, null},
                            {null, null, null},
                            {null, null, null},
                    },
                    new String[]{
                            "\u7f16\u53f7", "\u74dc\u540d", "\u6240\u5c5e\u74dc\u5708"
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

        //---- label1 ----
        label1.setText("\u74dc        \u540d\uff1a");
        label1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        //---- label2 ----
        label2.setText("\u53d1\u5e03\u65f6\u95f4\uff1a");
        label2.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        //---- titleTextField ----
        titleTextField.setEditable(false);
        titleTextField.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        //---- timeTextField ----
        timeTextField.setEditable(false);
        timeTextField.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        //---- label3 ----
        label3.setText("\u70b9\u8d5e\u6570\uff1a");
        label3.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        //---- likeNumTextField ----
        likeNumTextField.setEditable(false);
        likeNumTextField.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        //---- label4 ----
        label4.setText("\u6240\u5c5e\u74dc\u5708\uff1a");
        label4.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        //---- belongTextField ----
        belongTextField.setEditable(false);
        belongTextField.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        //---- label5 ----
        label5.setText("\u5185       \u5bb9\uff1a");
        label5.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        //======== scrollPane2 ========
        {

            //---- contentTextArea ----
            contentTextArea.setEditable(false);
            contentTextArea.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
            scrollPane2.setViewportView(contentTextArea);
        }

        //---- deleteBtn ----
        deleteBtn.setText("\u5220\u9664\u8be5\u74dc");
        deleteBtn.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 16));
        deleteBtn.addActionListener(e -> deleteBtnActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 650, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                                .addGroup(contentPaneLayout.createParallelGroup()
                                                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createParallelGroup()
                                                                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                                                        .addGroup(contentPaneLayout.createParallelGroup()
                                                                                .addComponent(label1)
                                                                                .addComponent(label2))
                                                                        .addGap(18, 18, 18))
                                                                .addGroup(contentPaneLayout.createSequentialGroup()
                                                                        .addComponent(label4, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                                                        .addGap(23, 23, 23)))
                                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                                .addComponent(label5, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(23, 23, 23)))
                                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(belongTextField, GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                                                                        .addComponent(titleTextField, GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                                                                        .addComponent(timeTextField, GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE))
                                                                .addGap(38, 38, 38)
                                                                .addComponent(label3, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(likeNumTextField, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE)))
                                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                                .addComponent(deleteBtn)
                                                .addGap(261, 261, 261)))
                                .addContainerGap(38, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(label1, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                                        .addComponent(titleTextField, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(label2, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                        .addComponent(timeTextField, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label3, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                        .addComponent(likeNumTextField, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(label4, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                                        .addComponent(belongTextField, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(label5, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(deleteBtn)
                                .addContainerGap(19, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
}
