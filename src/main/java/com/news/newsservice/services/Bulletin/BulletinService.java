package com.news.newsservice.services.Bulletin;

import com.news.newsservice.domain.Bulletin;
import com.news.newsservice.dto.BulletinDTO;
import com.news.newsservice.wrapper.BulletinWrapper;

import java.util.List;

public interface BulletinService {

    BulletinWrapper createBulletin(BulletinDTO bulletinDTO);

    List<BulletinWrapper> getListAllBulletin();

    List<BulletinWrapper> getListPaginatedBulletins(int pageNo, int pageSize);

    Bulletin getBulletinById(Long id);

    List<Bulletin> getBulletinsByAccountId(Long id);

    void deleteBulletinById(Long id);
}
