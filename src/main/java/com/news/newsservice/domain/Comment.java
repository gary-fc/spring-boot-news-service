package com.news.newsservice.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name = "comment")
@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
@AllArgsConstructor
@Getter
@Setter
public class Comment {


    @ManyToOne(targetEntity = Bulletin.class, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "bulletin")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Bulletin bulletin;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "accountId", nullable = false)
    private Long accountId;

    @Column(name = "bulletinId", nullable = false)
    private Long bulletinId;

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


    @ManyToOne
    @JoinColumn(name = "parentComment", referencedColumnName = "id")
    @JsonBackReference
    private Comment parentComment;
}
