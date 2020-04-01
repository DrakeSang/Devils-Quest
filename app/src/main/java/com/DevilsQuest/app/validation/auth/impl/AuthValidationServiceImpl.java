package com.DevilsQuest.app.validation.auth.impl;

import com.DevilsQuest.app.data.models.services.auth.RegisterUserServiceModel;
import com.DevilsQuest.app.data.repositories.UsersRepository;
import com.DevilsQuest.app.validation.auth.AuthValidationService;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service
public class AuthValidationServiceImpl implements AuthValidationService {
    private final UsersRepository usersRepository;

    public AuthValidationServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public boolean isValid(RegisterUserServiceModel user, ModelAndView modelAndView) {
        return
                isUsernameFree(user.getUsername(), modelAndView) &&
                isEmailFree(user.getEmail(), modelAndView) &&
                arePasswordsEquals(user.getPassword(), user.getConfirmPassword(), modelAndView);
    }

    /**
     * Method for checking if the entered username is free.
     * 
     * @param username the username to check for in our db
     * @param modelAndView the modelAndView, which i will use if the username is taken to add specific message
     * @return true if the username is free, otherwise false if the username is not free
     */
    private boolean isUsernameFree(String username, ModelAndView modelAndView) {
        boolean isUsernameFree = !usersRepository.existsByUsername(username);
        
        if(!isUsernameFree) {
            modelAndView.addObject("existedUsername", "This username is unavailable.");
        }

        return isUsernameFree;
    }

    /**
     * Method for checking if the entered email is free.
     * 
     * @param email the email to check for in the db
     * @param modelAndView the modelAndView, which i will use if the email is taken to add specific message
     * @return true if the email is free, otherwise false if not
     */
    private boolean isEmailFree(String email, ModelAndView modelAndView) {
        boolean isEmailFree = !usersRepository.existsByEmail(email);
        
        if(!isEmailFree) {
            modelAndView.addObject("existedEmail", "This email is unavailable.");
        }

        return isEmailFree;
    }

    /**
     * Method for checking if the two passwords are valid.
     * 
     * @param password the initial password of the user
     * @param confirmPassword the confirmed password of the user
     * @param modelAndView the modelAndView, which i will use if the two passwords are not equals to add specific message
     * @return true if the two passwords are equal, otherwise false if not
     */
    private boolean arePasswordsEquals(String password, String confirmPassword, ModelAndView modelAndView) {
        boolean arePasswordsEquals = password.equals(confirmPassword);

        if(!arePasswordsEquals) {
            modelAndView.addObject("passwordsNotEquals", "The passwords are not equals.");
        }

        return arePasswordsEquals;
    }
}