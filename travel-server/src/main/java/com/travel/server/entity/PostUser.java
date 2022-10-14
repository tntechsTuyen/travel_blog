package com.travel.server.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "post_user")
public class PostUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "id_post")
    private Integer idPost;

    @Column(name = "id_user")
    private Integer idUser;

    @Column(name = "is_read")
    private Integer isRead;

    @Column(name = "is_like")
    private Integer isLike = 0;

    @Column(name = "rate")
    private Integer rate = 0;
}
