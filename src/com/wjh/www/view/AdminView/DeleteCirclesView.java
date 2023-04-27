/*
 * Created by JFormDesigner on Tue Mar 30 23:14:23 CST 2021
 */

package com.wjh.www.view.AdminView;

import java.awt.event.*;

import com.wjh.www.po.Admin;
import com.wjh.www.po.Circles;
import com.wjh.www.service.impl.AdminServiceImpl;
import com.wjh.www.service.impl.CirclesServiceImpl;
import com.wjh.www.service.AdminService;
import com.wjh.www.service.CirclesService;
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
public class DeleteCirclesView extends JDialog {
    /**
     * 被删除的圈子的名称
     */
    private String circleName;
    /**
     * 该窗体的父窗体
     */
    private JFrame jFrame;

    private final CirclesService circlesService = new CirclesServiceImpl();
    private final AdminService adminService = new AdminServiceImpl();

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTable table;
    private JLabel label1;
    private JButton deleteBtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public DeleteCirclesView(JFrame jFrame) {
        super(jFrame, true);
        this.jFrame = jFrame;
        initComponents();
        this.fillTable();
        this.setVisible(true);
    }

    /**
     * 删除瓜圈的事件监听
     *
     * @param e
     */
    private void deleteBtnActionPerformed(ActionEvent e) {
        /*
        进行简单的前提校验
         */
        if (StringUtils.isEmpty(circleName)) {
            JOptionPane.showMessageDialog(null, "请先选择要删除的瓜圈");
            return;
        }
        int result = JOptionPane.showConfirmDialog(null, "您是否确认删除该瓜圈？");
        if (result == 0) {
            CirclesService circlesService = new CirclesServiceImpl();
            /*
            将被删除的瓜圈封装成一个对象
             */
            Circles conditionCircle = new Circles();
            conditionCircle.setCircleName(circleName);

            /*
            将被删除的瓜圈的管理封装成一个admin对象，用于封装where条件
             */
            Admin conditionAdmin = new Admin();
            conditionAdmin.setAdminCircle(circleName);
            /*
            删除圈子和管理员都成功了
             */
            if (circlesService.removeCircle(conditionCircle) && adminService.removeAdmin(conditionAdmin)) {
                JOptionPane.showMessageDialog(null, "删除成功！");
                dispose();
                new DeleteCirclesView(jFrame);
            } else {
                JOptionPane.showMessageDialog(null, "我们的数据库出现了问题，正在维护，删除失败了~！");
                dispose();
            }
        }
    }

    /**
     * 表格鼠标点击的事件监听
     *
     * @param e
     */
    private void tableMousePressed(MouseEvent e) {
        //返回值row表示选择的列的索引
        int row = table.getSelectedRow();
        //获取当前选择的瓜圈的名字
        circleName = (String) table.getValueAt(row, 0);
    }

    /**
     * 填充表格
     */
    private void fillTable() {
        /*
        查询所有瓜圈，调用service层方法
         */
        List<Circles> list = circlesService.findListCircles();
        if (list != null) {
            DefaultTableModel dtm = (DefaultTableModel) table.getModel();
            dtm.setRowCount(0);
            for (Circles circles : list) {
                Vector<String> vector = new Vector<String>();
                vector.add(circles.getCircleName());
                vector.add(circles.getCreateTime());
                vector.add(circles.getCircleAdmin());
                vector.add(circles.getCircleDescription());
                System.out.println(circles.getCircleAdmin());
                dtm.addRow(vector);
            }
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        table = new JTable();
        label1 = new JLabel();
        deleteBtn = new JButton();

        //======== this ========
        setTitle("\u5220\u9664\u74dc\u5708\u754c\u9762");
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
                            {null, null, null, null},
                    },
                    new String[]{
                            "\u74dc\u5708\u540d\u79f0", "\u521b\u5efa\u65f6\u95f4", "\u74dc\u5708\u7ba1\u7406\u5458", "\u74dc\u5708\u63cf\u8ff0"
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
        label1.setText("\u5220\u9664\u74dc\u5708");
        label1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 26));

        //---- deleteBtn ----
        deleteBtn.setText("\u5220\u9664");
        deleteBtn.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 16));
        deleteBtn.addActionListener(e -> deleteBtnActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                .addContainerGap(32, Short.MAX_VALUE)
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 578, GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGap(271, 271, 271)
                                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGap(284, 284, 284)
                                                .addComponent(deleteBtn)))
                                .addContainerGap(250, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                                .addComponent(deleteBtn)
                                .addGap(27, 27, 27))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
}
