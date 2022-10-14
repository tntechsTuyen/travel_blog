package com.travel.server.service;

import com.travel.server.entity.TravelMeta;

import java.util.List;

public interface ITravelMetaService {

    List<TravelMeta> getByIdTravel(Integer id);
}
