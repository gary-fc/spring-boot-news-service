package com.news.newsservice.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comment")
@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
@AllArgsConstructor
@Getter
@Setter
public class Comment {

    @ManyToOne(targetEntity = Bulletin.class, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "bulletin_id")
    public Long bulletin;
    @ManyToOne(targetEntity = Comment.class, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "comment_id", referencedColumnName = "id")
    public Long parentComment;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "accountId", nullable = false)
    private Long accountId;
    @Column(name = "senderUserId", nullable = false)
    private Long senderUserId;
    @Column(name = "content", nullable = false)
    private String content;
    @Column(name = "repliesCounter", nullable = false)
    private Integer repliesCounter;
    @Column(name = "createDate", nullable = false)
    private Date createDate;
    @Column(name = "isDeleted", nullable = false)
    private Boolean isDeleted;
}
