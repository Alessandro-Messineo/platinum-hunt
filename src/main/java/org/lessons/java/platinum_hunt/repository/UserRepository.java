package org.lessons.java.platinum_hunt.repository;

import java.util.Optional;

import org.lessons.java.platinum_hunt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer>{

    Optional<User> findByUsername(String username);
    
}