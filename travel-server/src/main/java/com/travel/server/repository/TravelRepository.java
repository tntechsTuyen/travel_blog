package com.travel.server.repository;

import com.travel.server.entity.Travel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.*;

public interface TravelRepository extends JpaRepository<Travel, Integer> {
    @Query("SELECT t.id AS id " +
            ", t.name AS name " +
            ", t.description AS description " +
            ", l.address AS address " +
            ", l.city AS city " +
            ", l.country AS country " +
            ", p.id AS idPost " +
            ", p.totalView AS totalView " +
            ", p.totalLike AS totalLike " +
            ", p.ratePoint AS ratePoint " +
            ", m.url AS mediaUrl " +
            ", m.type AS mediaType " +
            "FROM Travel t " +
            "INNER JOIN Location l ON t.idLocation = l.id " +
            "INNER JOIN TravelPost tp ON t.id = tp.idTravel " +
            "INNER JOIN Post p ON tp.idPost = p.id " +
            "LEFT JOIN PostMedia pm ON p.id = pm.idPost AND pm.flag = 'thumb' " +
            "LEFT JOIN Media m ON pm.idMedia = m.id " +
            "WHERE p.type = 'ADS' ")
    List<Map<String, Object>> findTravelAds();

    @Query("SELECT t.id AS id " +
            ", t.name AS name " +
            ", t.description AS description " +
            ", l.address AS address " +
            ", l.city AS city " +
            ", l.country AS country " +
            ", p.id AS idPost " +
            ", p.totalView AS totalView " +
            ", p.totalLike AS totalLike " +
            ", p.ratePoint AS ratePoint " +
            ", m.url AS mediaUrl " +
            ", m.type AS mediaType " +
            "FROM Travel t " +
            "INNER JOIN Location l ON t.idLocation = l.id " +
            "INNER JOIN TravelPost tp ON t.id = tp.idTravel " +
            "INNER JOIN Post p ON tp.idPost = p.id " +
            "LEFT JOIN PostMedia pm ON p.id = pm.idPost AND pm.flag = 'thumb' " +
            "LEFT JOIN Media m ON pm.idMedia = m.id " +
            "WHERE p.type = 'POST' ")
    Page<Map<String, Object>> findTravelTop(Pageable pageable);

    @Query("SELECT t.id AS id " +
            ", t.name AS name " +
            ", t.description AS description " +
            ", l.address AS address " +
            ", l.city AS city " +
            ", l.country AS country " +
            ", p.id AS idPost " +
            ", p.totalView AS totalView " +
            ", p.totalLike AS totalLike " +
            ", p.ratePoint AS ratePoint " +
            ", m.url AS mediaUrl " +
            ", m.type AS mediaType " +
            "FROM Travel t " +
            "INNER JOIN TravelTag tt ON t.id = tt.idTravel " +
            "INNER JOIN Location l ON t.idLocation = l.id " +
            "INNER JOIN TravelPost tp ON t.id = tp.idTravel " +
            "INNER JOIN Post p ON tp.idPost = p.id " +
            "LEFT JOIN PostMedia pm ON p.id = pm.idPost AND pm.flag = 'thumb' " +
            "LEFT JOIN Media m ON pm.idMedia = m.id " +
            "WHERE p.type = 'POST' " +
            "AND tt.idTag IN ( " +
            "   SELECT ut.idTag " +
            "   FROM UserTag ut " +
            "   WHERE ut.idUser = :user_id " +
            " )")
    List<Map<String, Object>> findTravelHobbies(@Param("user_id") Integer userId);

    @Query("SELECT t.id AS id " +
            ", t.name AS name " +
            ", t.description AS description " +
            ", l.address AS address " +
            ", l.city AS city " +
            ", l.country AS country " +
            ", p.id AS idPost " +
            ", p.totalView AS totalView " +
            ", p.totalLike AS totalLike " +
            ", p.ratePoint AS ratePoint " +
            ", m.url AS mediaUrl " +
            ", m.type AS mediaType " +
            "FROM Travel t " +
            "INNER JOIN TravelTag tt ON t.id = tt.idTravel " +
            "INNER JOIN Location l ON t.idLocation = l.id " +
            "INNER JOIN TravelPost tp ON t.id = tp.idTravel " +
            "INNER JOIN Post p ON tp.idPost = p.id " +
            "LEFT JOIN PostMedia pm ON p.id = pm.idPost AND pm.flag = 'thumb' " +
            "LEFT JOIN Media m ON pm.idMedia = m.id " +
            "WHERE p.type = 'POST' " +
            "AND l.city LIKE :city ")
    List<Map<String, Object>> findTravelByCity(@Param("city") String city);

    @Query("SELECT t.id AS id " +
            ", t.name AS name " +
            ", t.description AS description " +
            ", l.address AS address " +
            ", l.city AS city " +
            ", l.country AS country " +
            ", p.id AS idPost " +
            ", p.totalView AS totalView " +
            ", p.totalLike AS totalLike " +
            ", p.ratePoint AS ratePoint " +
            ", m.url AS mediaUrl " +
            ", m.type AS mediaType " +
            "FROM Travel t " +
            "INNER JOIN TravelTag tt ON t.id = tt.idTravel " +
            "INNER JOIN Location l ON t.idLocation = l.id " +
            "INNER JOIN TravelPost tp ON t.id = tp.idTravel " +
            "INNER JOIN Post p ON tp.idPost = p.id " +
            "LEFT JOIN PostMedia pm ON p.id = pm.idPost AND pm.flag = 'thumb' " +
            "LEFT JOIN Media m ON pm.idMedia = m.id " +
            "WHERE p.type = 'POST' " +
            "AND t.id = :id ")
    Map<String, Object> findTravelDetail(@Param("id") Integer id);
}
