package com.DevilsQuest.app.data.models.views.auth;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.DevilsQuest.app.validation.auth.custom.Email;

public class RegisterUserModel {
    @Size(min = 3, max = 15, message = "Username should be between 3 and 15.")
    private String username;

    @Email
    private String email;
    
    @NotEmpty(message = "The password is mandatory.")
    private String password;
    
    @NotEmpty(message = "The confirm password is mandatory.")
    private String confirmPassword;

    public RegisterUserModel() {
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return this.confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}