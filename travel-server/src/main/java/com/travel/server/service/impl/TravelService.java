package com.travel.server.service.impl;

import com.travel.server.config.security.JwtUserDetailsService;
import com.travel.server.entity.User;
import com.travel.server.repository.PostRepository;
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
    private PostService postService;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Override
    public List<Map<String, Object>> getTravelList(String s) {
        return travelRepository.findTravelList(s);
    }

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
        Map<String, Object> data = travelRepository.findTravelDetail(id);
        try{
            User userLogin = userDetailsService.getUserLogin();
            Integer idPost = (Integer) data.get("idPost");
            postService.read(idPost, userLogin.getId());
        } catch (Exception e){

        }
        return data;
    }
}
