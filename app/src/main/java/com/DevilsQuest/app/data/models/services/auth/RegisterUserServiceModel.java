package com.DevilsQuest.app.data.models.services.auth;

public class RegisterUserServiceModel {
    private String username;

    private String email;

    private String imageUrl;

    private String password;

    private String confirmPassword;    

    public RegisterUserServiceModel() {
    }

    public RegisterUserServiceModel(String username, String email, String imageUrl, String password, String confirmPassword) {
        this.username = username;
        this.email = email;
        this.imageUrl = imageUrl;
        this.password = password;
        this.confirmPassword = confirmPassword;
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

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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