package com.news.newsservice.wrapper;

import com.news.newsservice.responses.User;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BulletinWrapper {
    private Long id;
    private String body;
    private Date createdDate;
    private Integer commentsCounter;
    private String fileUrl;
    private User user;
}
