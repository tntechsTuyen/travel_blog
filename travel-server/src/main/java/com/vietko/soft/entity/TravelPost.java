package com.vietko.soft.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "travel_meta")
public class TravelPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "id_travel")
    private Integer idTravel;

    @Column(name = "id_post")
    private Integer idPost;
}
