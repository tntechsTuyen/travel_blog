package com.vietko.soft.repository;

import com.vietko.soft.entity.Travel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.*;

public interface TravelRepository extends JpaRepository<Travel, Integer> {
    @Query("SELECT t.id " +
            ", t.name " +
            ", t.description " +
            ", l.address " +
            ", l.city " +
            ", l.country " +
            ", p.id AS postId " +
            ", p.totalView " +
            ", p.totalLike " +
            ", p.ratePoint " +
            "FROM Travel t " +
            "INNER JOIN Location l ON t.idLocation = l.id " +
            "INNER JOIN TravelPost tp ON t.id = tp.idTravel " +
            "INNER JOIN Post p ON tp.idPost = p.id " +
            "WHERE p.type = 'ADS' ")
    List<Map<String, Object>> findTravelAds();

    @Query("SELECT t.id " +
            ", t.name " +
            ", t.description " +
            ", l.address " +
            ", l.city " +
            ", l.country " +
            ", p.id AS postId " +
            ", p.totalView " +
            ", p.totalLike " +
            ", p.ratePoint " +
            "FROM Travel t " +
            "INNER JOIN Location l ON t.idLocation = l.id " +
            "INNER JOIN TravelPost tp ON t.id = tp.idTravel " +
            "INNER JOIN Post p ON tp.idPost = p.id " +
            "WHERE p.type = 'POST' ")
    Page<Map<String, Object>> findTravelTop(Pageable pageable);
}
