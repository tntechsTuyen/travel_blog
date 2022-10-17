package com.travel.server.service;

import java.util.*;

public interface ITagService {

    List<Map<String, Object>> getList();
    boolean update(List<Integer> idTags);
}
