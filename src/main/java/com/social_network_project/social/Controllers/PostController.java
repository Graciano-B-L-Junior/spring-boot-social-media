package com.social_network_project.social.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.social_network_project.social.Models.Post;
import com.social_network_project.social.Service.PostService;

@RestController
public class PostController {

    @Autowired
    PostService postService;


    @PostMapping("/posts/user/{userId}")
    public ResponseEntity<Post> createNewPost(@RequestBody Post post,@PathVariable("userId") Integer userId) throws Exception {
        Post created_Post = postService.createNewPost(post, userId);
        return new ResponseEntity<Post>(created_Post,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/posts/{postId}/user/{userId}")
    public ResponseEntity<String> deletePost(@PathVariable("postId") Integer postId,@PathVariable("userId") Integer userId) throws Exception {
        String response = postService.deletePost(postId, userId);
        return new ResponseEntity<String>(response,HttpStatus.ACCEPTED);
    }

    @GetMapping("/posts/{postId}")
    public ResponseEntity<Post> findPostByIdHandler(@PathVariable("postId") Integer postId) throws Exception {
        Post post = postService.findPostById(postId);
        return new ResponseEntity<Post>(post,HttpStatus.ACCEPTED);
    }

    @GetMapping("/posts/user/{userId}")
    public ResponseEntity<List<Post>> findUserPost(@PathVariable("userId") Integer userId) throws Exception {
        List<Post> posts = postService.findPostByUserId(userId);
        return new ResponseEntity<List<Post>>(posts,HttpStatus.ACCEPTED);
    }

    @PutMapping("/posts/{postId}/user/{userId}")
    public ResponseEntity<Post> updatePostHandler(@PathVariable("postId") Integer postId,@PathVariable("userId") Integer userId) throws Exception {
        Post post = postService.savedPost(postId, userId);

        return new ResponseEntity<Post>(post,HttpStatus.ACCEPTED);
    }

    @PutMapping("/posts/like/{postId}/user/{userId}")
    public ResponseEntity<Post> likePostHandler(@PathVariable("postId") Integer postId,@PathVariable("userId") Integer userId) throws Exception {
        Post post = postService.likePost(postId, userId);

        return new ResponseEntity<Post>(post,HttpStatus.ACCEPTED);
    }


}
