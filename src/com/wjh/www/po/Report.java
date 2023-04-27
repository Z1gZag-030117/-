package com.wjh.www.po;

import com.wjh.www.annotation.Column;
import com.wjh.www.annotation.Table;

import java.util.Objects;

/**
 * 该实体类对应数据库中的report表
 * @author 26913
 */
@Table(value = "report")
public class Report {
    /**
     * report表的主键，不具有业务逻辑
     */
    @Column(value = "report_id")
    private String reportId;
    /**
     * 被举报的事件的标题
     */
    @Column(value = "incident_title")
    private String incidentTitle;
    /**
     * 被举报的事件的内容
     */
    @Column(value = "incident_content")
    private String incidentContent;
    /**
     * 被举报的原因
     */
    @Column(value = "report_reason")
    private String reportReason;
    /**
     * 被举报的事件所属的瓜圈
     */
    @Column(value = "belong_circle")
    private String belongCircle;
    /**
     * 举报者
     */
    @Column(value = "reporter")
    private String reporter;
    /**
     * 被举报的事件的发布者
     */
    @Column(value = "incident_publisher")
    private String incidentPublisher;

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public String getIncidentTitle() {
        return incidentTitle;
    }

    public void setIncidentTitle(String incidentTitle) {
        this.incidentTitle = incidentTitle;
    }

    public String getIncidentContent() {
        return incidentContent;
    }

    public void setIncidentContent(String incidentContent) {
        this.incidentContent = incidentContent;
    }

    public String getReportReason() {
        return reportReason;
    }

    public void setReportReason(String reportReason) {
        this.reportReason = reportReason;
    }

    public String getBelongCircle() {
        return belongCircle;
    }

    public void setBelongCircle(String belongCircle) {
        this.belongCircle = belongCircle;
    }

    public String getReporter() {
        return reporter;
    }

    public void setReporter(String reporter) {
        this.reporter = reporter;
    }

    public String getIncidentPublisher() {
        return incidentPublisher;
    }

    public void setIncidentPublisher(String incidentPublisher) {
        this.incidentPublisher = incidentPublisher;
    }

    @Override
    public String toString() {
        return "Report{" +
                "reportId='" + reportId + '\'' +
                ", incidentTitle='" + incidentTitle + '\'' +
                ", incidentContent='" + incidentContent + '\'' +
                ", reportReason='" + reportReason + '\'' +
                ", belongCircle='" + belongCircle + '\'' +
                ", reporter='" + reporter + '\'' +
                ", incidentPublisher='" + incidentPublisher + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Report report = (Report) o;
        return Objects.equals(reportId, report.reportId) && Objects.equals(incidentTitle, report.incidentTitle) && Objects.equals(incidentContent, report.incidentContent) && Objects.equals(reportReason, report.reportReason) && Objects.equals(belongCircle, report.belongCircle) && Objects.equals(reporter, report.reporter) && Objects.equals(incidentPublisher, report.incidentPublisher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reportId, incidentTitle, incidentContent, reportReason, belongCircle, reporter, incidentPublisher);
    }
}
