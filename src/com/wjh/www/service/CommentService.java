package com.wjh.www.service;

import com.wjh.www.po.Comment;

import java.util.List;

/**
 * @author wjh
 */
public interface CommentService {
    /**
     * 添加一条评论
     *
     * @param comment 被封装成comment对象的评论
     * @return 返回布尔值（true表示操作成功）
     */
    boolean saveComment(Comment comment);

    /**
     * 查询约束条件下的评论
     *
     * @param conditionComment 约束条件，被封装成一个comment对象
     * @return List<Comment>，封装着评论的list集合
     */
    List<Comment> findListComment(Comment conditionComment);

    /**
     * 根据约束条件删除评论
     *
     * @param conditionComment 约束条件，被封装成一个comment对象
     * @return 返回List<Comment>集合，封装了comment对象
     */
    boolean removeComment(Comment conditionComment);

    /**
     * 修改约束条件下的评论
     *
     * @param comment          新的数据，被封装成一个comment对象
     * @param commentPublisher 约束条件，根据commentPublisher来修改
     * @return 返回布尔值（true表示操作成功）
     */
    boolean modifyCommentByCommentPublisher(Comment comment, String commentPublisher);
}
