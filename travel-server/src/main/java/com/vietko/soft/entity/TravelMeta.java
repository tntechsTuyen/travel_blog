package com.vietko.soft.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "travel_meta")
public class TravelMeta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "id_travel")
    private Integer idTravel;

    @Column(name = "key")
    private String key;

    @Column(name = "name")
    private String name;

    @Column(name = "value")
    private String value;

    @Column(name = "description")
    private String description;

    @CreationTimestamp
    @Column(name = "created_date", updatable = false)
    private Date createdDate;
}
