package com.news.newsservice.wrapper;

import com.news.newsservice.responses.User;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CommentWrapper {
    private Long id;

    private Long senderUserId;

    private String content;

    private Integer repliesCounter;

    private Date createDate;

    private Boolean isDeleted;

    private Long bulletinId;

    private Long parentComment;

    private User user;

}
