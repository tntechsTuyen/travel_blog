package com.travel.server.repository;

import com.travel.server.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.*;


public interface TagRepository extends JpaRepository<Tag, Integer> {

    @Query("SELECT t.id AS id " +
            ", t.name AS name " +
            ", ut.idUser AS idUser " +
            "FROM Tag t " +
            "LEFT JOIN UserTag ut ON t.id = ut.idUser AND ut.idUser = :id ")
    List<Map<String, Object>> findUserSetting(@Param("id") Integer id);

}
