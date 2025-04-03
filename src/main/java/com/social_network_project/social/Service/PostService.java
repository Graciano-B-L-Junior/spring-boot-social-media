package com.social_network_project.social.Service;

import java.util.List;

import com.social_network_project.social.Models.Post;

public interface PostService {

    Post createNewPost(Post post,Integer userId) throws Exception;

    String deletePost(Integer postId,Integer userId) throws Exception;

    List<Post> findPostByUserId(Integer userId) throws Exception;

    Post findPostById(Integer postId) throws Exception;

    List<Post> findAllPosts() throws Exception;

    Post savedPost(Integer postId, Integer userId) throws Exception;

    Post likePost(Integer postId, Integer userId) throws Exception;
}
