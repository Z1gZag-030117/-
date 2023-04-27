/*
 * Created by JFormDesigner on Fri Apr 02 00:22:32 CST 2021
 */

package com.wjh.www.view.AdminView;

import java.awt.event.*;

import com.wjh.www.po.Incident;
import com.wjh.www.service.impl.IncidentServiceImpl;
import com.wjh.www.service.IncidentService;
import com.wjh.www.util.StringUtils;

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
public class AdminInquireIncidentView extends JDialog {
    /**
     * 管理的瓜圈
     */
    private String adminCircle;

    /**
     * 该JDialog窗体的父窗体
     */
    private JFrame jFrame;

    /**
     * 装Incident对象的集合,用于把数据展示到表格中
     */
    private List<Incident> list = new ArrayList<>();


    private final IncidentService incidentService = new IncidentServiceImpl();
    private Incident incident = new Incident();

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTable table;
    private JLabel label1;
    private JLabel label2;
    private JTextField titleTextField;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JTextField publisherTextField;
    private JTextField timeTextField;
    private JScrollPane scrollPane2;
    private JTextArea contentTextArea;
    private JButton deleteBtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public AdminInquireIncidentView(JFrame jFrame, String adminCircle) {
        super(jFrame, true);
        this.adminCircle = adminCircle;
        System.out.println(adminCircle);
        this.jFrame = jFrame;
        initComponents();
        this.fillTable();
        this.setVisible(true);
    }

    /**
     * 给表格添加点击事件监听
     *
     * @param e
     */
    private void tableMousePressed(MouseEvent e) {
        //返回值row表示选择的列的索引
        int row = table.getSelectedRow();
        incident = list.get(row);
        titleTextField.setText(incident.getIncidentTitle());
        publisherTextField.setText(incident.getPublisher());
        timeTextField.setText(incident.getPublishTime());
        contentTextArea.setText(incident.getIncidentContent());
    }

    /**
     * 删除用户发布的瓜的事件监听
     *
     * @param e
     */
    private void deleteBtnActionPerformed(ActionEvent e) {
        /*
        进行简单的前台校验
         */
        if (StringUtils.isEmpty(incident.getIncidentTitle())) {
            JOptionPane.showMessageDialog(null, "请先要删除选择瓜！");
            return;
        }
        int result = JOptionPane.showConfirmDialog(null, "你是否确定要删除该用户的该瓜？");
        if (result == 0) {
            /*
            删除当前表格执行的瓜
             */
            if (incidentService.removePublishIncident(incident)) {
                JOptionPane.showMessageDialog(null, "删除成功！");
                dispose();
                new AdminInquireIncidentView(jFrame, adminCircle);
            } else {
                JOptionPane.showMessageDialog(null, "我们的数据库出现了问题，删除失败，正在维护中~！");
            }
        }
    }

    /**
     * 填充表格数据
     */
    private void fillTable() {
        /*
        把where条件封装成一个对象
         */
        Incident conditionIncident = new Incident();
        conditionIncident.setBelongCircle(adminCircle);
        /*
        查询指定的数据，并且展示到表格中
         */
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
                vector.add(incident.getPublishTime());
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
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        publisherTextField = new JTextField();
        timeTextField = new JTextField();
        scrollPane2 = new JScrollPane();
        contentTextArea = new JTextArea();
        deleteBtn = new JButton();

        //======== this ========
        setTitle("\u4e8b\u4ef6\u7ba1\u7406");
        Container contentPane = getContentPane();

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
                            "\u7f16\u53f7", "\u74dc\u540d", "\u53d1\u5e03\u8005", "\u53d1\u5e03\u65f6\u95f4"
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

        //---- label1 ----
        label1.setText("\u7528\u6237\u53d1\u5e03\u7684\u74dc");
        label1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        //---- label2 ----
        label2.setText("\u74dc        \u540d\uff1a ");
        label2.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        //---- titleTextField ----
        titleTextField.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));
        titleTextField.setEditable(false);

        //---- label3 ----
        label3.setText("\u53d1  \u5e03  \u8005\uff1a");
        label3.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        //---- label4 ----
        label4.setText("\u53d1\u5e03\u65f6\u95f4\uff1a");
        label4.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        //---- label5 ----
        label5.setText("\u5185       \u5bb9\uff1a");
        label5.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        //---- publisherTextField ----
        publisherTextField.setEditable(false);
        publisherTextField.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        //---- timeTextField ----
        timeTextField.setEditable(false);
        timeTextField.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        //======== scrollPane2 ========
        {

            //---- contentTextArea ----
            contentTextArea.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
            contentTextArea.setEditable(false);
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
                                .addGap(34, 34, 34)
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 646, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(label5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(label3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(label4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(label2, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(publisherTextField, GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                                                        .addComponent(timeTextField, GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                                                        .addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                                                        .addComponent(titleTextField, GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE))))
                                .addContainerGap(38, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                .addContainerGap(311, Short.MAX_VALUE)
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
                                                .addGap(275, 275, 275))
                                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                                .addComponent(deleteBtn, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
                                                .addGap(289, 289, 289))))
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(titleTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(label3, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(publisherTextField, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(label4, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(timeTextField, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label5, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(deleteBtn)
                                .addGap(33, 33, 33))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
}
