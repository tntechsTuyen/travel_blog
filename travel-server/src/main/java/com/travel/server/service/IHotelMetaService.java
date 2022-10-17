package com.travel.server.service;

import com.travel.server.entity.HotelMeta;
import com.travel.server.entity.TravelMeta;

import java.util.List;

public interface IHotelMetaService {

    List<HotelMeta> getByIdHotel(Integer id);
}
