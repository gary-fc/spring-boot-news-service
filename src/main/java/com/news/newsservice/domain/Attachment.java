package com.news.newsservice.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

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
    @JoinColumn(name = "bulletinId")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public Bulletin bulletin;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "accountId", nullable = false)
    private Long accountId;

    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "fileId", nullable = false)
    private String fileId;

    @Column(name = "filePath", nullable = false)
    private String filePath;

    @Column(name = "createdDate", nullable = false)
    private Date createdDate;

    @Column(name = "isDeleted", nullable = false)
    private Boolean isDeleted;

}
