package com.wjh.www.dao;

import com.wjh.www.po.Comment;

import java.util.List;

/**
 * @author wjh
 */
public interface CommentDao {
    /**
     * 向comment表插入一条数据
     *
     * @param comment 被封装成comment对象的一条数据
     * @return 返回布尔值（true表示操作成功）
     */
    boolean insertComment(Comment comment);


    /**
     * 获取comment表中的多条数据
     *
     * @param conditionComment 被封装成comment对象的where条件
     * @return 返回布尔值（true表示操作成功）
     */
    List<Comment> listComments(Comment conditionComment);

    /**
     * 删除comment表中的一条数据
     *
     * @param conditionComment 被封装成comment对象的where条件
     * @return 返回布尔值（true表示操作成功）
     */
    boolean deleteComment(Comment conditionComment);

    /**
     * 更新comment表中的一条数据
     *
     * @param comment          被封装成comment对象的一条新数据
     * @param commentPublisher where条件，通过commentPublisher来跟新
     * @return 返回布尔值（true表示操作成功）
     */
    boolean updateCommentByCommentPublisher(Comment comment, String commentPublisher);
}
