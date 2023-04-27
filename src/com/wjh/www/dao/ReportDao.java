package com.wjh.www.dao;

import com.wjh.www.po.Report;

import java.util.List;

public interface ReportDao {
    /**
     * 向report表中插入一条数据
     *
     * @param report 被封装成report对象的一条数据
     * @return 返回布尔值（true表示操作成功）
     */
    boolean insertReport(Report report);

    /**
     * 查询report的多条数据
     *
     * @param conditionReport 被封装成report对象的where条件
     * @return 返回布尔值（true表示操作成功）
     */
    List<Report> listReports(Report conditionReport);

    /**
     * 删除report表中的一条数据
     *
     * @param conditionReport 被封装成report对象的where条件
     * @return 返回布尔值（true表示操作成功）
     */
    boolean deleteReport(Report conditionReport);

    /**
     * 跟新report表中的一条数据
     *
     * @param report   被封装成report对象的一条新数据
     * @param reporter where条件，通过reporter来更新数据
     * @return 返回布尔值（true表示操作成功）
     */
    boolean updateReportByReporter(Report report, String reporter);

    /**
     * 更新report表中的一条数据
     *
     * @param report            被封装成report对象的新数据
     * @param incidentPublisher where条件，通过incidentPublisher来更新数据
     * @return 返回布尔值（true表示操作成功）
     */
    boolean updateReportByIncidentPublisher(Report report, String incidentPublisher);
}
