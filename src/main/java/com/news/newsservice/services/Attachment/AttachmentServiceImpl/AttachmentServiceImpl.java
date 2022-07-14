package com.news.newsservice.services.Attachment.AttachmentServiceImpl;

import com.news.newsservice.domain.Attachment;
import com.news.newsservice.dto.AttachmentDTO;
import com.news.newsservice.repository.AttachmentRepository;
import com.news.newsservice.services.Attachment.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachmentServiceImpl implements AttachmentService {

    @Autowired
    AttachmentRepository attachmentRepository;

    @Override
    public Attachment createAttachment(AttachmentDTO attachmentDTO) {
        Attachment attachment = this.composeAttachment(attachmentDTO);
        return attachmentRepository.save(attachment);
    }

    @Override
    public List<Attachment> getListAllAttachment() {
        return null;
    }

    @Override
    public Attachment getAttachmentById(Long id) {
        return null;
    }

    @Override
    public List<Attachment> getAttachmentsByAccountId(Long id) {
        return null;
    }

    @Override
    public void deleteAttachmentById(Long id) {

    }

    private Attachment composeAttachment(AttachmentDTO attachmentDTO){
        Attachment attachment = new Attachment();

        return attachment;
    }
}
