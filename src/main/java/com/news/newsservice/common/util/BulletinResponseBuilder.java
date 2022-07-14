package com.news.newsservice.common.util;

import com.news.newsservice.domain.Bulletin;
import com.news.newsservice.responses.BulletinResponse;

public class BulletinResponseBuilder {
    private BulletinResponse bulletinResponse;

    private BulletinResponseBuilder() {
        this.bulletinResponse = new BulletinResponse();
    }

    public static BulletinResponseBuilder getInstance(Bulletin bulletin) {
        return new BulletinResponseBuilder().setBulletin(bulletin);
    }

    private BulletinResponseBuilder setBulletin(Bulletin bulletin) {
        bulletinResponse.setId(bulletin.getId());
        bulletinResponse.setAccountId(bulletin.getAccountId());
        bulletinResponse.setBody(bulletin.getBody());
        bulletinResponse.setSenderUserId(bulletin.getSenderUserId());
        bulletinResponse.setCommentsCounter(bulletin.getCommentsCounter());
        bulletinResponse.setCreatedDate(bulletin.getCreatedDate());
        return this;
    }


    public BulletinResponse buildBulletinResponse() {
        return bulletinResponse;
    }
}
