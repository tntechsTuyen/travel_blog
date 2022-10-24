package com.travel.server.controller.api;

import com.travel.server.common.response.ApiResponse;
import com.travel.server.entity.Comment;
import com.travel.server.entity.PostUser;
import com.travel.server.service.ICommentService;
import com.travel.server.service.IFileService;
import com.travel.server.service.IPostService;
import com.travel.server.service.ITravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
     * @param idPost,idParent,content,file
     * */
    @PostMapping("/comment")
    public ApiResponse<?> postComment(@RequestParam("id_post") Integer idPost
            , @RequestParam(value = "id_parent") Integer idParent
            , @RequestParam("content") String content
            , @RequestParam(value = "file") MultipartFile file){
        return ApiResponse.of(HttpStatus.OK, ApiResponse.Code.SUCCESS, "Load data successful", commentService.commentPost(idPost, idParent, content, file));
    }

    /**
     * @param postUser {isLike}
     * */
    @PostMapping("/like")
    public ApiResponse<?> postLike(@RequestBody PostUser postUser){
        return ApiResponse.of(HttpStatus.OK, ApiResponse.Code.SUCCESS, "", postService.like(postUser));
    }

    /**
     * @param postUser {rate}
     * */
    @PostMapping("/rate")
    public ApiResponse<?> postRate(@RequestBody PostUser postUser){
        return ApiResponse.of(HttpStatus.OK, ApiResponse.Code.SUCCESS, "Load data successful", postService.rate(postUser));
    }
}
