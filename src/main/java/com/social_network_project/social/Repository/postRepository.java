package com.social_network_project.social.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.social_network_project.social.Models.Post;

public interface postRepository extends JpaRepository<Post, Integer> {
    // This interface will automatically provide CRUD operations for the Post entity
    // You can add custom query methods here if needed
    @Query("SELECT p FROM Post p WHERE p.user.id =:userId")
    List<Post> findByUserId(@Param("userId")Integer userId);
    
}
