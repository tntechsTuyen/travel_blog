package com.travel.server.service.impl;

import com.travel.server.repository.HotelRepository;
import com.travel.server.repository.TravelRepository;
import com.travel.server.service.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class HotelService implements IHotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private TravelRepository travelRepository;

    @Override
    public List<Map<String, Object>> getHotelByTravel(Integer idTravel, Double distance) {
        Map<String, Object> travel = travelRepository.findTravelDetail(idTravel, "POST");
        Double lat = (Double) travel.get("lat");
        Double lon = (Double) travel.get("lon");
        return hotelRepository.findByTravelArea(lat, lon, distance);
    }
}
