package com.travel.server.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "user_tag")
public class UserTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "id_user")
    private Integer idUser;

    @Column(name = "id_tag")
    private Integer idTag;

    public UserTag() {
    }

    public UserTag(Integer idUser, Integer idTag) {
        this.idUser = idUser;
        this.idTag = idTag;
    }
}
