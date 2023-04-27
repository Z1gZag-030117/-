package com.wjh.www.service.impl;

import com.wjh.www.dao.impl.CommentDaoImpl;
import com.wjh.www.dao.CommentDao;
import com.wjh.www.po.Comment;
import com.wjh.www.service.CommentService;

import java.util.List;

/**
 * @author wjh
 */
public class CommentServiceImpl implements CommentService {
    private final CommentDao commentDao = new CommentDaoImpl();

    @Override
    public boolean saveComment(Comment comment) {
        return commentDao.insertComment(comment);
    }

    @Override
    public List<Comment> findListComment(Comment conditionComment) {
        return commentDao.listComments(conditionComment);
    }

    @Override
    public boolean removeComment(Comment conditionComment) {
        return commentDao.deleteComment(conditionComment);
    }

    @Override
    public boolean modifyCommentByCommentPublisher(Comment comment, String commentPublisher) {
        return commentDao.updateCommentByCommentPublisher(comment, commentPublisher);
    }
}
