package com.news.newsservice.common.util;

import com.news.newsservice.domain.Attachment;
import com.news.newsservice.responses.AttachmentResponse;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class AttachmentsResponseBuilder {
    private List<AttachmentResponse> attachmentResponseList;

    private AttachmentsResponseBuilder() {
        attachmentResponseList = new LinkedList<>();
    }

    public static AttachmentsResponseBuilder getInstance(List<Attachment> attachmentList) {
        return new AttachmentsResponseBuilder().setAttachmentsList(attachmentList);
    }

    private AttachmentsResponseBuilder setAttachmentsList(List<Attachment> attachmentList) {
        attachmentResponseList = attachmentList.stream().map(attachment -> AttachmentResponseBuilder.getInstance(attachment).buildAttachmentResponse()).collect(Collectors.toList());
        return this;
    }

    public List<AttachmentResponse> buildAttachmentsResponseList() {
        return attachmentResponseList;
    }
}
