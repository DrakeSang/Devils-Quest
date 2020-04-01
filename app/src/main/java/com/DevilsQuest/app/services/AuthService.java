package com.DevilsQuest.app.services;

import com.DevilsQuest.app.data.models.services.auth.RegisterUserServiceModel;

public interface AuthService {
    /**
     * Method for registering the user after we made all fo the necessary validations.
     * 
     * @param serviceModel object of type {@link RegisterUserServiceModel}
     */
    void register(RegisterUserServiceModel serviceModel);
}