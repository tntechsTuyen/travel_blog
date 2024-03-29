package com.travel.server.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "travel_tag")
public class TravelTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "id_travel")
    private Integer idTravel;

    @Column(name = "id_tag")
    private Integer idTag;
}
