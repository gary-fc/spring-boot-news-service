package com.news.newsservice.controller;

import com.news.newsservice.common.util.BulletinResponseBuilder;
import com.news.newsservice.common.util.BulletinsResponseBuilder;
import com.news.newsservice.domain.Bulletin;
import com.news.newsservice.dto.BulletinDTO;
import com.news.newsservice.exceptions.ResourceNotFoundException;
import com.news.newsservice.responses.BulletinResponse;
import com.news.newsservice.services.Auth.AuthService;
import com.news.newsservice.services.Bulletin.BulletinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bulletins/")
@CrossOrigin(origins = "*")
public class BulletinController {

    @Autowired
    private BulletinService bulletinService;

    @Autowired
    private AuthService authService;

    @PostMapping("/createBulletin")
    public BulletinResponse createBulletin(@RequestBody BulletinDTO bulletinDTO) throws RuntimeException {
        if (authService.userExistsByAccountId(bulletinDTO.getAccountId())) {
            Bulletin bulletin = bulletinService.createBulletin(bulletinDTO);
            return BulletinResponseBuilder.getInstance(bulletin).buildBulletinResponse();
        }
        throw new ResourceNotFoundException("Account", "accountId", bulletinDTO.getAccountId());
    }

    @DeleteMapping("/byId/{id}")
    public void deleteBulletinById(@PathVariable(name = "id") Long id) {
        bulletinService.deleteBulletinById(id);
    }


    @GetMapping
    public List<BulletinResponse> getListAllBulletin() {
        return BulletinsResponseBuilder.getInstance(bulletinService.getListAllBulletin()).getBulletinsList();
    }

    @GetMapping("/paginated")
    public List<BulletinResponse> getListPaginatedBulletins(@RequestParam int pageNo, @RequestParam int pageSize) {
        return BulletinsResponseBuilder.getInstance(bulletinService.getListPaginatedBulletins(pageNo, pageSize)).getBulletinsList();
    }

    @GetMapping("/listByAccountId/{id}")
    public List<Bulletin> getBulletinsByAccountId(@PathVariable(name = "id") Long id) {
        return bulletinService.getBulletinsByAccountId(id);
    }

    @GetMapping("/byId/{id}")
    public Bulletin getBulletinById(@PathVariable(name = "id") Long id) {
        return bulletinService.getBulletinById(id);
    }

}
