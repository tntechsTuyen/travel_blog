package com.travel.server.repository;

import com.travel.server.entity.Post;
import com.travel.server.entity.PostUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
