package com.news.newsservice.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CommentResponse {

    private Long id;

    private Long accountId;

    private Long senderUserId;

    private String content;

    private Integer repliesCounter;

    private Date createDate;

    private Boolean isDeleted;

    private Long bulletin;

    private Long parentComment;
}
