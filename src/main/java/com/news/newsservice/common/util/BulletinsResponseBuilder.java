package com.news.newsservice.common.util;

import com.news.newsservice.domain.Bulletin;
import com.news.newsservice.responses.BulletinResponse;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class BulletinsResponseBuilder {
    private List<BulletinResponse> bulletinResponseList;

    private BulletinsResponseBuilder() {
        bulletinResponseList = new LinkedList<>();
    }

    public static BulletinsResponseBuilder getInstance(List<Bulletin> bulletinList) {
        return new BulletinsResponseBuilder().setBulletinsList(bulletinList);
    }

    private BulletinsResponseBuilder setBulletinsList(List<Bulletin> bulletinList) {
        bulletinResponseList = bulletinList.stream().map(bulletin -> BulletinResponseBuilder.getInstance(bulletin).buildBulletinResponse()).collect(Collectors.toList());
        return this;
    }

    public List<BulletinResponse> getBulletinsList() {
        return bulletinResponseList;
    }
}
