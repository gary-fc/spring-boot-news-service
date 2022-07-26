package com.news.newsservice.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(schema = "ONB", name = "bulletin")
@Data
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class Bulletin extends AuditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "accountId", nullable = false)
    private Long accountId;

    @Column(name = "senderUserId", nullable = false)
    private Long senderUserId;

    @Column(name = "body", nullable = false)
    private String body;

    @Column(name = "commentsCounter", nullable = false)
    private Integer commentsCounter;

    @Column(name = "fileUrl")
    private String fileUrl;

    @OneToMany(targetEntity = Comment.class, mappedBy = "id", cascade = CascadeType.ALL)
    private Set<Comment> comments = new HashSet<>();
}
