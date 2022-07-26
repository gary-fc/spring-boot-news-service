package com.news.newsservice.services.Comment.CommentServiceImpl;

import com.news.newsservice.domain.Bulletin;
import com.news.newsservice.domain.Comment;
import com.news.newsservice.dto.CommentDTO;
import com.news.newsservice.repository.BulletinRepository;
import com.news.newsservice.repository.CommentRepository;
import com.news.newsservice.responses.User;
import com.news.newsservice.services.Auth.AuthService;
import com.news.newsservice.services.Comment.CommentService;
import com.news.newsservice.wrapper.CommentWrapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service("CommentServiceImpl")
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final BulletinRepository bulletinRepository;
    private final AuthService authService;

    public CommentServiceImpl(CommentRepository commentRepository, BulletinRepository bulletinRepository, AuthService authService) {
        this.commentRepository = commentRepository;
        this.bulletinRepository = bulletinRepository;
        this.authService = authService;
    }

    @Override
    public CommentWrapper createComment(Long bulletinId, CommentDTO commentDTO) {
        Bulletin bulletin = bulletinRepository.getById(bulletinId);
        Comment comment = commentRepository.save(composeComment(commentDTO, bulletin));
        User user = authService.userByAccountId(bulletin.getAccountId());
        return composeCommentWrapper(comment, user);
    }


    @Override
    public List<CommentWrapper> getListAllComment() {
        List<Comment> comments = commentRepository.findAll();
        List<CommentWrapper> commentWrappers = new LinkedList<>();
        commentWrappers = comments.stream().map(bulletin -> composeCommentWrapper(bulletin,
                authService.userByAccountId(bulletin.getAccountId()))).collect(Collectors.toList());
        return commentWrappers;
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
    public List<CommentWrapper> getCommentsByBulletinId(Long id) {
        List<Comment> comments = commentRepository.getAllByBulletinId(id);
        List<CommentWrapper> commentWrappers = new LinkedList<>();
        commentWrappers = comments.stream().map(bulletin -> composeCommentWrapper(bulletin,
                authService.userByAccountId(bulletin.getAccountId()))).collect(Collectors.toList());
        return commentWrappers;
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

    private CommentWrapper composeCommentWrapper(Comment comment, User user) {
        CommentWrapper commentWrapper = new CommentWrapper();
        commentWrapper.setId(comment.getId());
        commentWrapper.setSenderUserId(comment.getSenderUserId());
        commentWrapper.setRepliesCounter(comment.getRepliesCounter());
        commentWrapper.setContent(comment.getContent());
        commentWrapper.setCreateDate(comment.getCreateDate());
        commentWrapper.setIsDeleted(comment.getIsDeleted());
        commentWrapper.setUser(user);
        commentWrapper.setBulletinId(comment.getBulletinId());
        return commentWrapper;
    }
}
