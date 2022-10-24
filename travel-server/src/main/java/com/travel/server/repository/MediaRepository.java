package com.travel.server.repository;

import com.travel.server.entity.Media;
import com.travel.server.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;


public interface MediaRepository extends JpaRepository<Media, Integer> {


}
