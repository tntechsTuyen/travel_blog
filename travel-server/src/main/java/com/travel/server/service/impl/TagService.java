package com.travel.server.service.impl;

import com.travel.server.config.security.JwtUserDetailsService;
import com.travel.server.entity.User;
import com.travel.server.entity.UserTag;
import com.travel.server.repository.TagRepository;
import com.travel.server.repository.UserTagRepository;
import com.travel.server.service.ITagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TagService implements ITagService {

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private UserTagRepository userTagRepository;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Override
    public List<Map<String, Object>> getList() {
        User userLogin = userDetailsService.getUserLogin();
        return tagRepository.findUserSetting(userLogin.getId());
    }

    @Override
    public boolean update(List<Integer> idTags) {
        User userLogin = userDetailsService.getUserLogin();
        userTagRepository.deleteByUserAndNotInList(userLogin.getId(), idTags);
        List<Integer> userIdTag = userTagRepository.findIdTagByIdUser(userLogin.getId());
        idTags.removeAll(userIdTag);
        if(idTags.size() > 0){
            for(int i = 0; i < idTags.size(); i++){
                userTagRepository.save(new UserTag(userLogin.getId(), idTags.get(i)));
            }
        }
        return true;
    }

}
