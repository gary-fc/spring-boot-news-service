package com.news.newsservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CommentDTO {
    @NotNull
    private Long accountId;

    @NotNull
    private String content;

    @NotNull
    private Long senderUserId;

    private Long commentId;
}
