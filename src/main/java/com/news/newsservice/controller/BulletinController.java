package com.news.newsservice.controller;

import com.news.newsservice.common.utils.BulletinResponseBuilder;
import com.news.newsservice.domain.Bulletin;
import com.news.newsservice.dto.BulletinDTO;
import com.news.newsservice.responses.BulletinResponse;
import com.news.newsservice.services.Bulletin.BulletinService;
import com.news.newsservice.wrapper.BulletinWrapper;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api-news/bulletins")
public class BulletinController {

    private final BulletinService bulletinService;

    public BulletinController(BulletinService bulletinService) {
        this.bulletinService = bulletinService;
    }

    @PostMapping()
    public BulletinResponse createBulletin(@RequestHeader @RequestBody BulletinDTO bulletinDTO) throws RuntimeException {
        BulletinWrapper bulletinWrapper = bulletinService.createBulletin(bulletinDTO);
        return BulletinResponseBuilder.getInstance(bulletinWrapper).buildBulletinResponse();
    }

    @GetMapping("/{id}")
    public Bulletin readBulletinById(@PathVariable(name = "id") Long id) {
        return bulletinService.getBulletinById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteBulletinById(@PathVariable(name = "id") Long id) {
        bulletinService.deleteBulletinById(id);
    }
}
