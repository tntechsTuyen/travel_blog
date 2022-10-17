package com.travel.server.service.impl;

import com.travel.server.entity.HotelMeta;
import com.travel.server.entity.TravelMeta;
import com.travel.server.repository.HotelMetaRepository;
import com.travel.server.repository.TravelMetaRepository;
import com.travel.server.service.IHotelMetaService;
import com.travel.server.service.IHotelService;
import com.travel.server.service.ITravelMetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelMetaService implements IHotelMetaService {

    @Autowired
    private HotelMetaRepository hotelMetaRepository;

    @Override
    public List<HotelMeta> getByIdHotel(Integer id) {
        return hotelMetaRepository.findByIdHotel(id);
    }
}
