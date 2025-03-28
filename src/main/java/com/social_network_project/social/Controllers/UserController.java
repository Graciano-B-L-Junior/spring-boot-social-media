package com.social_network_project.social.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping("/users")
    public ResponseEntity<?> createUser(@RequestBody User user)
    {
        User newUser = new User(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword());
        
        System.out.println("User created: " + newUser.getFirstName() + " " + newUser.getLastName());

        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    @PutMapping("/users")
    public ResponseEntity<?> updateUser(@RequestBody User user)
    {
        List<User> users = new ArrayList<>();
        User aux = new User(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword());

        User user1 = new User(1,"code","test","email@email.com", "password");
        User user2 = new User(2,"crok","test2","email2@email.com", "password2");
        users.add(user1);
        users.add(user2);

        for (User aux_user : users) {
            if(aux_user.getId() == aux.getId())
            {
                if(aux.getFirstName() != null)
                {
                    aux_user = new User(aux.getId(), aux.getFirstName(), aux_user.getLastName(), aux_user.getEmail(), aux_user.getPassword());
                }
                if(aux.getLastName() != null)
                {
                    aux_user = new User(aux.getId(), aux_user.getFirstName(), aux.getLastName(), aux_user.getEmail(), aux_user.getPassword());
                }
                if(aux.getEmail() != null)
                {
                    aux_user = new User(aux.getId(), aux_user.getFirstName(), aux_user.getLastName(), aux.getEmail(), aux_user.getPassword());
                }
                if(aux.getPassword() != null)
                {
                    aux_user = new User(aux.getId(), aux_user.getFirstName(), aux_user.getLastName(), aux_user.getEmail(), aux.getPassword());
                }
                return ResponseEntity.ok(aux_user);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
    }

    @DeleteMapping("/users/{userID}")
    public ResponseEntity<?> deleteUser(@PathVariable("userID") int id) {
        List<User> users = new ArrayList<>();
        
        User user1 = new User(1, "code", "test", "email@email.com", "password");
        User user2 = new User(2, "crok", "test2", "email2@email.com", "password2");
        users.add(user1);
        users.add(user2);

        for (User user : users) {
            if (user.getId() == id) {
                users.remove(user);
                return ResponseEntity.ok("User with ID " + id + " has been deleted.");
            }
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
    }
}
