package com.travel.server.service.impl;

import com.travel.server.entity.TravelMeta;
import com.travel.server.repository.TravelMetaRepository;
import com.travel.server.service.ITravelMetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TravelMetaService implements ITravelMetaService {

    @Autowired
    private TravelMetaRepository travelMetaRepository;

    @Override
    public List<TravelMeta> getByIdTravel(Integer id) {
        return travelMetaRepository.findByIdTravel(id);
    }
}
