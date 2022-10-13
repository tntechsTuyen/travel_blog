package com.travel.server.service.impl;

import com.travel.server.service.ILocationService;
import com.travel.server.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LocationService implements ILocationService {

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public List<Map<String, Object>> getDistinct() {
        return locationRepository.findDistinctCity();
    }
}
