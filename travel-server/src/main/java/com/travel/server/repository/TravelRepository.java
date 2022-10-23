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
            ", l.longitude AS lon " +
            ", l.latitude AS lat " +
            ", l.address AS address " +
            ", l.city AS city " +
            ", l.country AS country " +
            ", p.id AS idPost " +
            ", p.totalView AS totalView " +
            ", p.totalLike AS totalLike " +
            ", p.totalComment AS totalComment " +
            ", p.ratePoint AS ratePoint " +
            ", p.createdDate AS createdDate " +
            ", m.url AS mediaUrl " +
            ", m.type AS mediaType" +
            ", tg.name AS tagName " +
            "FROM Travel t " +
            "INNER JOIN Location l ON t.idLocation = l.id " +
            "INNER JOIN TravelPost tp ON t.id = tp.idTravel " +
            "INNER JOIN Post p ON tp.idPost = p.id " +
            "INNER JOIN TravelTag ttg ON t.id = ttg.idTravel " +
            "INNER JOIN Tag tg ON ttg.idTag = tg.id " +
            "LEFT JOIN PostMedia pm ON p.id = pm.idPost AND pm.flag = 'thumb' " +
            "LEFT JOIN Media m ON pm.idMedia = m.id " +
            "WHERE t.name LIKE %:s%")
    List<Map<String, Object>> findTravelList(@Param("s") String search);

    @Query("SELECT t.id AS id " +
            ", t.name AS name " +
            ", t.description AS description " +
            ", l.longitude AS lon " +
            ", l.latitude AS lat " +
            ", l.address AS address " +
            ", l.city AS city " +
            ", l.country AS country " +
            ", p.id AS idPost " +
            ", p.totalView AS totalView " +
            ", p.totalLike AS totalLike " +
            ", p.totalComment AS totalComment " +
            ", p.ratePoint AS ratePoint " +
            ", p.createdDate AS createdDate " +
            ", m.url AS mediaUrl " +
            ", m.type AS mediaType" +
            ", tg.name AS tagName " +
            "FROM Travel t " +
            "INNER JOIN Location l ON t.idLocation = l.id " +
            "INNER JOIN TravelPost tp ON t.id = tp.idTravel " +
            "INNER JOIN Post p ON tp.idPost = p.id " +
            "INNER JOIN TravelTag ttg ON t.id = ttg.idTravel " +
            "INNER JOIN Tag tg ON ttg.idTag = tg.id " +
            "LEFT JOIN PostMedia pm ON p.id = pm.idPost AND pm.flag = 'thumb' " +
            "LEFT JOIN Media m ON pm.idMedia = m.id " +
            "WHERE p.isAds = 1 ")
    List<Map<String, Object>> findTravelAds();

    @Query("SELECT t.id AS id " +
            ", t.name AS name " +
            ", t.description AS description " +
            ", l.longitude AS lon " +
            ", l.latitude AS lat " +
            ", l.address AS address " +
            ", l.city AS city " +
            ", l.country AS country " +
            ", p.id AS idPost " +
            ", p.totalView AS totalView " +
            ", p.totalLike AS totalLike " +
            ", p.totalComment AS totalComment " +
            ", p.ratePoint AS ratePoint " +
            ", p.createdDate AS createdDate " +
            ", m.url AS mediaUrl " +
            ", m.type AS mediaType " +
            ", tg.name AS tagName " +
            "FROM Travel t " +
            "INNER JOIN Location l ON t.idLocation = l.id " +
            "INNER JOIN TravelPost tp ON t.id = tp.idTravel " +
            "INNER JOIN Post p ON tp.idPost = p.id " +
            "INNER JOIN TravelTag ttg ON t.id = ttg.idTravel " +
            "INNER JOIN Tag tg ON ttg.idTag = tg.id " +
            "LEFT JOIN PostMedia pm ON p.id = pm.idPost AND pm.flag = 'thumb' " +
            "LEFT JOIN Media m ON pm.idMedia = m.id " +
            "WHERE p.type = 'POST' ")
    Page<Map<String, Object>> findTravelTop(Pageable pageable);

    @Query("SELECT t.id AS id " +
            ", t.name AS name " +
            ", t.description AS description " +
            ", l.longitude AS lon " +
            ", l.latitude AS lat " +
            ", l.address AS address " +
            ", l.city AS city " +
            ", l.country AS country " +
            ", p.id AS idPost " +
            ", p.totalView AS totalView " +
            ", p.totalLike AS totalLike " +
            ", p.totalComment AS totalComment " +
            ", p.ratePoint AS ratePoint " +
            ", p.createdDate AS createdDate " +
            ", m.url AS mediaUrl " +
            ", m.type AS mediaType " +
            ", tg.name AS tagName " +
            "FROM Travel t " +
            "INNER JOIN TravelTag tt ON t.id = tt.idTravel " +
            "INNER JOIN Location l ON t.idLocation = l.id " +
            "INNER JOIN TravelPost tp ON t.id = tp.idTravel " +
            "INNER JOIN Post p ON tp.idPost = p.id " +
            "INNER JOIN TravelTag ttg ON t.id = ttg.idTravel " +
            "INNER JOIN Tag tg ON ttg.idTag = tg.id " +
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
            ", l.longitude AS lon " +
            ", l.latitude AS lat " +
            ", l.address AS address " +
            ", l.city AS city " +
            ", l.country AS country " +
            ", p.id AS idPost " +
            ", p.totalView AS totalView " +
            ", p.totalLike AS totalLike " +
            ", p.totalComment AS totalComment " +
            ", p.ratePoint AS ratePoint " +
            ", p.createdDate AS createdDate " +
            ", m.url AS mediaUrl " +
            ", m.type AS mediaType " +
            ", tg.name AS tagName " +
            "FROM Travel t " +
            "INNER JOIN TravelTag tt ON t.id = tt.idTravel " +
            "INNER JOIN Location l ON t.idLocation = l.id " +
            "INNER JOIN TravelPost tp ON t.id = tp.idTravel " +
            "INNER JOIN Post p ON tp.idPost = p.id " +
            "INNER JOIN TravelTag ttg ON t.id = ttg.idTravel " +
            "INNER JOIN Tag tg ON ttg.idTag = tg.id " +
            "LEFT JOIN PostMedia pm ON p.id = pm.idPost AND pm.flag = 'thumb' " +
            "LEFT JOIN Media m ON pm.idMedia = m.id " +
            "WHERE p.type = 'POST' " +
            "AND l.code = :location_code ")
    List<Map<String, Object>> findTravelByLocationCode(@Param("location_code") Integer locationCode);

    @Query("SELECT t.id AS id " +
            ", t.name AS name " +
            ", t.description AS description " +
            ", l.longitude AS lon " +
            ", l.latitude AS lat " +
            ", l.address AS address " +
            ", l.city AS city " +
            ", l.country AS country " +
            ", p.id AS idPost " +
            ", p.totalView AS totalView " +
            ", p.totalLike AS totalLike " +
            ", p.totalComment AS totalComment " +
            ", p.ratePoint AS ratePoint " +
            ", p.rateCount AS rateCount " +
            ", p.createdDate AS createdDate " +
            ", m.url AS mediaUrl " +
            ", m.type AS mediaType " +
            ", tg.name AS tagName " +
            ", pu.isLike AS isLike " +
            ", pu.rate AS rate " +
            "FROM Travel t " +
            "INNER JOIN TravelTag tt ON t.id = tt.idTravel " +
            "INNER JOIN Location l ON t.idLocation = l.id " +
            "INNER JOIN TravelPost tp ON t.id = tp.idTravel " +
            "INNER JOIN Post p ON tp.idPost = p.id " +
            "INNER JOIN TravelTag ttg ON t.id = ttg.idTravel " +
            "INNER JOIN Tag tg ON ttg.idTag = tg.id " +
            "LEFT JOIN PostUser pu ON p.id = pu.idPost AND pu.idUser = :id_user " +
            "LEFT JOIN PostMedia pm ON p.id = pm.idPost AND pm.flag = 'thumb' " +
            "LEFT JOIN Media m ON pm.idMedia = m.id " +
            "WHERE t.id = :id ")
    Map<String, Object> findTravelDetail(@Param("id") Integer id, @Param("id_user") Integer idUser);
}
