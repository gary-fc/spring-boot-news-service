package com.news.newsservice.services.Comment;

import com.news.newsservice.domain.Comment;
import com.news.newsservice.dto.CommentDTO;

import java.util.List;

public interface CommentService {
    Comment createComment(CommentDTO commentDTO);

    List<Comment> getListAllComment();

    Comment getCommentById(Long id);

    List<Comment> getCommentsByAccountId(Long id);

    void deleteCommentById(Long id);
}
