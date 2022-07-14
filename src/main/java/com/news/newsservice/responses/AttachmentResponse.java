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
public class AttachmentResponse {
    private Long id;
    private Long accountId;
    private String fileId;
    private String filePath;
    private Date createdDate;
    private Boolean isDeleted;
    private Long bulletin;
}
