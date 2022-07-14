package com.news.newsservice.services.Bulletin;

import com.news.newsservice.domain.Bulletin;
import com.news.newsservice.dto.BulletinDTO;

import java.util.List;

public interface BulletinService {

    Bulletin createBulletin(BulletinDTO bulletinDTO);

    List<Bulletin> getListAllBulletin();

    List<Bulletin> getListPaginatedBulletins(int pageNo, int pageSize);

    Bulletin getBulletinById(Long id);

    List<Bulletin> getBulletinsByAccountId(Long id);

    void deleteBulletinById(Long id);
}
