package com.social_network_project.social.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social_network_project.social.Models.Post;
import com.social_network_project.social.Models.User;
import com.social_network_project.social.Repository.UserRepository;
import com.social_network_project.social.Repository.postRepository;

@Service
public class PostServiceImplementation implements PostService {

    @Autowired
    postRepository postRepository;

    @Autowired
    UserService userService;

    @Override
    public Post createNewPost(Post post, Integer userId) throws Exception {
        
        Post newPost = new Post();
        newPost.setCaption(post.getCaption());
        newPost.setImage(post.getImage());
        newPost.setVideo(post.getVideo());
        newPost.setUser(userService.findUserById(userId));
        return newPost;

    }

    @Override
    public String deletePost(Integer postId, Integer userId) throws Exception {
        Optional<Post> post = postRepository.findById(postId);
        User user = userService.findUserById(userId);
        if (post.isPresent() && user != null && post.get().getUser().getId() == userId) {
            postRepository.delete(post.get());
            return "Post deleted successfully";
        } else {
            throw new Exception("Operation can't be performed");
        }
    }

    @Override
    public List<Post> findPostByUserId(Integer userId) throws Exception {
        
        
        List<Post> posts = postRepository.findByUserId(userId);
        if (posts.isEmpty()) {
            throw new Exception("No posts found for this user");
        }
        return posts;
    }

    @Override
    public Post findPostById(Integer postId) throws Exception {
        Optional<Post> post = postRepository.findById(postId);
        if (post.isPresent()) {
            return post.get();
        } else {
            throw new Exception("Post not found");
        }
    }

    @Override
    public List<Post> findAllPosts() throws Exception {
        
        List<Post> posts = postRepository.findAll();
        if (posts.isEmpty()) {
            throw new Exception("No posts found");
        }
        return posts;
    }

    @Override
    public Post savedPost(Integer postId, Integer userId) throws Exception {
        User user = userService.findUserById(userId);
        Optional<Post> post = postRepository.findById(postId);
        if (post.isPresent()){
            Post postToSave = post.get();
            if(user.getSavedPosts().contains(postToSave)){
                user.getSavedPosts().remove(postToSave);
            }
            else{
                user.getSavedPosts().add(postToSave);
            }
            userService.updateUser(user, userId);
            return postToSave;
        }
        return null;

    }

    @Override
    public Post likePost(Integer postId, Integer userId) throws Exception {
        
        Optional<Post> post = postRepository.findById(postId);
        User user = userService.findUserById(userId);
        if(post.isPresent()){
            Post postToLike = post.get();
            if(postToLike.getAllLikes().contains(user)){
                postToLike.getAllLikes().remove(user);
        }
            else{
                postToLike.getAllLikes().add(user);
            }
            postRepository.save(postToLike);
            return postToLike;
        }
        else{
            throw new Exception("Post not found");
        }
    }

}
