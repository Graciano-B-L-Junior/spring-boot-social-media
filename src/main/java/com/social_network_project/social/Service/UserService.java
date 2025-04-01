package com.social_network_project.social.Service;

import java.util.List;

import com.social_network_project.social.Models.User;

public interface UserService {

    public List<User> getAllUsers();

    public User registUser(User user);

    public User findUserById(int id) throws Exception;

    public User findUserByEmail(String email);

    public User followUser(int userId, int followUserId) throws Exception;

    public User updateUser(User user,int id) throws Exception;

    public List<User> searchUser(String query);


}
