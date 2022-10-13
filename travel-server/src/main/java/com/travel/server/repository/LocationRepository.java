package com.travel.server.repository;

import com.travel.server.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.*;

public interface LocationRepository extends JpaRepository<Location, Integer> {

    @Query("SELECT city AS city " +
            ", code AS code " +
            "FROM Location " +
            "GROUP BY city, code ")
    List<Map<String, Object>> findDistinctCity();

}
