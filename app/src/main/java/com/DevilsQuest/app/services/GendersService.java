package com.DevilsQuest.app.services;

import com.DevilsQuest.app.data.models.views.heroes.BaseHeroCreateViewModel;

public interface GendersService {
    /**
     * This method adds the genders to object of type {@link BaseHeroCreateViewModel} so i can use them on
     * the select box of genders on creation process of the hero
     * 
     * @param model object of type {@link BaseHeroCreateViewModel}
     */
    void addGendersToBaseModel(BaseHeroCreateViewModel model);
}