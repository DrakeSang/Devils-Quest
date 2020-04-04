package com.DevilsQuest.app.services;

import javax.servlet.http.HttpServletRequest;

import com.DevilsQuest.app.data.models.services.heroes.HeroCreateServiceModel;

public interface HeroesService {
    /**
     * Method for setting attribute in the session with key heroesCount and value teh count of the heroes a user
     * has. I use this method in two places when user logges in successfully and after creating a hero so i can 
     * change dynamiclly the header links. I extracted it in method, bacause i use teh same logic on two places
     * and i did not want to have a repating code.
     * 
     * @param httpServletRequest the http servlet request from the request i send after psoting some form. From
     * there i can get the session and add the attribute i want.
     */
    void setHeroesCountByUsernameOfUser(HttpServletRequest httpServletRequest);

    /**
     * Method for creating hero for the user
     * 
     * @param serviceModel object of type {@link HeroDetailsServiceModel}
     */
    void create(HeroCreateServiceModel heroCreateServiceModel);
}