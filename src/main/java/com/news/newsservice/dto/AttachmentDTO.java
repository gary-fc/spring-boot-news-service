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
public class AttachmentDTO {
    @NotNull
    private Long accountId;

    @NotNull
    private Long bulletinId;

    @NotNull
    private String filePath;

//    @NotNull
//    private String fileId;
//
//    @NotNull
//    private Date created_date;
//
//    @NotNull
//    private Boolean isDeleted;

}
