package com.news.newsservice.services.Bulletin.BulletinServiceImpl;

import com.news.newsservice.domain.Bulletin;
import com.news.newsservice.dto.BulletinDTO;
import com.news.newsservice.repository.BulletinRepository;
import com.news.newsservice.responses.User;
import com.news.newsservice.services.Auth.AuthService;
import com.news.newsservice.services.Bulletin.BulletinService;
import com.news.newsservice.wrapper.BulletinWrapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service("BulletinServiceImpl")
public class BulletinServiceImpl implements BulletinService {


    private final BulletinRepository bulletinRepository;
    private final AuthService authService;

    private Page<Bulletin> pagedResult;

    public BulletinServiceImpl(BulletinRepository bulletinRepository, AuthService authService) {
        this.bulletinRepository = bulletinRepository;
        this.authService = authService;
    }


    @Override
    public BulletinWrapper createBulletin(BulletinDTO bulletinDTO) {
        Bulletin bulletin = bulletinRepository.save(composeBulletin(bulletinDTO));
        User user = authService.userByAccountId(bulletin.getAccountId());
        return composeBulletinWrapper(bulletin, user);
    }

    @Override
    public List<BulletinWrapper> getListAllBulletin() {
        List<Bulletin> bulletins = bulletinRepository.findAll();
        List<BulletinWrapper> bulletinWrappers = new LinkedList<>();
        bulletinWrappers = bulletins.stream().map(bulletin -> composeBulletinWrapper(bulletin,
                authService.userByAccountId(bulletin.getAccountId()))).collect(Collectors.toList());
        return bulletinWrappers;
    }

    @Override
    public List<BulletinWrapper> getListPaginatedBulletins(int pageNo, int pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<Bulletin> bulletins = bulletinRepository.findAll(paging);
        Page<BulletinWrapper> pagedResult = new PageImpl<>(bulletins.stream().map(bulletin -> composeBulletinWrapper(bulletin,
                authService.userByAccountId(bulletin.getAccountId()))).collect(Collectors.toList()));
        if (pagedResult.hasContent()) {
            return pagedResult.toList();
        } else {
            return new ArrayList<BulletinWrapper>();
        }
    }

    @Override
    public Bulletin getBulletinById(Long id) {
        return bulletinRepository.getById(id);
    }

    @Override
    public List<Bulletin> getBulletinsByAccountId(Long id) {
        return bulletinRepository.findAllByAccountId(id);
    }

    @Override
    public void deleteBulletinById(Long id) {
        bulletinRepository.deleteById(id);
    }

    private Bulletin composeBulletin(BulletinDTO bulletinDTO) {
        Bulletin bulletin = new Bulletin();
        bulletin.setAccountId(bulletinDTO.getAccountId());
        bulletin.setBody(bulletinDTO.getBody());
        bulletin.setFileUrl(bulletinDTO.getFileUrl());
        bulletin.setSenderUserId(bulletinDTO.getSenderUserId());
        bulletin.setCommentsCounter(0);
        return bulletin;
    }

    private BulletinWrapper composeBulletinWrapper(Bulletin bulletin, User user) {
        BulletinWrapper bulletinWrapper = new BulletinWrapper();
        bulletinWrapper.setId(bulletin.getId());
        bulletinWrapper.setBody(bulletin.getBody());
        bulletinWrapper.setCreatedDate(bulletin.getCreatedAt());
        bulletinWrapper.setCommentsCounter(bulletin.getCommentsCounter());
        bulletinWrapper.setFileUrl(bulletin.getFileUrl());
        bulletinWrapper.setUser(user);
        return bulletinWrapper;
    }

}
