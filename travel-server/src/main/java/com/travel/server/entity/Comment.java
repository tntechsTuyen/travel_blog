package com.travel.server.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "id_user")
    private Integer idUser;

    @Column(name = "id_post")
    private Integer idPost;

    @Column(name = "content")
    private String content;

    @Column(name = "id_parent")
    private Integer idParent;

    @CreationTimestamp
    @Column(name = "created_date", updatable = false)
    private Date createdDate;
}
