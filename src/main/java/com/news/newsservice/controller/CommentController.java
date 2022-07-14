package com.news.newsservice.controller;

import com.news.newsservice.domain.Comment;
import com.news.newsservice.dto.CommentDTO;
import com.news.newsservice.services.Comment.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments/")
public class CommentController {

    @Autowired
    CommentService commentService;

    @PostMapping("/createComment")
    public Comment createComment(@RequestBody CommentDTO commentDTO) {
        return commentService.createComment(commentDTO);
    }

    @DeleteMapping("/byId/{id}")
    public void deleteCommentById(@PathVariable(name = "id") Long id) {
        commentService.deleteCommentById(id);
    }

    @GetMapping
    public List<Comment> getListAllComment() {
        return commentService.getListAllComment();
    }

    @GetMapping("/listByAccountId/{id}")
    public List<Comment> getCommentsByAccountId(@PathVariable(name = "id") Long id) {
        return commentService.getCommentsByAccountId(id);
    }

    @GetMapping("/byId/{id}")
    public Comment getCommentById(@PathVariable(name = "id") Long id) {
        return commentService.getCommentById(id);
    }
}
