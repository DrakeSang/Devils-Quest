package com.DevilsQuest.app.services.impl;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import com.DevilsQuest.app.data.entities.auth.User;
import com.DevilsQuest.app.data.repositories.UsersRepository;
import com.DevilsQuest.app.services.UsersService;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {
    private final UsersRepository usersRepository;

    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    /**
     * This methods comes from spring security. When you implement some class {@link UsersService} which implements
     * {@link UserDetailsService} you need to override this method. It triggers every time a user tries to login and
     * you set the username, password and authorities. That way in the principal you will have this after successfull 
     * login. DO not forget to insert roles in your db.
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userResult = usersRepository.findByUsername(username);

        User user = userResult.get();

        if (user == null) {
            throw new UsernameNotFoundException("No user found with username: " + username);
        }

        Set<GrantedAuthority> authorities = new HashSet<>(user.getAuthorities());

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                authorities
        );
    }    
}