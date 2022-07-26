package com.news.newsservice.controller;

import com.news.newsservice.common.utils.AttachmentResponseBuilder;
import com.news.newsservice.common.utils.AttachmentsResponseBuilder;
import com.news.newsservice.domain.Attachment;
import com.news.newsservice.dto.AttachmentDTO;
import com.news.newsservice.responses.AttachmentResponse;
import com.news.newsservice.services.Attachment.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-news/attachments/")
public class AttachmentController {

    @Autowired
    AttachmentService attachmentService;

    @PostMapping()
    public Attachment createAttachment(@RequestBody AttachmentDTO attachmentDTO) {
        return attachmentService.createAttachment(attachmentDTO);
    }

    @GetMapping("/{id}")
    public AttachmentResponse getAttachmentById(@PathVariable(name = "id") Long id) {
        return AttachmentResponseBuilder.getInstance(attachmentService.getAttachmentById(id)).buildAttachmentResponse();
    }

    @DeleteMapping("/{id}")
    public void deleteAttachmentById(@PathVariable(name = "id") Long id) {
        attachmentService.deleteAttachmentById(id);
    }

    @GetMapping("/all/")
    public List<AttachmentResponse> getListAllAttachment() {
        return AttachmentsResponseBuilder.getInstance(attachmentService.getListAllAttachment()).buildAttachmentsResponseList();
    }

    @PutMapping("/{id}")
    public AttachmentResponse putAttachmentById(@PathVariable(name = "id") Long id) {
        return AttachmentResponseBuilder.getInstance(attachmentService.getAttachmentById(id)).buildAttachmentResponse();
    }

    @PatchMapping("/{id}")
    public AttachmentResponse patchAttachmentById(@PathVariable(name = "id") Long id) {
        return AttachmentResponseBuilder.getInstance(attachmentService.getAttachmentById(id)).buildAttachmentResponse();
    }


}
