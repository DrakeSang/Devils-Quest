package com.DevilsQuest.app.validation.auth;

import com.DevilsQuest.app.data.models.services.auth.RegisterUserServiceModel;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

public interface AuthValidationService {
    /**
     * Method for validating object of type {@link RegisterUserServiceModel} and object of type {@link MultipartFile}
     * 
     * @param user object of type {@link RegisterUserServiceModel}
     * @param multipartFile object of type {@link MultipartFile}
     * @param modelAndView object of type {@link ModelAndView} so i can add different type of error messages
     * @return
     */
    boolean isValid(RegisterUserServiceModel user, MultipartFile multipartFile, ModelAndView modelAndView);
}