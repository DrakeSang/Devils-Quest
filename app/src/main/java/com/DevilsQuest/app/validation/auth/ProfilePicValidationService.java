package com.DevilsQuest.app.validation.auth;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

public interface ProfilePicValidationService {
    /**
     * Method for validating the profiel pic on register process(size, extension, etc...)
     * 
     * @param multipartFile objetc of type {@link MultipartFile}
     * @return true if it is valid otherwise false it is not valid
     */
    boolean isValid(MultipartFile multipartFile, ModelAndView modelAndView);
}