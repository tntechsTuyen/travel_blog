package com.travel.server.service;

import java.util.List;
import java.util.Map;

public interface IHotelService {

    List<Map<String, Object>> getHotelByTravel(Integer idTravel, Double distance);
    Map<String, Object> getHotelDetail(Integer idHotel);
}
