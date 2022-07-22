package com.news.newsservice.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "bulletin")
@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
@AllArgsConstructor
@Getter
@Setter
public class Bulletin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "accountId", nullable = false)
    private Long accountId;

    @Column(name = "senderUserId", nullable = false)
    private Long senderUserId;

    @Column(name = "body", nullable = false)
    private String body;

    @Column(name = "createdDate", nullable = false)
    private Date createdDate;

    @Column(name = "isDeleted", nullable = false)
    private Boolean isDeleted;

    @Column(name = "commentsCounter", nullable = false)
    private Integer commentsCounter;

    @Column(name = "fileUrl")
    private String fileUrl;

    @OneToMany(targetEntity = Comment.class, mappedBy = "id", cascade = CascadeType.ALL)
    private Set<Comment> comments = new HashSet<>();
}
