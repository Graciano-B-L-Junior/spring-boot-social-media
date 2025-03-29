package com.social_network_project.social.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.social_network_project.social.Models.User;

public interface UserRepository extends JpaRepository<User,Integer> {

}
