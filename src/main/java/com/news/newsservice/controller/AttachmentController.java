package com.news.newsservice.controller;

import com.news.newsservice.common.util.AttachmentResponseBuilder;
import com.news.newsservice.common.util.AttachmentsResponseBuilder;
import com.news.newsservice.dto.AttachmentDTO;
import com.news.newsservice.responses.AttachmentResponse;
import com.news.newsservice.services.Attachment.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attachments/")
public class AttachmentController {

    @Autowired
    AttachmentService attachmentService;

    @PostMapping("createAttachment")
    public AttachmentResponse createAttachment(@RequestBody AttachmentDTO attachmentDTO) {
        return AttachmentResponseBuilder.getInstance(attachmentService.createAttachment(attachmentDTO)).buildAttachmentResponse();
    }

    @GetMapping("/byId/{id}")
    public AttachmentResponse getAttachmentById(@PathVariable(name = "id") Long id) {
        return AttachmentResponseBuilder.getInstance(attachmentService.getAttachmentById(id)).buildAttachmentResponse();
    }

    @GetMapping("/all/")
    public List<AttachmentResponse> getListAllAttachment() {
        return AttachmentsResponseBuilder.getInstance(attachmentService.getListAllAttachment()).buildAttachmentsResponseList();
    }

    @GetMapping("/listByAccountId/{id}")
    public List<AttachmentResponse> getAttachmentsByAccountId(@PathVariable(name = "id") Long id) {
        return AttachmentsResponseBuilder.getInstance(attachmentService.getAttachmentsByAccountId(id)).buildAttachmentsResponseList();
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteAttachmentById(@PathVariable(name = "id") Long id){
        attachmentService.deleteAttachmentById(id);
    }
}
