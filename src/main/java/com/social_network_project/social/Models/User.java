package com.social_network_project.social.Models;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName = null;
    private String lastName = null;
    private String email = null;
    private String password = null;

    private String gender = null;

    @ManyToAny
    private List<User> followers = new ArrayList<>();

    @ManyToAny
    private List<User> following = new ArrayList<>();

    @ManyToMany
    private List<Post> savedPosts = new ArrayList<>();


    public User() {
        this.id = null;
        this.firstName = null;
        this.lastName = null;
        this.email = null;
        this.password = null;
    }
    public User(Integer Id, String firstName, String lastName, 
                String email, String password, String gender, 
                List<User> followers, List<User> following) {
        this.id = Id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.followers = followers;
        this.following = following;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getGender() {

        return this.gender;
    }
    public List<User> getFollowing() {
        return this.following;
    }

    public List<User> getFollowers() {
        return this.followers;
    }

    public void setFollowing(List<User> following) {
        this.following = following;
    }

    public void setFollowers(List<User> followers) {
        this.followers = followers;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<Post> getSavedPosts() {
        return savedPosts;
    }
    public void setSavedPosts(List<Post> savedPosts) {
        this.savedPosts = savedPosts;
    }
}
