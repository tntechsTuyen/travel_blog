package com.travel.server.service.impl;

import com.travel.server.config.security.JwtUserDetailsService;
import com.travel.server.entity.Comment;
import com.travel.server.entity.User;
import com.travel.server.repository.CommentRepository;
import com.travel.server.service.ICommentService;
import com.travel.server.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CommentService implements ICommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Autowired
    private IPostService postService;

    @Override
    public List<Map<String, Object>> findByIdPost(Integer idPost) {
        return commentRepository.findByIdPost(idPost);
    }

    @Override
    public Map<String, Object> save(Comment comment) {
        try{
            User userLogin = userDetailsService.getUserLogin();
            comment.setIdUser(userLogin.getId());
            commentRepository.save(comment);
            postService.comment(comment.getIdPost());
            return commentRepository.findByIdCmt(comment.getId());
        }catch (Exception e){

        }
        return null;
    }
}
