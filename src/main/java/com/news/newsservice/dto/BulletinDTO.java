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
public class BulletinDTO {

    @NotNull
    private Long accountId;

    @NotNull
    private Long senderUserId;

    @NotNull
    private String body;

    // TODO: Implementation should be removed when the upload files are will ready.
    private String fileUrl;

}
