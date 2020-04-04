package com.DevilsQuest.app.services.impl.users;

import java.util.List;
import java.util.Optional;

import com.DevilsQuest.app.data.entities.auth.Role;
import com.DevilsQuest.app.data.entities.auth.User;
import com.DevilsQuest.app.data.models.services.heroes.HeroCreateServiceModel;
import com.DevilsQuest.app.data.repositories.UsersRepository;
import com.DevilsQuest.app.services.HeroesService;
import com.DevilsQuest.app.services.UsersService;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {
    private final HeroesService heroesService;

    private final UsersRepository usersRepository;

    public UsersServiceImpl(HeroesService heroesService, UsersRepository usersRepository) {
        this.heroesService = heroesService;
        this.usersRepository = usersRepository;
    }

    @Override
    public int getHeroCount(String username) {
        Optional<User> userResult = usersRepository.findByUsername(username);
        User user = userResult.get();

        return user.getHeroes().size();
    }

    @Override
    public void createHeroForUser(HeroCreateServiceModel heroCreateServiceModel) {
        heroesService.create(heroCreateServiceModel);
    }

    /**
     * This methods comes from spring security. When you implement some class {@link UsersService}, which imp-
     * lements {@link UserDetailsService} you need to override this method. It triggers every time a user tries 
     * to login and you set the username, password and authorities. That way in the principal you will have this 
     * after successfull login.
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userResult = usersRepository.findByUsername(username);

        if (!userResult.isEmpty()) {
            User user = userResult.get();

            List<Role> authorities = user.getAuthorities();

            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                    authorities);
        } else {
            throw new UsernameNotFoundException("No user found");
        }
    }
}