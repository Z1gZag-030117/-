/*
 * Created by JFormDesigner on Wed Mar 31 23:38:40 CST 2021
 */

package com.wjh.www.view.UserView;

import java.awt.event.*;

import com.wjh.www.po.Collection;
import com.wjh.www.po.Incident;
import com.wjh.www.service.impl.CollectionServiceImpl;
import com.wjh.www.service.impl.IncidentServiceImpl;
import com.wjh.www.service.CollectionService;
import com.wjh.www.service.IncidentService;

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
public class InquireCollectionView extends JDialog {
    /**
     * 用户的昵称
     */
    private String userName;
    /**
     * 事件的标题
     */
    private String incidentTitle;
    /**
     * 当前窗体的父窗体
     */
    private JFrame jFrame;
    /*
    当前选中的事件
     */
    private Incident incident = null;
    /*
    展示到表格的事件
     */
    private List<Incident> list = null;

    private final IncidentService incidentService = new IncidentServiceImpl();
    private final CollectionService collectionService = new CollectionServiceImpl();

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JScrollPane scrollPane1;
    private JTable table;
    private JLabel label6;
    private JTextField titleTextField;
    private JLabel label7;
    private JTextField publisherTextField;
    private JLabel label8;
    private JTextField publishTimeTextField;
    private JLabel label9;
    private JTextField belongCircleTextField;
    private JLabel label10;
    private JScrollPane scrollPane2;
    private JTextArea contentTextArea;
    private JButton deleteCollectionBtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public InquireCollectionView(JFrame jFrame, String uerName) {
        super(jFrame, true);
        this.userName = uerName;
        this.jFrame = jFrame;
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
        int row = table.getSelectedRow();//返回值row表示选择的列的索引
        incident = list.get(row);
        titleTextField.setText(incident.getIncidentTitle());
        incidentTitle = incident.getIncidentTitle();
        publisherTextField.setText(incident.getPublisher());
        publishTimeTextField.setText(incident.getPublishTime());
        belongCircleTextField.setText(incident.getBelongCircle());
        contentTextArea.setText(incident.getIncidentContent());
    }

    /**
     * 给删除按钮添加事件监听
     *
     * @param e
     */
    private void deleteCollectionBtnActionPerformed(ActionEvent e) {
        int result = JOptionPane.showConfirmDialog(null, "您是否确认取消收藏该瓜？");
        if (result == 0) {
            /*
            把被删除的瓜封装成一个对象
             */
            Collection conditionCollection = new Collection();
            conditionCollection.setIncidentTitle(incidentTitle);
            conditionCollection.setCollector(userName);
            if (collectionService.removeCollectionIncident(conditionCollection)) {
                JOptionPane.showMessageDialog(null, "取消收藏成功！");
                dispose();
                new InquireCollectionView(jFrame, userName);

            } else {
                JOptionPane.showMessageDialog(null, "取消收藏失败！");
            }
        }
    }

    /**
     * 初始化表格信息
     */
    private void fillTable() {
        /*
        把查询条件封装成一个incident对象
         */
        Collection conditionCollection = new Collection();
        conditionCollection.setCollector(userName);
        /*
        调用servic获取需要的数据
         */
        list = incidentService.findListCollectionIncidents(conditionCollection);
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
        label1 = new JLabel();
        scrollPane1 = new JScrollPane();
        table = new JTable();
        label6 = new JLabel();
        titleTextField = new JTextField();
        label7 = new JLabel();
        publisherTextField = new JTextField();
        label8 = new JLabel();
        publishTimeTextField = new JTextField();
        label9 = new JLabel();
        belongCircleTextField = new JTextField();
        label10 = new JLabel();
        scrollPane2 = new JScrollPane();
        contentTextArea = new JTextArea();
        deleteCollectionBtn = new JButton();

        //======== this ========
        setTitle("\u6536\u85cf\u7684\u74dc");
        Container contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u621182\u5e74\u6536\u85cf\u7684\u9648\u5e74\u8001\u74dc");
        label1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 26));

        //======== scrollPane1 ========
        {

            //---- table ----
            table.setModel(new DefaultTableModel(
                    new Object[][]{
                            {null, null, null, ""},
                            {null, null, null, null},
                            {null, null, null, null},
                            {null, null, null, null},
                            {null, null, null, null},
                    },
                    new String[]{
                            "\u7f16\u53f7", "\u74dc\u540d", "\u53d1\u5e03\u8005", "\u6240\u5c5e\u74dc\u5708"
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

        //---- label6 ----
        label6.setText("\u74dc   \u540d\uff1a");
        label6.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        //---- titleTextField ----
        titleTextField.setEditable(false);
        titleTextField.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        //---- label7 ----
        label7.setText("\u53d1\u5e03\u8005\uff1a");
        label7.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        //---- publisherTextField ----
        publisherTextField.setEditable(false);
        publisherTextField.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        //---- label8 ----
        label8.setText("\u53d1\u5e03\u65f6\u95f4\uff1a");
        label8.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        //---- publishTimeTextField ----
        publishTimeTextField.setEditable(false);
        publishTimeTextField.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        //---- label9 ----
        label9.setText("\u6240\u5c5e\u74dc\u5708\uff1a");
        label9.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        //---- belongCircleTextField ----
        belongCircleTextField.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));
        belongCircleTextField.setEditable(false);

        //---- label10 ----
        label10.setText("\u5185   \u5bb9\uff1a");
        label10.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        //======== scrollPane2 ========
        {

            //---- contentTextArea ----
            contentTextArea.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
            contentTextArea.setEditable(false);
            scrollPane2.setViewportView(contentTextArea);
        }

        //---- deleteCollectionBtn ----
        deleteCollectionBtn.setText("\u53d6\u6d88\u6536\u85cf");
        deleteCollectionBtn.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 18));
        deleteCollectionBtn.addActionListener(e -> deleteCollectionBtnActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGap(227, 227, 227)
                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 289, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                                .addContainerGap(108, Short.MAX_VALUE)
                                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 528, GroupLayout.PREFERRED_SIZE)
                                                .addGap(16, 16, 16))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGap(42, 42, 42)
                                                .addGroup(contentPaneLayout.createParallelGroup()
                                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                                .addComponent(label9, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(belongCircleTextField, GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                                                                .addGap(313, 313, 313))
                                                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                                                .addGap(0, 497, Short.MAX_VALUE)
                                                                                .addComponent(deleteCollectionBtn))
                                                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                                                .addComponent(label10, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE))
                                                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                                                .addGroup(contentPaneLayout.createParallelGroup()
                                                                                        .addComponent(label7)
                                                                                        .addComponent(label6, GroupLayout.DEFAULT_SIZE, 1, Short.MAX_VALUE))
                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addGroup(contentPaneLayout.createParallelGroup()
                                                                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                                                                .addComponent(publisherTextField, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(18, 18, 18)
                                                                                                .addComponent(label8)
                                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(publishTimeTextField, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(0, 4, Short.MAX_VALUE))
                                                                                        .addComponent(titleTextField, GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE))))
                                                                .addGap(9, 9, 9)))))
                                .addGap(91, 91, 91))
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label6, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(titleTextField, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(label7, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(label8, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(publishTimeTextField, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addComponent(publisherTextField, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                                .addGap(4, 4, 4)))
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(label9, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(belongCircleTextField, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label10, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(deleteCollectionBtn)
                                .addGap(16, 16, 16))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
}
