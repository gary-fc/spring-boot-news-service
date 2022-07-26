package com.news.newsservice.common.utils;

import com.news.newsservice.responses.BulletinResponse;
import com.news.newsservice.wrapper.BulletinWrapper;

public class BulletinResponseBuilder {
    private BulletinResponse bulletinResponse;

    private BulletinResponseBuilder() {
        this.bulletinResponse = new BulletinResponse();
    }

    public static BulletinResponseBuilder getInstance(BulletinWrapper bulletinWrapper) {
        return new BulletinResponseBuilder().setBulletin(bulletinWrapper);
    }

    private BulletinResponseBuilder setBulletin(BulletinWrapper bulletinWrapper) {
        bulletinResponse.setBulletinId(bulletinWrapper.getId());
        bulletinResponse.setBody(bulletinWrapper.getBody());
        bulletinResponse.setCommentsCounter(bulletinWrapper.getCommentsCounter());
        bulletinResponse.setFileUrl(bulletinWrapper.getFileUrl());
        bulletinResponse.setCreatedDate(bulletinWrapper.getCreatedDate());
        bulletinResponse.setUserResponse(UserResponseBuilder.getInstance(bulletinWrapper.getUser()).buildUserResponse());
        return this;
    }


    public BulletinResponse buildBulletinResponse() {
        return bulletinResponse;
    }
}
