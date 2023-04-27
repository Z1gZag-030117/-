package com.wjh.www.po;

import com.wjh.www.annotation.Column;
import com.wjh.www.annotation.Table;

import java.util.Objects;

/**
 * 该实体类对于数据库中的circles表
 * @author 26913
 */
@Table(value = "circles")
public class Circles {
    /**
     * circles表的主键
     */
    @Column(value = "circle_id")
    private String circleId;
    /**
     * 瓜圈名称
     */
    @Column(value = "circle_name")
    private String circleName;
    /**
     * 瓜圈创建时间
     */
    @Column(value = "create_time")
    private String createTime;
    /**
     * 瓜圈的管理员
     */
    @Column(value = "circle_admin")
    private String circleAdmin;
    /**
     * 瓜圈的简单描述
     */
    @Column(value = "circle_description")
    private String circleDescription;

    public String getCircleId() {
        return circleId;
    }

    public void setCircleId(String circleId) {
        this.circleId = circleId;
    }

    public String getCircleName() {
        return circleName;
    }

    public void setCircleName(String circleName) {
        this.circleName = circleName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCircleAdmin() {
        return circleAdmin;
    }

    public void setCircleAdmin(String circleAdmin) {
        this.circleAdmin = circleAdmin;
    }

    public String getCircleDescription() {
        return circleDescription;
    }

    public void setCircleDescription(String circleDescription) {
        this.circleDescription = circleDescription;
    }

    @Override
    public String toString() {
        return "Circles{" +
                "circleId='" + circleId + '\'' +
                ", circleName='" + circleName + '\'' +
                ", createTime='" + createTime + '\'' +
                ", circleAdmin='" + circleAdmin + '\'' +
                ", circleDescription='" + circleDescription + '\'' +
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
        Circles circles = (Circles) o;
        return Objects.equals(circleId, circles.circleId) && Objects.equals(circleName, circles.circleName) && Objects.equals(createTime, circles.createTime) && Objects.equals(circleAdmin, circles.circleAdmin) && Objects.equals(circleDescription, circles.circleDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(circleId, circleName, createTime, circleAdmin, circleDescription);
    }
}


