package com.social_network_project.social.Models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String caption;

    private String image;

    private String video;

    @ManyToOne
    private User user;

    private LocalDateTime createdAt = LocalDateTime.now();

    @OneToMany
    private List<User> likes = new ArrayList<>();

    public Post(Integer id, String caption, String image, String video, User user) {
        this.id = id;
        this.caption = caption;
        this.image = image;
        this.video = video;
        this.user = user;
        this.createdAt = LocalDateTime.now();
    }
    public Post() {
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public List<User> getLikes()
    {
        return likes;
    }

    public void setLikes(List<User> likes)
    {
        this.likes = likes;
    }

    public List<User> getAllLikes() {
        return likes;
    }

    public void addLike(User user_liked) {
        this.likes.add(user_liked);
    }
    
    public void removeLike(User user_liked) {
        this.likes.remove(user_liked);
    }

}
