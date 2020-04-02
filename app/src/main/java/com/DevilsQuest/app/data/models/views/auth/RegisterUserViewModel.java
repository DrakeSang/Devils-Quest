package com.DevilsQuest.app.data.models.views.auth;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.DevilsQuest.app.validation.auth.custom.Email;

import org.springframework.web.multipart.MultipartFile;

public class RegisterUserViewModel {
    @Size(min = 3, max = 15, message = "Username should be between 3 and 15.")
    private String username;

    @Email
    private String email;

    private MultipartFile image;
    
    @NotEmpty(message = "The password is mandatory.")
    private String password;
    
    @NotEmpty(message = "The confirm password is mandatory.")
    private String confirmPassword;

    public RegisterUserViewModel() {
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

    public MultipartFile getImage() {
        return this.image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
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