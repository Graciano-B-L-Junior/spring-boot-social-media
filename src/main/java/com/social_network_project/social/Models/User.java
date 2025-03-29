package com.social_network_project.social.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    @Id
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
}
