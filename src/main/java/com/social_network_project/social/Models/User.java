package com.social_network_project.social.Models;


public class User {

    private Integer id;
    private String firstName = null;
    private String lastName = null;
    private String email = null;
    private String password = null;

    public User() {
        this.id = null;
        this.firstName = null;
        this.lastName = null;
        this.email = null;
        this.password = null;
    }
    public User(Integer Id, String firstName, String lastName, String email, String password) {
        this.id = Id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
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
}
