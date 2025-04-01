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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.social_network_project.social.Models.User;
import com.social_network_project.social.Repository.UserRepository;
import com.social_network_project.social.Service.UserService;
import com.social_network_project.social.Service.UserServiceImplementation;

import org.springframework.beans.factory.annotation.Autowired;



@RestController
public class UserController {

    @Autowired
    private
    UserService userService;

    @GetMapping("/users")
    public List<User> getUsers() {
        List<User> users = userService.getAllUsers();
        return users;
    }

    @GetMapping("/users/{userID}")
    public User getUserByID(@PathVariable("userID") int id) throws Exception
    {
        User user = userService.findUserById(id);
        
        return user;

    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user)
    {
        User new_user = userService.registUser(user);
        return new_user;
    }

    @PutMapping("/users/{userID}")
    public User updateUser(@RequestBody User user,@PathVariable("userID") int id) throws Exception
    {
        
        User updated_user = userService.updateUser(user, id);
        
        return updated_user;
    }

    public User followUserHandle(@PathVariable("userID") int userId, @PathVariable("followUserID") int followUserId) throws Exception
    {
        User user = userService.followUser(userId, followUserId);
        return user;
    }

    @GetMapping("/users/search")
    public List<User> searchUser(@RequestParam("query") String query)
    {
        List<User> users = userService.searchUser(query);
        return users;
    }
}
