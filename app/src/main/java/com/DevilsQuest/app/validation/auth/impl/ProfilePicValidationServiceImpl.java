package com.DevilsQuest.app.validation.auth.impl;

import java.util.HashSet;
import java.util.Set;

import com.DevilsQuest.app.validation.auth.ProfilePicValidationService;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Service
public class ProfilePicValidationServiceImpl implements ProfilePicValidationService {
    @Override
    public boolean isValid(MultipartFile multipartFile, ModelAndView modelAndView) {
        return 
                isSizeCorrect(multipartFile.getSize(), modelAndView) && 
                isExtensionAllowed(FilenameUtils.getExtension(multipartFile.getOriginalFilename()), modelAndView);
    }

    private boolean isSizeCorrect(Long size, ModelAndView modelAndView) {
        boolean hasCorrectSize = true;
        
        if(size >= 500000) {
            hasCorrectSize = false;
            modelAndView.addObject("wrongPictureSize", "Your profile picture is too big.");
        }

        return hasCorrectSize;
    }

    private boolean isExtensionAllowed(String fileExtension, ModelAndView modelAndView) {
        HashSet<String> allowedExtension = new HashSet<>(Set.of("jpg", "jpeg", "png"));

        boolean isExtensionValid = true;

        if(!allowedExtension.contains(fileExtension)) {
            isExtensionValid = false;
            modelAndView.addObject("invalidExtension", "Your profile pic extension is not correct.");
        }

        return isExtensionValid;
    }
}