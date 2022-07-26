package com.news.newsservice.controller;

import com.news.newsservice.common.utils.BulletinsResponseBuilder;
import com.news.newsservice.common.utils.CommentsResponseBuilder;
import com.news.newsservice.domain.Bulletin;
import com.news.newsservice.domain.Comment;
import com.news.newsservice.responses.BulletinResponse;
import com.news.newsservice.responses.CommentResponse;
import com.news.newsservice.services.Bulletin.BulletinService;
import com.news.newsservice.services.Comment.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-news/searches/")
public class SearchesController {

    private final CommentService commentService;
    private final BulletinService bulletinService;

    @Autowired
    public SearchesController(CommentService commentService, @Qualifier("BulletinServiceImpl") BulletinService bulletinService) {
        this.commentService = commentService;
        this.bulletinService = bulletinService;
    }

    @GetMapping("comments")
    public List<CommentResponse> getAllComment() {
        return CommentsResponseBuilder.getInstance(commentService.getListAllComment()).getCommentsList();
    }

    @GetMapping("comments/{bulletinId}")
    public List<CommentResponse> getCommentsByAccountId(@PathVariable(name = "bulletinId") Long bulletinId) {
        return CommentsResponseBuilder.getInstance(commentService.getCommentsByBulletinId(bulletinId)).getCommentsList();
    }

    @GetMapping("/bulletins")
    public List<BulletinResponse> getListAllBulletin() {
        return BulletinsResponseBuilder.getInstance(bulletinService.getListAllBulletin()).getBulletinsList();
    }

    @GetMapping("/bulletins/page")
    public List<BulletinResponse> getListPaginatedBulletins(@RequestParam Integer pageNo, @RequestParam Integer pageSize) {
        return BulletinsResponseBuilder.getInstance(bulletinService.getListPaginatedBulletins(pageNo, pageSize)).getBulletinsList();
    }

    @GetMapping("/bulletins/byAccountId")
    public List<Bulletin> getBulletinsByAccountId(@PathVariable(name = "id") Long id) {
        return bulletinService.getBulletinsByAccountId(id);
    }
}
