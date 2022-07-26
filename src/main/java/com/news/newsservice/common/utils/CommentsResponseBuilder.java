package com.news.newsservice.common.utils;

import com.news.newsservice.responses.CommentResponse;
import com.news.newsservice.wrapper.CommentWrapper;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class CommentsResponseBuilder {
    private List<CommentResponse> commentResponseList;

    private CommentsResponseBuilder() {
        commentResponseList = new LinkedList<>();
    }

    public static CommentsResponseBuilder getInstance(List<CommentWrapper> commentWrappers) {
        return new CommentsResponseBuilder().setBulletinsList(commentWrappers);
    }

    public List<CommentResponse> getCommentsList() {
        return commentResponseList;
    }

    private CommentsResponseBuilder setBulletinsList(List<CommentWrapper> bulletinWrappers) {
        commentResponseList = bulletinWrappers.stream().map(commentWrapper -> CommentResponseBuilder.getInstance(commentWrapper).buildCommentResponse()).collect(Collectors.toList());
        return this;
    }
}
