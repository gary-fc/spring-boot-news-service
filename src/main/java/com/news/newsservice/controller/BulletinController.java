package com.news.newsservice.controller;

import com.news.newsservice.common.util.BulletinResponseBuilder;
import com.news.newsservice.domain.Bulletin;
import com.news.newsservice.domain.Comment;
import com.news.newsservice.dto.BulletinDTO;
import com.news.newsservice.dto.CommentDTO;
import com.news.newsservice.exceptions.ResourceNotFoundException;
import com.news.newsservice.responses.BulletinResponse;
import com.news.newsservice.services.Auth.AuthService;
import com.news.newsservice.services.Bulletin.BulletinService;
import com.news.newsservice.services.Comment.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bulletins")
@CrossOrigin(origins = "*")
public class BulletinController {

    @Autowired
    private BulletinService bulletinService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private AuthService authService;

    @PostMapping()
    public BulletinResponse createBulletin(@RequestBody BulletinDTO bulletinDTO) throws RuntimeException {
        if (authService.userExistsByAccountId(bulletinDTO.getAccountId())) {
            Bulletin bulletin = bulletinService.createBulletin(bulletinDTO);
            return BulletinResponseBuilder.getInstance(bulletin).buildBulletinResponse();
        }
        throw new ResourceNotFoundException("Account", "accountId", bulletinDTO.getAccountId());
    }

    @GetMapping("/{id}")
    public Bulletin readBulletinById(@PathVariable(name = "id") Long id) {
        return bulletinService.getBulletinById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteBulletinById(@PathVariable(name = "id") Long id) {
        bulletinService.deleteBulletinById(id);
    }

    @PostMapping("{bulletinId}/comments")
    public Comment createComment(@PathVariable(name = "bulletinId") Long bulletinId, @RequestBody CommentDTO commentDTO) throws RuntimeException {
        System.out.println(bulletinId);
        return commentService.createComment(bulletinId, commentDTO);
    }

    @GetMapping("{bulletinId}/comments/{id}")
    public Comment readCommentById(@PathVariable(name = "bulletinId") Long bulletinId, @PathVariable(name = "id") Long id) {
        return commentService.getCommentById(id);
    }

    @DeleteMapping("{bulletinId}/comments/{commentId}")
    public Comment deleteComment(@PathVariable(name = "bulletinId") Long bulletinId, @PathVariable(name = "commentId") Long commentId, @RequestBody CommentDTO commentDTO) throws RuntimeException {
        return commentService.createComment(bulletinId, commentDTO);
    }


}
