package com.DevilsQuest.app.services;

import org.springframework.security.core.Authentication;

// source: https://www.baeldung.com/get-user-in-spring-security
public interface AuthenticatedUserService {
    /**
     * Getting the username of the user trying to log in.
     *    
     * @return the username of the currently logged in user
     */
    String getUsername();

    /**
     * Method for getting the authentication of the currently logged in user
     * 
     * @return object of type {@link Authentication}
     */
    Authentication getAuthentication();
}