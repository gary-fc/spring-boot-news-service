package com.news.newsservice.repository;

import com.news.newsservice.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> getAllByAccountId(Long id);

    List<Comment> getAllByBulletinId(Long id);
}
