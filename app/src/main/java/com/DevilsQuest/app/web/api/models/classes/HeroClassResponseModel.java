package com.DevilsQuest.app.web.api.models.classes;

public class HeroClassResponseModel {
    private String imageUrl;
    
    private String overview;

    public HeroClassResponseModel() {
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getOverview() {
        return this.overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }
}