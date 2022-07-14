package com.news.newsservice.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "attachment")
@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
@AllArgsConstructor
@Getter
@Setter
public class Attachment {


    @ManyToOne(targetEntity = Bulletin.class, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "bulletin_id")
    public Long bulletin;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "accountId", nullable = false)
    private Long accountId;
    @Column(name = "fileId", nullable = false)
    private String fileId;
    @Column(name = "filePath", nullable = false)
    private String filePath;
    @Column(name = "createdDate", nullable = false)
    private Date createdDate;
    @Column(name = "isDeleted", nullable = false)
    private Boolean isDeleted;

}
