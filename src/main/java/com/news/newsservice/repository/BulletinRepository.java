package com.news.newsservice.repository;

import com.news.newsservice.domain.Bulletin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BulletinRepository extends JpaRepository<Bulletin, Long> {
    List<Bulletin> findAllByAccountId(Long id);
}
