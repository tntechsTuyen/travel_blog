package com.travel.server.repository;

import com.travel.server.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {

    @Query("SELECT h.id AS id " +
            ", h.name AS name " +
            ", h.phone AS phone" +
            ", h.work AS work" +
            ", l.longitude AS lon " +
            ", l.latitude AS lat " +
            ", l.address AS address " +
            ", l.city AS city " +
            ", l.country AS country " +
            "FROM Hotel h " +
            "INNER JOIN Location l ON h.idLocation = l.id " +
            "WHERE DISTANCE(l.latitude, l.longitude, :lat, :lon) <= :distance ")
    List<Map<String, Object>> findByTravelArea(@Param("lat") Double lat, @Param("lon") Double lon, @Param("distance") Double distance);

}
