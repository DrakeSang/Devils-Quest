package com.DevilsQuest.app.services;

import com.DevilsQuest.app.data.models.services.heroes.HeroCreateServiceModel;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UsersService extends UserDetailsService {
    /**
     * Method for getting the count of the heroes the user created. I need it because i will restrict the user ha-
     * ving max 10 heroes.
     * 
     * @param username the username of the user
     * @return the count of the heroes he has for that username
     */
    int getHeroCount(String username);

    /**
     * Method for creating hero for the user.
     * 
     * @param heroCreateServiceModel object of type {@link HeroCreateServiceModel}
     */
    void createHeroForUser(HeroCreateServiceModel heroCreateServiceModel);
}