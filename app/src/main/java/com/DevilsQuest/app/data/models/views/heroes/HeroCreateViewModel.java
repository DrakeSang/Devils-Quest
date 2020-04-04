package com.DevilsQuest.app.data.models.views.heroes;

import javax.validation.constraints.NotEmpty;

public class HeroCreateViewModel {
    @NotEmpty(message = "The faction can not be empty.")
    private String faction;
    
    @NotEmpty(message = "The race can not be empty.")
    private String race;

    @NotEmpty(message = "The gender can not be empty.")
    private String gender;

    @NotEmpty(message = "The class can not be empty.")
    private String characterClass;

    @NotEmpty(message = "The name can not be empty.")
    private String name;

    public HeroCreateViewModel() {
    }

    public String getFaction() {
        return this.faction;
    }

    public void setFaction(String faction) {
        this.faction = faction;
    }    

    public String getRace() {
        return this.race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCharacterClass() {
        return this.characterClass;
    }

    public void setCharacterClass(String characterClass) {
        this.characterClass = characterClass;
    }    

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}