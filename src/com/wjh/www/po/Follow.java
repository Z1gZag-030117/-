package com.wjh.www.po;

import com.wjh.www.annotation.Column;
import com.wjh.www.annotation.Table;

import java.util.Objects;

/**
 * 该实体类对应数据库中的follow表
 * @author 26913
 */
@Table(value = "follow")
public class Follow {
    /**
     * follow表的主键，不具有业务逻辑
     */
    @Column(value = "follow_id")
    private String likeId;
    /**
     * 被点赞的事件的标题
     */
    @Column(value = "incident_title")
    private String incidentTitle;
    /**
     * 点赞者
     */
    @Column(value = "follower")
    private String follower;

    public String getLikeId() {
        return likeId;
    }

    public void setLikeId(String likeId) {
        this.likeId = likeId;
    }

    public String getIncidentTitle() {
        return incidentTitle;
    }

    public void setIncidentTitle(String incidentTitle) {
        this.incidentTitle = incidentTitle;
    }

    public String getFollower() {
        return follower;
    }

    public void setFollower(String follower) {
        this.follower = follower;
    }

    @Override
    public String toString() {
        return "Follow{" +
                "likeId='" + likeId + '\'' +
                ", incidentTitle='" + incidentTitle + '\'' +
                ", follower='" + follower + '\'' +
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
        Follow follow = (Follow) o;
        return Objects.equals(likeId, follow.likeId) && Objects.equals(incidentTitle, follow.incidentTitle) && Objects.equals(follower, follow.follower);
    }

    @Override
    public int hashCode() {
        return Objects.hash(likeId, incidentTitle, follower);
    }
}
