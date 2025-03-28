package com.social_network_project.social.Models;


public class User {

    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public User() {

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
