package com.news.newsservice.services.Comment.CommentServiceImpl;

import com.news.newsservice.domain.Bulletin;
import com.news.newsservice.domain.Comment;
import com.news.newsservice.dto.CommentDTO;
import com.news.newsservice.repository.BulletinRepository;
import com.news.newsservice.repository.CommentRepository;
import com.news.newsservice.services.Comment.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    BulletinRepository bulletinRepository;

    @Override
    public Comment createComment(Long bulletinId, CommentDTO commentDTO) {
        Bulletin bulletin = bulletinRepository.getById(bulletinId);
        Comment comment = this.composeComment(commentDTO, bulletin);
        return commentRepository.save(comment);
    }


    @Override
    public List<Comment> getListAllComment() {
        return commentRepository.findAll();
    }

    @Override
    public Comment getCommentById(Long id) {
        return commentRepository.getById(id);
    }

    @Override
    public List<Comment> getCommentsByAccountId(Long id) {
        return commentRepository.getAllByAccountId(id);
    }

    @Override
    public List<Comment> getCommentsByBulletinId(Long id) {
        return commentRepository.getAllByBulletinId(id);
    }

    @Override
    public void deleteCommentById(Long id) {
        commentRepository.deleteById(id);
    }

    private Comment composeComment(CommentDTO commentDTO, Bulletin bulletin) {
        Comment comment = new Comment();
        comment.setAccountId(commentDTO.getAccountId());
        comment.setContent(commentDTO.getContent());
        comment.setCreateDate(new Date());
        comment.setIsDeleted(false);
        comment.setRepliesCounter(0);
        comment.setSenderUserId(commentDTO.getSenderUserId());
        comment.setBulletin(bulletin);
        comment.setBulletinId(bulletin.getId());
        return comment;
    }
}
