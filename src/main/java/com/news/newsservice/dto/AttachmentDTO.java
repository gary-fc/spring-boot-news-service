package com.news.newsservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AttachmentDTO {
    @NotNull
    private Long accountId;

    @NotNull
    private Date created_date;

    @NotNull
    private String fileId;

    @NotNull
    private Boolean isDeleted;

    @NotNull
    private Long bulletinId;
}
