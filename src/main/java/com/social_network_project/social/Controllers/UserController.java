package com.social_network_project.social.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.social_network_project.social.Models.User;

@RestController
public class UserController {

    @GetMapping("/users")
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        
        User user = new User(1,"code","test","email@email.com", "password");
        User user2 = new User(2,"crok","test2","email2@email.com", "password2");
        users.add(user);
        users.add(user2);

        

        return users;
    }

    @GetMapping("/users/{userID}")
    public ResponseEntity<?> getUserByID(@PathVariable("userID") int id)
    {
        List<User> users = new ArrayList<>();
        
        User user = new User(1,"code","test","email@email.com", "password");
        User user2 = new User(2,"crok","test2","email2@email.com", "password2");
        users.add(user);
        users.add(user2);

        for (User user1 : users) {
            if(user1.getId() == id)
            {
                return ResponseEntity.ok(user1);
            }
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");

    }
}
