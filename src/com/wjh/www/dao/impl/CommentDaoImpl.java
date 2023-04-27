package com.wjh.www.dao.impl;

import com.wjh.www.annotation.Table;
import com.wjh.www.dao.BaseDao;
import com.wjh.www.dao.CommentDao;
import com.wjh.www.po.Comment;

import java.util.List;

/**
 * @author wjh
 */
public class CommentDaoImpl implements CommentDao {
    private final BaseDao baseDao = new BaseDaoImpl();
    private final String TABLE_NAME = Comment.class.getAnnotation(Table.class).value();

    @Override
    public boolean insertComment(Comment comment) {
        return baseDao.insert(comment);
    }

    @Override
    public List<Comment> listComments(Comment conditionComment) {
        String fields = "comment_publisher,comment_content";
        return (List<Comment>) baseDao.select(conditionComment, Comment.class, fields, TABLE_NAME);
    }

    @Override
    public boolean deleteComment(Comment conditionComment) {
        return baseDao.delete(conditionComment);
    }

    @Override
    public boolean updateCommentByCommentPublisher(Comment comment, String commentPublisher) {
        return baseDao.update(comment, Thread.currentThread().getStackTrace()[1].getMethodName(), commentPublisher);
    }
}
