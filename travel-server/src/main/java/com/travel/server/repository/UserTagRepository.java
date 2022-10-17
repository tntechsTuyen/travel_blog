package com.travel.server.repository;

import com.travel.server.entity.Tag;
import com.travel.server.entity.UserTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface UserTagRepository extends JpaRepository<UserTag, Integer> {

    @Query("SELECT idTag " +
            "FROM UserTag " +
            "WHERE idUser = :id_user ")
    List<Integer> findIdTagByIdUser(@Param("id_user") Integer idUser);

    @Modifying
    @Transactional
    @Query(" DELETE FROM UserTag ut " +
            " WHERE ut.idUser = :id_user " +
            " AND ut.idTag NOT IN :id_tags ")
    int deleteByUserAndNotInList(@Param("id_user") Integer idUser, @Param("id_tags") List<Integer> idTags);
}
