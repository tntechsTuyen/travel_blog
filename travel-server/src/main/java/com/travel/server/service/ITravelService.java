package com.travel.server.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.*;

public interface ITravelService {

    List<Map<String, Object>> getTravelList(String s);
    List<Map<String, Object>> getTravelAds();
    List<Map<String, Object>> getTravelTop();
    List<Map<String, Object>> getTravelHobbies();
    List<Map<String, Object>> getTravelLocationCode(Integer locationCode);
    Map<String, Object> getTravelDetail(Integer id);
}
