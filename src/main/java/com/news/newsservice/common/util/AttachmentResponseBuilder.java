package com.news.newsservice.common.util;

import com.news.newsservice.domain.Attachment;
import com.news.newsservice.responses.AttachmentResponse;

public class AttachmentResponseBuilder {
    private AttachmentResponse attachmentResponse;

    private AttachmentResponseBuilder() {
        attachmentResponse = new AttachmentResponse();
    }

    public static AttachmentResponseBuilder getInstance(Attachment attachment) {

        return new AttachmentResponseBuilder().setAttachment(attachment);
    }

    private AttachmentResponseBuilder setAttachment(Attachment attachment) {
        attachmentResponse.setAccountId(attachment.getAccountId());
        attachmentResponse.setFilePath(attachment.getFilePath());
        attachmentResponse.setCreatedDate(attachment.getCreatedDate());
        return this;
    }

    public AttachmentResponse buildAttachmentResponse() {
        return attachmentResponse;
    }
}
