package com.social_network_project.social.Controllers;

import java.util.List;
import java.util.Optional;

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
import com.social_network_project.social.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;



@RestController
public class UserController {

    @Autowired
    private
    UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getUsers() {
        List<User> users = userRepository.findAll();
        return users;
    }

    @GetMapping("/users/{userID}")
    public ResponseEntity<?> getUserByID(@PathVariable("userID") int id)
    {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");

    }

    @PostMapping("/users")
    public ResponseEntity<?> createUser(@RequestBody User user)
    {
        User newUser = new User(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword());
        User savedUser = userRepository.save(newUser);

        System.out.println("User created: " + savedUser.getFirstName() + " " + savedUser.getLastName());

        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    @PutMapping("/users/{userID}")
    public ResponseEntity<?> updateUser(@RequestBody User user,@PathVariable("userID") int id)
    {
        Optional<User> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            User updatedUser = existingUser.get();
            if(user.getFirstName() != null)
                updatedUser.setFirstName(user.getFirstName());
            if(user.getLastName() != null)
                updatedUser.setLastName(user.getLastName());
            if(user.getEmail() != null)
                updatedUser.setEmail(user.getEmail());
            if(user.getPassword() != null)
                updatedUser.setPassword(user.getPassword());
            if(user.getId() != null)
                updatedUser.setId(user.getId());
            userRepository.save(updatedUser);
            return ResponseEntity.ok(updatedUser);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
    }

    @DeleteMapping("/users/{userID}")
    public ResponseEntity<?> deleteUser(@PathVariable("userID") int id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.delete(user.get());
            return ResponseEntity.ok("User deleted successfully");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
    }
}
