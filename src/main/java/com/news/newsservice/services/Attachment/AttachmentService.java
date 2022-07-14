package com.news.newsservice.services.Attachment;

import com.news.newsservice.domain.Attachment;
import com.news.newsservice.dto.AttachmentDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AttachmentService {
    Attachment createAttachment(AttachmentDTO attachmentDTO);

    List<Attachment> getListAllAttachment();

    Attachment getAttachmentById(Long id);

    List<Attachment> getAttachmentsByAccountId(Long id);

    void deleteAttachmentById(Long id);
}
