package com.wjh.www.dao.impl;

import com.wjh.www.annotation.Table;
import com.wjh.www.dao.BaseDao;
import com.wjh.www.dao.ReportDao;
import com.wjh.www.po.Report;

import java.util.List;

/**
 * @author wjh
 */
public class ReportDaoImpl implements ReportDao {
    private final BaseDao baseDao = new BaseDaoImpl();
    private final String TABLE_NAME = Report.class.getAnnotation(Table.class).value();

    @Override
    public boolean insertReport(Report report) {
        return baseDao.insert(report);
    }

    @Override
    public List<Report> listReports(Report conditionReport) {
        String fields = "incident_title,incident_content,report_reason,belong_circle,reporter,incident_publisher";
        return (List<Report>) baseDao.select(conditionReport, Report.class, fields, TABLE_NAME);
    }

    @Override
    public boolean deleteReport(Report conditionReport) {
        return baseDao.delete(conditionReport);
    }

    @Override
    public boolean updateReportByReporter(Report report, String reporter) {
        return baseDao.update(report, Thread.currentThread().getStackTrace()[1].getMethodName(), reporter);
    }

    @Override
    public boolean updateReportByIncidentPublisher(Report report, String incidentPublisher) {
        return baseDao.update(report, Thread.currentThread().getStackTrace()[1].getMethodName(), incidentPublisher);
    }
}
