package com.news.newsservice.controller;

import com.news.newsservice.common.utils.CommentResponseBuilder;
import com.news.newsservice.domain.Comment;
import com.news.newsservice.dto.CommentDTO;
import com.news.newsservice.responses.CommentResponse;
import com.news.newsservice.services.Comment.CommentService;
import com.news.newsservice.wrapper.CommentWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api-news/comments")

public class CommentController {
    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/{bulletinId}")
    public CommentResponse createComment(@PathVariable(name = "bulletinId") Long bulletinId, @RequestBody CommentDTO commentDTO) throws RuntimeException {
        CommentWrapper commentWrapper = commentService.createComment(bulletinId, commentDTO);
        return CommentResponseBuilder.getInstance(commentWrapper).buildCommentResponse();
    }

    @GetMapping("/{id}")
    public Comment readCommentById(@PathVariable(name = "bulletinId") Long bulletinId, @PathVariable(name = "id") Long id) {
        return commentService.getCommentById(id);
    }

    @DeleteMapping("/{commentId}")
    public void deleteComment(@PathVariable(name = "commentId") Long commentId) throws RuntimeException {
        commentService.deleteCommentById(commentId);
    }

}
