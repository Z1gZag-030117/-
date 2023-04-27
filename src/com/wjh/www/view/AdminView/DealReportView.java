/*
 * Created by JFormDesigner on Sat Apr 03 21:32:15 CST 2021
 */

package com.wjh.www.view.AdminView;

import java.awt.event.*;

import com.wjh.www.po.Incident;
import com.wjh.www.po.Report;
import com.wjh.www.service.impl.IncidentServiceImpl;
import com.wjh.www.service.impl.ReportServiceImpl;
import com.wjh.www.service.IncidentService;
import com.wjh.www.service.ReportService;

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
public class DealReportView extends JDialog {
    /**
     * 被举报的事件所属的瓜圈
     */
    private String circleName;
    /**
     * 该窗体的父窗体
     */
    private JFrame jFrame;
    /**
     * 装有Report对象的集合,用于展示到表格
     */
    private List<Report> list = new ArrayList<Report>();
    /**
     * 被举报的事件的标题
     */
    private String incidentTitle;
    /**
     * 举报者
     */
    private String reporter;
    /**
     * 被举报的原因
     */
    private String reportReason;
    /**
     * 被举报事件的发布者
     */
    private String incidentPublisher;

    private final ReportService reportService = new ReportServiceImpl();
    private final IncidentService incidentService = new IncidentServiceImpl();

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JScrollPane scrollPane1;
    private JTable table;
    private JLabel label2;
    private JTextField titleTextField;
    private JLabel label3;
    private JTextField reporterTextField;
    private JLabel label4;
    private JScrollPane scrollPane2;
    private JTextArea contentTextArea;
    private JLabel label5;
    private JScrollPane scrollPane3;
    private JTextArea reasonTextArea;
    private JButton agreeBtn;
    private JButton disagreeBtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public DealReportView(JFrame jFrame, String circleName) {
        super(jFrame, true);
        this.circleName = circleName;
        this.jFrame = jFrame;
        initComponents();
        this.fillTable();
        this.setVisible(true);
    }

    /**
     * 表格鼠标点击事件
     *
     * @param e
     */
    private void tableMousePressed(MouseEvent e) {
        int row = table.getSelectedRow();//返回值row表示选择的列的索引
        Report report = list.get(row);
        titleTextField.setText(report.getIncidentTitle());
        reporterTextField.setText(report.getReporter());
        contentTextArea.setText(report.getIncidentContent());
        reasonTextArea.setText(report.getReportReason());

        /*
        获取被举报的事件的标题、发布者以及该举报的举报人、举报原因
         */
        incidentTitle = report.getIncidentTitle();
        incidentPublisher = report.getIncidentPublisher();
        reporter = report.getReporter();
        reportReason = report.getReportReason();
    }

    /**
     * 举报不成立的事件监听
     *
     * @param e
     */
    private void disagreeBtnActionPerformed(ActionEvent e) {
        int result = JOptionPane.showConfirmDialog(null, "确认执行该处理结果？");
        if (result == 0) {
            /*
            把被删除的举报事件的where条件封装成一个对象
             */
            Report conditionReport = new Report();
            conditionReport.setIncidentTitle(incidentTitle);
            conditionReport.setReporter(reporter);
            conditionReport.setReportReason(reportReason);
            /*
            调用service层的方法，返回true表示只删除举报事件成功
             */
            if (reportService.removeReport(conditionReport)) {
                JOptionPane.showMessageDialog(null, "处理成功！");
                dispose();
                new DealReportView(jFrame, circleName);
            } else {
                JOptionPane.showMessageDialog(null, "我们的数据库出现了问题，正在维护中，处理失败了~！");
                return;
            }

        }
    }

    /**
     * 举报成立的事件监听
     *
     * @param e
     */
    private void agreeBtnActionPerformed(ActionEvent e) {
        int result = JOptionPane.showConfirmDialog(null, "确认执行该处理结果？");
        if (result == 0) {
            /*
            把被删除的举报事件封装成一个report对象
             */
            Report conditionReport = new Report();
            conditionReport.setIncidentTitle(incidentTitle);
            conditionReport.setReporter(reporter);
            conditionReport.setReportReason(reportReason);

            /*
            删除指定的事件，相关信息封装为一个incident对象
             */
            Incident conditionIncident = new Incident();
            conditionIncident.setIncidentTitle(incidentTitle);
            conditionIncident.setPublisher(incidentPublisher);
            if (reportService.removeReport(conditionReport) && incidentService.removePublishIncident(conditionIncident)) {
                JOptionPane.showMessageDialog(null, "处理成功！");
                dispose();
                new DealReportView(jFrame, circleName);
            } else {
                JOptionPane.showMessageDialog(null, "我们的数据库蹦了，处理失败啦，我们正在维护中~");
                return;
            }
        }
    }

