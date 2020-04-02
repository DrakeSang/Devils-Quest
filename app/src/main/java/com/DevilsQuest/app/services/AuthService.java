package com.DevilsQuest.app.services;

import java.io.IOException;

import com.DevilsQuest.app.data.models.services.auth.RegisterUserServiceModel;

import org.springframework.web.multipart.MultipartFile;

public interface AuthService {
    /**
     * Method for registering the user after we made all fo the necessary validations.
     * 
     * @param serviceModel object of type {@link RegisterUserServiceModel}
     * @param profilePic object of type {@link MultipartFile}
     * @throws IOException
     */ 
    void register(RegisterUserServiceModel serviceModel, MultipartFile profilePic) throws IOException;
}