package com.news.newsservice.services.Attachment.AttachmentServiceImpl;

import com.news.newsservice.domain.Attachment;
import com.news.newsservice.domain.Bulletin;
import com.news.newsservice.dto.AttachmentDTO;
import com.news.newsservice.repository.AttachmentRepository;
import com.news.newsservice.repository.BulletinRepository;
import com.news.newsservice.services.Attachment.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class AttachmentServiceImpl implements AttachmentService {

    @Autowired
    AttachmentRepository attachmentRepository;

    @Autowired
    BulletinRepository bulletinRepository;

    @Override
    public Attachment createAttachment(AttachmentDTO attachmentDTO) {
        Bulletin bulletin = bulletinRepository.getById(attachmentDTO.getBulletinId());
        Attachment attachment = this.composeAttachment(attachmentDTO, bulletin);
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

    private Attachment composeAttachment(AttachmentDTO attachmentDTO, Bulletin bulletin) {
        Attachment attachment = new Attachment();
        attachment.setAccountId(attachmentDTO.getAccountId());
        attachment.setBulletin(bulletin);
        attachment.setFilePath(attachmentDTO.getFilePath());
        attachment.setCreatedDate(new Date());
        attachment.setFileId(UUID.randomUUID().toString());
        attachment.setIsDeleted(false);
        return attachment;
    }
}
