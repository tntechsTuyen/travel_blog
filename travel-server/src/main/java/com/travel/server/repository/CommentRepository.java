package com.travel.server.repository;

import com.travel.server.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.*;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

    @Query("SELECT u.username AS username " +
            ", c.content AS content " +
            ", c.id AS id " +
            ", c.idPost AS idPost " +
            ", c.idUser AS idUser " +
            ", c.content AS content " +
            ", c.idParent AS idParent " +
            ", c.createdDate AS createdDate " +
            ", m.url AS mediaUrl " +
            "FROM Comment c " +
            "INNER JOIN User u ON c.idUser = u.id " +
            "LEFT JOIN Media m ON c.idMedia = m.id " +
            "WHERE c.idPost = :id_post " +
            "ORDER BY c.createdDate DESC ")
    List<Map<String, Object>> findByIdPost(@Param("id_post") Integer idPost);

    @Query("SELECT u.fullName AS fullName " +
            ", c.content AS content " +
            ", c.id AS id " +
            ", c.idPost AS idPost " +
            ", c.idUser AS idUser " +
            ", c.content AS content " +
            ", c.idParent AS idParent " +
            ", c.createdDate AS createdDate " +
            "FROM Comment c " +
            "INNER JOIN User u ON c.idUser = u.id " +
            "WHERE c.id = :id ")
    Map<String, Object> findByIdCmt(@Param("id") Integer id);

}
