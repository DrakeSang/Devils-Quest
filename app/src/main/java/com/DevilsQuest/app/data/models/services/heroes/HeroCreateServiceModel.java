package com.DevilsQuest.app.data.models.services.heroes;

import com.DevilsQuest.app.data.enums.CharacterClass;
import com.DevilsQuest.app.data.enums.FactionName;
import com.DevilsQuest.app.data.enums.GenderName;
import com.DevilsQuest.app.data.enums.RaceName;

public class HeroCreateServiceModel {
    private FactionName faction;
    
    private RaceName race;

    private GenderName gender;

    private CharacterClass characterClass;

    private String name;

    public HeroCreateServiceModel() {
    }    

    public FactionName getFaction() {
        return this.faction;
    }

    public void setFaction(FactionName faction) {
        this.faction = faction;
    }

    public RaceName getRace() {
        return this.race;
    }

    public void setRace(RaceName race) {
        this.race = race;
    }

    public GenderName getGender() {
        return this.gender;
    }

    public void setGender(GenderName gender) {
        this.gender = gender;
    }

    public CharacterClass getCharacterClass() {
        return this.characterClass;
    }

    public void setCharacterClass(CharacterClass characterClass) {
        this.characterClass = characterClass;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}