/*
 * Created by JFormDesigner on Wed Mar 31 17:07:09 CST 2021
 */

package com.wjh.www.view.UserView;

import com.wjh.www.po.Circles;
import com.wjh.www.service.impl.CirclesServiceImpl;
import com.wjh.www.service.CirclesService;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.Vector;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.*;

/**
 * @author wjh
 */
@SuppressWarnings("all")
public class ChoiceLookCircleView extends JDialog {
    /**
     * 用户的昵称
     */
    private String userName;

    /**
     * 选择的瓜圈的名字
     */
    private String circleName;

    private final CirclesService circlesService = new CirclesServiceImpl();

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTable table;
    private JLabel label1;
    private JTextField choiceTextField;
    private JButton enterBtn;
    private JLabel label2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public ChoiceLookCircleView(JFrame jFrame, String title, String userName) {
        super(jFrame, title, true);
        this.userName = userName;
        initComponents();
        this.fillTable();
        this.setVisible(true);
    }

    /**
     * 给进入按钮添加事件监听
     *
     * @param e
     */
    private void enterBtnActionPerformed(ActionEvent e) {
        if (circleName == null) {
            JOptionPane.showMessageDialog(null, "请先选择瓜圈！");
            return;
        } else {
            dispose();
            new InquireIncidentView(this, userName, circleName);
        }
    }

    /**
     * 给表格添加点击事件监听
     *
     * @param e
     */
    private void tableMousePressed(MouseEvent e) {
        //返回值row表示选择的列的索引
        int row = table.getSelectedRow();
        //使usernameJTfile的内容显示第row行第0列的
        choiceTextField.setText((String) table.getValueAt(row, 0));
        this.circleName = (String) table.getValueAt(row, 0);
    }

    /**
     * 初始化表格信息
     */
    private void fillTable() {
        /*
        调用service获取数据
         */
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
    swing布局
     */
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        table = new JTable();
        label1 = new JLabel();
        choiceTextField = new JTextField();
        enterBtn = new JButton();
        label2 = new JLabel();

        //======== this ========
        setTitle("\u9009\u62e9\u74dc\u5708");
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
            table.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    tableMousePressed(e);
                }
            });
            scrollPane1.setViewportView(table);
        }

        //---- label1 ----
        label1.setText("\u5df2\u9009\u74dc\u5708\uff1a");
        label1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        //---- choiceTextField ----
        choiceTextField.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));
        choiceTextField.setEditable(false);

        //---- enterBtn ----
        enterBtn.setText("\u8fdb\u5708\u770b\u770b");
        enterBtn.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));
        enterBtn.addActionListener(e -> enterBtnActionPerformed(e));

        //---- label2 ----
        label2.setText("\u9009\u62e9\u60f3\u770b\u7684\u74dc\u5708\u5427\uff01");
        label2.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 24));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGap(210, 210, 210)
                                                .addComponent(label1)
                                                .addGap(18, 18, 18)
                                                .addComponent(choiceTextField, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGap(89, 89, 89)
                                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 545, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGap(259, 259, 259)
                                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGap(294, 294, 294)
                                                .addComponent(enterBtn, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(109, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(choiceTextField, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                                .addComponent(enterBtn, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
}
