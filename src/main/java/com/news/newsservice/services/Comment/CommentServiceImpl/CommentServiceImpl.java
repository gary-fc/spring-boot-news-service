package com.news.newsservice.services.Comment.CommentServiceImpl;

import com.news.newsservice.domain.Comment;
import com.news.newsservice.dto.CommentDTO;
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

    @Override
    public Comment createComment(CommentDTO commentDTO) {
        Comment comment = this.composeComment(commentDTO);
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
    public void deleteCommentById(Long id) {
        commentRepository.deleteById(id);
    }

    private Comment composeComment(CommentDTO commentDTO){
        Comment comment = new Comment();
        comment.setAccountId(commentDTO.getAccountId());
        comment.setContent(commentDTO.getContent());
        comment.setCreateDate(new Date());
        comment.setIsDeleted(false);
        comment.setRepliesCounter(0);
        comment.setSenderUserId(commentDTO.getSenderUserId());
        comment.setBulletin(commentDTO.getBulletinId());
        comment.setParentComment(commentDTO.getCommentId());
        return comment;
    }
}
