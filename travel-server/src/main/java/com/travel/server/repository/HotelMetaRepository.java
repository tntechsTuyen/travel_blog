package com.travel.server.repository;

import com.travel.server.entity.HotelMeta;
import com.travel.server.entity.TravelMeta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelMetaRepository extends JpaRepository<HotelMeta, Integer> {

    List<HotelMeta> findByIdHotel(Integer idHotel);
}
