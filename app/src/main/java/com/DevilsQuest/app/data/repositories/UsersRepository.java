package com.DevilsQuest.app.data.repositories;

import java.util.Optional;

import com.DevilsQuest.app.data.entities.auth.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<User, Long> {
    /**
     * Returns {@link Optional} of object {@link User} by given username 
     * 
     * @param username the username to search for
     * @return {@link Optional} of  object {@link User}
     */
    Optional<User> findByUsername(String username);  

    /**
     * Check if user exists 
     * 
     * @param username the username to search for
     * @return boolen true if exists, otherwise return false 
     */
    boolean existsByUsername(String username);

    /**
     * Check if email exists
     * 
     * @param email the email to search for
     * @return boolen true if exists, otherwise return false
     */
    boolean existsByEmail(String email);  
}