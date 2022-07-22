package com.news.newsservice.services.Bulletin.BulletinServiceImpl;

import com.news.newsservice.domain.Bulletin;
import com.news.newsservice.dto.BulletinDTO;
import com.news.newsservice.repository.BulletinRepository;
import com.news.newsservice.services.Bulletin.BulletinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BulletinServiceImpl implements BulletinService {
    @Autowired
    private BulletinRepository bulletinRepository;
    private Page<Bulletin> pagedResult;


    @Override
    public Bulletin createBulletin(BulletinDTO bulletinDTO) {
        Bulletin bulletin = this.composeBulletin(bulletinDTO);
        return bulletinRepository.save(bulletin);
    }

    @Override
    public List<Bulletin> getListAllBulletin() {
        return bulletinRepository.findAll();
    }

    @Override
    public List<Bulletin> getListPaginatedBulletins(int pageNo, int pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<Bulletin> pagedResult = bulletinRepository.findAll(paging);

        if (pagedResult.hasContent()) {
            return pagedResult.toList();
        } else {
            return new ArrayList<Bulletin>();
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
        bulletin.setCreatedDate(new Date());
        bulletin.setIsDeleted(false);
        return bulletin;
    }

}
