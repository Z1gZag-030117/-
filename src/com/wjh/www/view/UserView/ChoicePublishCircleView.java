/*
 * Created by JFormDesigner on Tue Mar 30 18:19:44 CST 2021
 */

package com.wjh.www.view.UserView;

import java.awt.event.*;

import com.wjh.www.po.Circles;
import com.wjh.www.service.impl.CirclesServiceImpl;
import com.wjh.www.service.CirclesService;

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
public class ChoicePublishCircleView extends JDialog {
    /**
     * 用户的昵称
     */
    private String userName;

    /**
     * 选择的瓜圈的名字
     */
    private String circleName;

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTable table;
    private JTextField circleTextField;
    private JLabel label1;
    private JButton EnterBtn;
    private JLabel label2;
    private JLabel label3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public ChoicePublishCircleView(JFrame jFrame, String title, String userName) {
        super(jFrame, title, true);
        this.userName = userName;
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
        int row = table.getSelectedRow();
        circleTextField.setText((String) table.getValueAt(row, 0));
        this.circleName = (String) table.getValueAt(row, 0);
    }

    /**
     * 给进入按钮添加事件监听
     *
     * @param e
     */
    private void EnterBtnActionPerformed(ActionEvent e) {
        if (circleName == null) {
            JOptionPane.showMessageDialog(null, "请先选择瓜圈！");
            return;
        } else {
            dispose();
            new PublishIncidentView(this, userName, circleName);
        }
    }


    /**
     * 初始化表格信息
     */
    private void fillTable() {
        /*
        调用service获取要展示的数据
         */
        CirclesService circlesService = new CirclesServiceImpl();
        List<Circles> list = circlesService.findListCircles();
        if (list != null) {
            DefaultTableModel dtm = (DefaultTableModel) table.getModel();
            dtm.setRowCount(0);
            for (Circles circles : list) {
                Vector<String> vector = new Vector<String>();
                vector.add(circles.getCircleName());
                vector.add(circles.getCreateTime());
                vector.add(circles.getCircleDescription());
                dtm.addRow(vector);
            }
        }
    }

    /*
    swing代码
     */
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        table = new JTable();
        circleTextField = new JTextField();
        label1 = new JLabel();
        EnterBtn = new JButton();
        label2 = new JLabel();
        label3 = new JLabel();

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
                            {null, null, null},
                            {null, null, null},
                    },
                    new String[]{
                            "\u74dc\u5708\u540d\u79f0", "\u521b\u5efa\u65f6\u95f4", "\u74dc\u5708\u63cf\u8ff0"
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
            table.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
            table.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    tableMousePressed(e);
                }
            });
            scrollPane1.setViewportView(table);
        }

        //---- circleTextField ----
        circleTextField.setEditable(false);
        circleTextField.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        //---- label1 ----
        label1.setText("\u5df2\u9009\u74dc\u5708\uff1a");
        label1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        //---- EnterBtn ----
        EnterBtn.setText("\u786e\u8ba4\u8fdb\u5165");
        EnterBtn.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));
        EnterBtn.addActionListener(e -> EnterBtnActionPerformed(e));

        //---- label2 ----
        label2.setText("\u9009\u62e9\u74dc\u5708");
        label2.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 26));

        //---- label3 ----
        label3.setText("\u6e29\u99a8\u63d0\u793a\uff1a\u53d1\u8868\u7684\u5185\u5bb9\u9700\u543b\u5408\u6240\u9009\u74dc\u5708");
        label3.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGap(299, 299, 299)
                                                .addComponent(EnterBtn))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGap(223, 223, 223)
                                                .addComponent(label1)
                                                .addGap(18, 18, 18)
                                                .addComponent(circleTextField, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGap(186, 186, 186)
                                                .addComponent(label3, GroupLayout.PREFERRED_SIZE, 348, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(199, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                .addGap(0, 115, Short.MAX_VALUE)
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 520, GroupLayout.PREFERRED_SIZE)
                                                .addGap(98, 98, 98))
                                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
                                                .addGap(268, 268, 268))))
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(circleTextField, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(label3, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                                .addComponent(EnterBtn)
                                .addGap(17, 17, 17))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
}
