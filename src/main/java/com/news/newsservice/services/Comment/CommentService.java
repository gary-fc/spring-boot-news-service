package com.news.newsservice.services.Comment;

import com.news.newsservice.domain.Comment;
import com.news.newsservice.dto.CommentDTO;
import com.news.newsservice.wrapper.CommentWrapper;

import java.util.List;

public interface CommentService {
    CommentWrapper createComment(Long bulletinId, CommentDTO commentDTO);

    List<CommentWrapper> getListAllComment();

    Comment getCommentById(Long id);

    List<Comment> getCommentsByAccountId(Long id);

    List<CommentWrapper> getCommentsByBulletinId(Long id);

    void deleteCommentById(Long id);
}
