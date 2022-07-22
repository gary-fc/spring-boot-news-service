package com.news.newsservice.controller;

import com.news.newsservice.common.util.BulletinsResponseBuilder;
import com.news.newsservice.domain.Bulletin;
import com.news.newsservice.domain.Comment;
import com.news.newsservice.responses.BulletinResponse;
import com.news.newsservice.services.Bulletin.BulletinService;
import com.news.newsservice.services.Comment.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/searches/")
@CrossOrigin(origins = "*")
public class SearchesController {

    @Autowired
    CommentService commentService;

    @Autowired
    BulletinService bulletinService;

    @GetMapping("comments")
    public List<Comment> getAllComment() {
        return commentService.getListAllComment();
    }

    @GetMapping("comments/{bulletinId}")
    public List<Comment> getCommentsByAccountId(@PathVariable(name = "bulletinId") Long bulletinId) {
        return commentService.getCommentsByBulletinId(bulletinId);
    }

    @GetMapping("/bulletins")
    public List<BulletinResponse> getListAllBulletin() {
        return BulletinsResponseBuilder.getInstance(bulletinService.getListAllBulletin()).getBulletinsList();
    }

    @GetMapping("/bulletins/page")
    public List<BulletinResponse> getListPaginatedBulletins(@RequestParam int pageNo, @RequestParam int pageSize) {
        return BulletinsResponseBuilder.getInstance(bulletinService.getListPaginatedBulletins(pageNo, pageSize)).getBulletinsList();
    }

    @GetMapping("/bulletins/byAccountId")
    public List<Bulletin> getBulletinsByAccountId(@PathVariable(name = "id") Long id) {
        return bulletinService.getBulletinsByAccountId(id);
    }
}
