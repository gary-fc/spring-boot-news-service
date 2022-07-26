package com.news.newsservice.common.utils;

import com.news.newsservice.responses.CommentResponse;
import com.news.newsservice.wrapper.CommentWrapper;

public class CommentResponseBuilder {
    private CommentResponse commentResponse;

    private CommentResponseBuilder() {
        this.commentResponse = new CommentResponse();
    }

    public static CommentResponseBuilder getInstance(CommentWrapper commentWrapper) {
        return new CommentResponseBuilder().setUser(commentWrapper);
    }

    private CommentResponseBuilder setUser(CommentWrapper commentWrapper) {
        commentResponse.setId(commentWrapper.getId());
        commentResponse.setSenderUserId(commentWrapper.getSenderUserId());
        commentResponse.setIsDeleted(commentWrapper.getIsDeleted());
        commentResponse.setContent(commentWrapper.getContent());
        commentResponse.setCreateDate(commentWrapper.getCreateDate());
        commentResponse.setUser(commentWrapper.getUser());
        commentResponse.setParentComment(commentWrapper.getParentComment());
        commentResponse.setBulletinId(commentWrapper.getBulletinId());
        return this;
    }

    public CommentResponse buildCommentResponse() {
        return commentResponse;
    }
}
