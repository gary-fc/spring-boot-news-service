package com.news.newsservice.common.utils;

import com.news.newsservice.responses.BulletinResponse;
import com.news.newsservice.wrapper.BulletinWrapper;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class BulletinsResponseBuilder {
    private List<BulletinResponse> bulletinResponseList;

    private BulletinsResponseBuilder() {
        bulletinResponseList = new LinkedList<>();
    }

    public static BulletinsResponseBuilder getInstance(List<BulletinWrapper> bulletinWrappers) {
        return new BulletinsResponseBuilder().setBulletinsList(bulletinWrappers);
    }

    public List<BulletinResponse> getBulletinsList() {
        return bulletinResponseList;
    }

    private BulletinsResponseBuilder setBulletinsList(List<BulletinWrapper> bulletinWrappers) {
        bulletinResponseList = bulletinWrappers.stream().map(bulletinWrapper -> BulletinResponseBuilder.getInstance(bulletinWrapper).buildBulletinResponse()).collect(Collectors.toList());
        return this;
    }
}
