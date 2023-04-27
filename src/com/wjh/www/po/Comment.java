package com.wjh.www.po;

import com.wjh.www.annotation.Column;
import com.wjh.www.annotation.Table;

import java.util.Objects;

/**
 * 该实体类对应数据库中的comment表
 * @author 26913
 */
@Table(value = "comment")
public class Comment {
    /**
     * comment表的主键，不具有业务逻辑
     */
    @Column(value = "comment_id")
    private String commentId;
    /**
     * 评论的发布者
     */
    @Column(value = "comment_publisher")
    private String commentPublisher;
    /**
     * 评论的内容
     */
    @Column(value = "comment_content")
    private String commentContent;
    /**
     * 被评论的事件的标题
     */
    @Column(value = "incident_title")
    private String incidentTitle;

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public String getCommentPublisher() {
        return commentPublisher;
    }

    public void setCommentPublisher(String commentPublisher) {
        this.commentPublisher = commentPublisher;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public String getIncidentTitle() {
        return incidentTitle;
    }

    public void setIncidentTitle(String incidentTitle) {
        this.incidentTitle = incidentTitle;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId='" + commentId + '\'' +
                ", commentPublisher='" + commentPublisher + '\'' +
                ", commentContent='" + commentContent + '\'' +
                ", incidentTitle='" + incidentTitle + '\'' +
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
        Comment comment = (Comment) o;
        return Objects.equals(commentId, comment.commentId) && Objects.equals(commentPublisher, comment.commentPublisher) && Objects.equals(commentContent, comment.commentContent) && Objects.equals(incidentTitle, comment.incidentTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commentId, commentPublisher, commentContent, incidentTitle);
    }
}
