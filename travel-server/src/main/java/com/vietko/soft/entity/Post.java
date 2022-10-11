package com.vietko.soft.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "type")
    private String type;

    @Column(name = "id_user")
    private Integer idUser;

    @Column(name = "total_view")
    private Integer totalView;

    @Column(name = "total_like")
    private Integer totalLike;

    @Column(name = "rate_point")
    private Integer ratePoint;

    @CreationTimestamp
    @Column(name = "created_date", updatable = false)
    private Date createdDate;
}
