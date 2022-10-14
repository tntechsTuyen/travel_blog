package com.travel.server.repository;

import com.travel.server.entity.Travel;
import com.travel.server.entity.TravelMeta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TravelMetaRepository extends JpaRepository<TravelMeta, Integer> {

    List<TravelMeta> findByIdTravel(Integer idTravel);
}
