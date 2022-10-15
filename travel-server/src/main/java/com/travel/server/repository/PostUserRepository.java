package com.travel.server.repository;

import com.travel.server.entity.PostUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface PostUserRepository extends JpaRepository<PostUser, Integer> {

    PostUser findByIdPostAndIdUser(Integer idPost, Integer idUser);

    @Modifying
    @Transactional
    @Query(" UPDATE Post " +
            " SET ratePoint = ( "+
            "   SELECT AVG(rate) " +
            "   FROM PostUser " +
            "   WHERE idPost = :id " +
            "   AND rate != 0 " +
            " )" +
            "WHERE id = :id ")
    int updatePostRatePoint(@Param("id") Integer id);
}
