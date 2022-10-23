package com.travel.server.service.impl;

import com.travel.server.config.security.JwtUserDetailsService;
import com.travel.server.entity.User;
import com.travel.server.repository.HotelRepository;
import com.travel.server.repository.TravelRepository;
import com.travel.server.service.IHotelService;
import com.travel.server.service.IPostService;
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

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Autowired
    private IPostService postService;

    @Override
    public List<Map<String, Object>> getHotelByTravel(Integer idTravel, Double distance) {
        Integer idUser = null;
        try{
            User userLogin = userDetailsService.getUserLogin();
            idUser = userLogin.getId();
        } catch (Exception e){

        }
        Map<String, Object> travel = travelRepository.findTravelDetail(idTravel, idUser);
        Double lat = (Double) travel.get("lat");
        Double lon = (Double) travel.get("lon");
        return hotelRepository.findByTravelArea(lat, lon, distance);
    }

    @Override
    public Map<String, Object> getHotelDetail(Integer idHotel) {
        Map<String, Object> data = hotelRepository.findHotelDetail(idHotel);
        try{
            User userLogin = userDetailsService.getUserLogin();
            Integer idPost = (Integer) data.get("idPost");
            postService.read(idPost, userLogin.getId());
        } catch (Exception e){

        }
        return data;
    }
}
