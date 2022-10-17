package com.travel.server.controller.api;

import com.travel.server.common.response.ApiResponse;
import com.travel.server.entity.Comment;
import com.travel.server.entity.PostUser;
import com.travel.server.service.ICommentService;
import com.travel.server.service.IPostService;
import com.travel.server.service.ITravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/post")
public class ApiPostController {

    @Autowired
    private ICommentService commentService;

    @Autowired
    private IPostService postService;


    @GetMapping("/{id}")
    public ApiResponse<?> get(@PathVariable("id") Integer id){
        return ApiResponse.of(HttpStatus.OK, ApiResponse.Code.SUCCESS, "Load data successful", null);
    }

    @GetMapping("/{id_post}/comments")
    public ApiResponse<?> comments(@PathVariable("id_post") Integer idPost){
        return ApiResponse.of(HttpStatus.OK, ApiResponse.Code.SUCCESS, "Load data successful", commentService.findByIdPost(idPost));
    }

    /**
     * @param comment {idPost, content}
     * */
    @PostMapping("/comment")
    public ApiResponse<?> postComment(@RequestBody Comment comment){
        return ApiResponse.of(HttpStatus.OK, ApiResponse.Code.SUCCESS, "Load data successful", commentService.save(comment));
    }

    /**
     * @param postUser {isLike}
     * */
    @PostMapping("/like")
    public ApiResponse<?> postLike(@RequestBody PostUser postUser){
        return ApiResponse.of(HttpStatus.OK, ApiResponse.Code.SUCCESS, "Load data successful", postService.like(postUser));
    }

    /**
     * @param postUser {rate}
     * */
    @PostMapping("/rate")
    public ApiResponse<?> postRate(@RequestBody PostUser postUser){
        return ApiResponse.of(HttpStatus.OK, ApiResponse.Code.SUCCESS, "Load data successful", postService.rate(postUser));
    }

}
