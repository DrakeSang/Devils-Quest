package com.DevilsQuest.app.validation.auth;

import com.DevilsQuest.app.data.models.services.auth.RegisterUserServiceModel;

import org.springframework.web.servlet.ModelAndView;

public interface AuthValidationService {
    /**
     * Method for validating object of type {@link RegisterUserServiceModel}
     * 
     * @param user object of type {@link RegisterUserServiceModel}
     * @return true if the model is valid, otherwise returns false
     */
    boolean isValid(RegisterUserServiceModel user, ModelAndView modelAndView);
}