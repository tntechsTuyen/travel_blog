package com.travel.server.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "hotel_post")
public class HotelPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "id_hotel")
    private Integer idHotel;

    @Column(name = "id_post")
    private Integer idPost;
}
