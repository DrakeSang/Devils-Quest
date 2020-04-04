package com.DevilsQuest.app.data.models.views.heroes;

import java.util.ArrayList;
import java.util.List;

public class BaseHeroCreateViewModel {
    private List<String> factionNames;

    private List<String> genderNames;

    private List<String> classNames;

    public BaseHeroCreateViewModel() {
        this.factionNames = new ArrayList<>();
        this.genderNames = new ArrayList<>();
        this.classNames = new ArrayList<>();    
    }

    public List<String> getFactionNames() {
        return this.factionNames;
    }

    public void addFactionName(String factionName) {
        this.factionNames.add(factionName);
    }

    public List<String> getGenderNames() {
        return this.genderNames;
    }

    public void addGenderName(String genderName) {
        this.genderNames.add(genderName);
    }

    public List<String> getClassNames() {
        return this.classNames;
    }

    public void addClassName(String className) {
        this.classNames.add(className);
    }
}