package com.wjh.www.service.impl;

import com.wjh.www.dao.impl.ReportDaoImpl;
import com.wjh.www.dao.ReportDao;
import com.wjh.www.po.Report;
import com.wjh.www.service.ReportService;

import java.util.List;

/**
 * @author wjh
 */
public class ReportServiceImpl implements ReportService {
    private final ReportDao reportDao = new ReportDaoImpl();

    @Override
    public boolean saveReport(Report report) {
        return reportDao.insertReport(report);
    }

    @Override
    public List<Report> findListReports(Report conditionReport) {
        return reportDao.listReports(conditionReport);
    }

    @Override
    public boolean removeReport(Report conditionReport) {
        return reportDao.deleteReport(conditionReport);
    }

    @Override
    public boolean modifyReportByReporter(Report report, String reporter) {
        return reportDao.updateReportByReporter(report, reporter);
    }

    @Override
    public boolean modifyReportByIncidentPublisher(Report report, String incidentTitle) {
        return reportDao.updateReportByIncidentPublisher(report, incidentTitle);
    }
}