    /**
     * 填充表格
     */
    private void fillTable() {
        /*
        把查询条件封装成一个对象
         */
        Report condotionReport = new Report();
        condotionReport.setBelongCircle(circleName);
        /*
        获取查询数据并展示到表格
         */
        list = reportService.findListReports(condotionReport);
        if (list != null) {
            int i = 0;
            DefaultTableModel dtm = (DefaultTableModel) table.getModel();
            dtm.setRowCount(0);
            for (Report report : list) {
                i++;
                Vector<String> vector = new Vector<String>();
                vector.add(String.valueOf(i));
                vector.add(report.getIncidentTitle());
                vector.add(report.getReporter());
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
        titleTextField = new JTextField();
        label3 = new JLabel();
        reporterTextField = new JTextField();
        label4 = new JLabel();
        scrollPane2 = new JScrollPane();
        contentTextArea = new JTextArea();
        label5 = new JLabel();
        scrollPane3 = new JScrollPane();
        reasonTextArea = new JTextArea();
        agreeBtn = new JButton();
        disagreeBtn = new JButton();

        //======== this ========
        setTitle("\u5904\u7406\u4e3e\u62a5\u754c\u9762");
        Container contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u5904\u7406\u7528\u6237\u4e3e\u62a5\u7684\u74dc");
        label1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 28));

        //======== scrollPane1 ========
        {

            //---- table ----
            table.setModel(new DefaultTableModel(
                    new Object[][]{
                            {null, null, null},
                            {null, null, null},
                            {null, null, null},
                            {null, null, null},
                    },
                    new String[]{
                            "\u7f16\u53f7", "\u74dc\u7684\u6807\u9898", "\u4e3e\u62a5\u4eba"
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

        //---- label2 ----
        label2.setText("\u74dc\u7684\u6807\u9898\uff1a");
        label2.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        //---- titleTextField ----
        titleTextField.setEditable(false);
        titleTextField.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        //---- label3 ----
        label3.setText("\u4e3e\u62a5\u4eba\uff1a");
        label3.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        //---- reporterTextField ----
        reporterTextField.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));
        reporterTextField.setEditable(false);

        //---- label4 ----
        label4.setText("\u74dc\u7684\u5185\u5bb9\uff1a");
        label4.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        //======== scrollPane2 ========
        {

            //---- contentTextArea ----
            contentTextArea.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
            contentTextArea.setEditable(false);
            scrollPane2.setViewportView(contentTextArea);
        }

        //---- label5 ----
        label5.setText("\u4e3e\u62a5\u539f\u56e0\uff1a");
        label5.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));

        //======== scrollPane3 ========
        {

            //---- reasonTextArea ----
            reasonTextArea.setEditable(false);
            reasonTextArea.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
            scrollPane3.setViewportView(reasonTextArea);
        }

        //---- agreeBtn ----
        agreeBtn.setText("\u5220\u9664\u88ab\u4e3e\u62a5\u7684\u8be5\u74dc");
        agreeBtn.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 16));
        agreeBtn.addActionListener(e -> agreeBtnActionPerformed(e));

        //---- disagreeBtn ----
        disagreeBtn.setText("\u8be5\u74dc\u4e3e\u62a5\u4e0d\u6210\u7acb");
        disagreeBtn.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 16));
        disagreeBtn.addActionListener(e -> disagreeBtnActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGap(231, 231, 231)
                                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 257, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGap(38, 38, 38)
                                                .addGroup(contentPaneLayout.createParallelGroup()
                                                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 605, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                                        .addComponent(label5, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(label4, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(label2, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                .addGroup(contentPaneLayout.createParallelGroup()
                                                                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                                                                .addComponent(titleTextField)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(label3)
                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(reporterTextField, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))
                                                                        .addComponent(scrollPane2)
                                                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                                                .addGap(67, 67, 67)
                                                                                .addComponent(agreeBtn)
                                                                                .addGap(26, 26, 26)
                                                                                .addComponent(disagreeBtn)
                                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                                        .addComponent(scrollPane3, GroupLayout.Alignment.TRAILING))))))
                                .addGap(45, 45, 45))
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(label2)
                                        .addComponent(label3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(titleTextField)
                                        .addComponent(reporterTextField))
                                .addGap(18, 18, 18)
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(label4)
                                        .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(label5, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(scrollPane3, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(agreeBtn)
                                        .addComponent(disagreeBtn))
                                .addGap(14, 14, 14))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
}
