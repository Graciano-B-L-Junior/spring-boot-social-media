package com.social_network_project.social.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.social_network_project.social.Models.User;
import com.social_network_project.social.Repository.UserRepository;


@Service
public class UserServiceImplementation implements UserService {


    @Autowired
    UserRepository userRepository;

    @Override
    public User registUser(User user) {
        User newUser = new User(user.getId(), user.getFirstName(), 
                                user.getLastName(), user.getEmail(), 
                                user.getPassword(), user.getGender(), 
                                user.getFollowing(), user.getFollowing());
        User savedUser = userRepository.save(newUser);

        return savedUser;
    }

    @Override
    public User findUserById(int id) throws Exception {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        }
        throw new Exception("User not found");
    }

    @Override
    public User findUserByEmail(String email) {
        
        User user = userRepository.findByEmail(email);

        return user;
    }

    @Override
    public User followUser(int userId, int followUserId) throws Exception {
        
        Optional<User> user1 = userRepository.findById(userId);

        Optional<User> user2 = userRepository.findById(followUserId);
        if (user1.isPresent() && user2.isPresent()) {
            User user = user1.get();
            User followUser = user2.get();

            List<Integer> following = user.getFollowing();
            List<Integer> followers = followUser.getFollowers();

            if (!following.contains(followUserId)) {
                following.add(followUserId);
                user.setFollowing(following);
                userRepository.save(user);
            }

            if (!followers.contains(userId)) {
                followers.add(userId);
                followUser.setFollowing(followers);
                userRepository.save(followUser);
            }

            return user;
        }
        else
        {
            throw new Exception("User not found");
        }
    }

    @Override
    public User updateUser(User user, int id) throws Exception {
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
            if(user.getGender() != null)
                updatedUser.setGender(user.getGender());
            if(user.getFollowers() != null)
                updatedUser.setFollowers(user.getFollowers());
            if(user.getFollowing() != null)
                updatedUser.setFollowing(user.getFollowing());
            userRepository.save(updatedUser);
            return updatedUser;
        }
        else
        {
            throw new Exception("User not found");
        }
    }

    @Override
    public List<User> searchUser(String query) {
        
        List<User> users = userRepository.search(query);

        return users;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users;
    }

}
