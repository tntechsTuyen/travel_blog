package com.travel.server.service.impl;

import com.travel.server.config.security.JwtUserDetailsService;
import com.travel.server.entity.Comment;
import com.travel.server.entity.Media;
import com.travel.server.entity.User;
import com.travel.server.repository.CommentRepository;
import com.travel.server.service.ICommentService;
import com.travel.server.service.IMediaService;
import com.travel.server.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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

    @Autowired
    private IMediaService mediaService;

    @Override
    public List<Map<String, Object>> findByIdPost(Integer idPost) {
        return commentRepository.findByIdPost(idPost);
    }

    @Override
    public Map<String, Object> commentPost(Integer idPost, Integer idParent, String content, MultipartFile file) {
        User user = userDetailsService.getUserLogin();
        Comment comment = new Comment();
        comment.setIdPost(idPost);
        comment.setContent(content);
        comment.setIdParent(idParent);
        comment.setIdUser(user.getId());
        if(file != null){
            Media media = mediaService.upload(file);
            comment.setIdMedia(media.getId());
        }

        return save(comment);
    }

    @Override
    public Map<String, Object> save(Comment comment) {
        try{
            commentRepository.save(comment);
            postService.comment(comment.getIdPost());
            return commentRepository.findByIdCmt(comment.getId());
        }catch (Exception e){

        }
        return null;
    }
}
