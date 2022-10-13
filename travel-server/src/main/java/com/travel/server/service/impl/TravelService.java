package com.travel.server.service.impl;

import com.travel.server.config.security.JwtUserDetailsService;
import com.travel.server.entity.User;
import com.travel.server.service.ITravelService;
import com.travel.server.repository.TravelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TravelService implements ITravelService {

    @Autowired
    private TravelRepository travelRepository;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Override
    public List<Map<String, Object>> getTravelAds() {
        return travelRepository.findTravelAds();
    }

    @Override
    public List<Map<String, Object>> getTravelTop() {
        Pageable pageable = PageRequest.of(0, 5, Sort.by("p.ratePoint").descending());
        return travelRepository.findTravelTop(pageable).getContent();
    }

    @Override
    public List<Map<String, Object>> getTravelHobbies() {
        User userLogin = userDetailsService.getUserLogin();
        return travelRepository.findTravelHobbies(userLogin.getId());
    }

    @Override
    public List<Map<String, Object>> getTravelLocationCode(Integer locationCode) {
        return travelRepository.findTravelByLocationCode(locationCode);
    }

    @Override
    public Map<String, Object> getTravelDetail(Integer id) {
        return travelRepository.findTravelDetail(id);
    }
}
