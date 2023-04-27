package com.wjh.www.po;

import com.wjh.www.annotation.Column;
import com.wjh.www.annotation.Table;

import java.util.Objects;

/**
 * 该实体类对应数据库中的incident表
 * @author 26913
 */
@Table(value = "incident")
public class Incident {
    /**
     * incident表的主键，不具有业务逻辑
     */
    @Column(value = "incident_id")
    private String incidentId;
    /**
     * 事件的标题
     */
    @Column(value = "incident_title")
    private String incidentTitle;
    /**
     * 事件的内容
     */
    @Column(value = "incident_content")
    private String incidentContent;
    /**
     * 事件的发布者
     */
    @Column(value = "publisher")
    private String publisher;
    /**
     * 事件的发布时间
     */
    @Column(value = "publisher_time")
    private String publishTime;
    /**
     * 事件的点赞数
     */
    @Column(value = "like_num")
    private Integer likeNum;
    /**
     * 事件的所属瓜圈
     */
    @Column(value = "belong_circle")
    private String belongCircle;

    public String getIncidentId() {
        return incidentId;
    }

    public void setIncidentId(String incidentId) {
        this.incidentId = incidentId;
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

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public Integer getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(Integer likeNum) {
        this.likeNum = likeNum;
    }

    public String getBelongCircle() {
        return belongCircle;
    }

    public void setBelongCircle(String belongCircle) {
        this.belongCircle = belongCircle;
    }

    @Override
    public String toString() {
        return "Incident{" +
                "incidentId='" + incidentId + '\'' +
                ", incidentTitle='" + incidentTitle + '\'' +
                ", incidentContent='" + incidentContent + '\'' +
                ", publisher='" + publisher + '\'' +
                ", publishTime='" + publishTime + '\'' +
                ", likeNum=" + likeNum +
                ", belongCircle='" + belongCircle + '\'' +
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
        Incident incident = (Incident) o;
        return Objects.equals(incidentId, incident.incidentId) && Objects.equals(incidentTitle, incident.incidentTitle) && Objects.equals(incidentContent, incident.incidentContent) && Objects.equals(publisher, incident.publisher) && Objects.equals(publishTime, incident.publishTime) && Objects.equals(likeNum, incident.likeNum) && Objects.equals(belongCircle, incident.belongCircle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(incidentId, incidentTitle, incidentContent, publisher, publishTime, likeNum, belongCircle);
    }
}
