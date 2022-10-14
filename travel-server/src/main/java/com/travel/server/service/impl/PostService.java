package com.travel.server.service.impl;

import com.travel.server.entity.Post;
import com.travel.server.entity.PostUser;
import com.travel.server.repository.PostRepository;
import com.travel.server.repository.PostUserRepository;
import com.travel.server.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService implements IPostService {

    @Autowired
    private PostUserRepository postUserRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public PostUser read(Integer idPost, Integer idUser) {
        PostUser postUser = postUserRepository.findByIdPostAndIdUser(idPost, idUser);
        if(postUser == null) {
            postUser = new PostUser();
            postUser.setIdPost(idPost);
            postUser.setIdUser(idUser);
            postUser.setIsRead(1);
            postUserRepository.save(postUser);

            Optional<Post> opPost = postRepository.findById(idPost);
            Post post = opPost.get();
            post.setTotalView(post.getTotalView() + 1);
            postRepository.save(post);
        }
        return postUser;
    }

    @Override
    public PostUser like(Integer idPost, Integer idUser) {
        PostUser postUser = postUserRepository.findByIdPostAndIdUser(idPost, idUser);
        if(postUser == null) {
            postUser = new PostUser();
            postUser.setIdPost(idPost);
            postUser.setIdUser(idUser);
        }

        if(postUser.getIsLike() == 0){
            postUser.setIsLike(1);
            postUserRepository.save(postUser);
            Optional<Post> opPost = postRepository.findById(idPost);
            Post post = opPost.get();
            post.setTotalLike(post.getTotalLike() + 1);
            postRepository.save(post);
        }
        return postUser;
    }

    @Override
    public PostUser rate(PostUser mPostUser) {
        PostUser postUser = postUserRepository.findByIdPostAndIdUser(mPostUser.getIdPost(), mPostUser.getIdUser());
        if(postUser == null) {
            postUser = new PostUser();
            postUser.setIdPost(mPostUser.getIdPost());
            postUser.setIdUser(mPostUser.getIdUser());
        }
        if(postUser.getRate() == 0){
            postUser.setRate(mPostUser.getRate());
            postUserRepository.save(postUser);
            Optional<Post> opPost = postRepository.findById(mPostUser.getIdPost());
            Post post = opPost.get();
            post.setTotalLike(post.getTotalLike() + 1);
            postRepository.save(post);
//            postUserRepository.updatePostRatePoint(idPost);
        }
        return postUser;
    }

    @Override
    public void comment(Integer idPost) {
        Optional<Post> opPost = postRepository.findById(idPost);
        Post post = opPost.get();
        post.setTotalComment(post.getTotalComment() + 1);
        postRepository.save(post);
    }
}
