package com.wjh.www.po;

import com.wjh.www.annotation.Column;
import com.wjh.www.annotation.Table;

import java.lang.annotation.Target;
import java.util.Objects;

/**
 * 该实体类对应数据库中的collection表
 * @author 26913
 */
@Table(value = "collection")
public class Collection {
    /**
     * collection表的主键，不具有业务逻辑
     */
   @Column(value = "collection_id")
    private String collectionId;
    /**
     * 被收藏的瓜的标题
     */
    @Column(value = "incident_title")
    private String incidentTitle;
    /**
     * 瓜的收藏者
     */
    @Column(value = "collector")
    private String collector;

    public String getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(String collectionId) {
        this.collectionId = collectionId;
    }

    public String getIncidentTitle() {
        return incidentTitle;
    }

    public void setIncidentTitle(String incidentTitle) {
        this.incidentTitle = incidentTitle;
    }

    public String getCollector() {
        return collector;
    }

    public void setCollector(String collector) {
        this.collector = collector;
    }

    @Override
    public String toString() {
        return "Collection{" +
                "collectionId='" + collectionId + '\'' +
                ", incidentTitle='" + incidentTitle + '\'' +
                ", collector='" + collector + '\'' +
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
        Collection that = (Collection) o;
        return Objects.equals(collectionId, that.collectionId) && Objects.equals(incidentTitle, that.incidentTitle) && Objects.equals(collector, that.collector);
    }

    @Override
    public int hashCode() {
        return Objects.hash(collectionId, incidentTitle, collector);
    }
}
