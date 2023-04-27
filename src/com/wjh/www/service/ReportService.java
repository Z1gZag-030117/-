package com.wjh.www.service;

import com.wjh.www.po.Report;

import java.util.List;

/**
 * @author wjh
 */
public interface ReportService {
    /**
     * 添加一个举报事件
     *
     * @param report 被封装成report对象的举报数据
     * @return 返回布尔值（true表示操作成功）
     */
    boolean saveReport(Report report);

    /**
     * 根据约束条件查询事件
     *
     * @param conditionReport 约束条件，被封装成了report对象
     * @return 返回封装好被查到的数据的List<Report>集合
     */
    List<Report> findListReports(Report conditionReport);

    /**
     * 删除一条举报事件
     *
     * @param conditionReport 约束条件，被封装成了report对象
     * @return 返回布尔值（true表示操作成功）
     */
    boolean removeReport(Report conditionReport);

    /**
     * 根据约束条件修改举报事件
     *
     * @param report   新的数据，被封装成了report对象
     * @param reporter 约束条件，根据reporter来修改
     * @return 返回布尔值（true表示操作成功）
     */
    boolean modifyReportByReporter(Report report, String reporter);

    /**
     * 根据约束条件修改举报事件
     *
     * @param report        新的数据，被封装成了report对象
     * @param incidentTitle 约束条件，根据incidentTitle来修改
     * @return 返回布尔值（true表示操作成功）
     */
    boolean modifyReportByIncidentPublisher(Report report, String incidentTitle);
}
