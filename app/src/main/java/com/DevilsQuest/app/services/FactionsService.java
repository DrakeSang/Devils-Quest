package com.DevilsQuest.app.services;

import com.DevilsQuest.app.data.models.views.heroes.BaseHeroCreateViewModel;

public interface FactionsService {
    /**
     * This method adds the factions to object of type {@link BaseHeroCreateViewModel} so i can use them on
     * the select box of factions on creation process of the hero. Here i need to return the model so i can use
     * it to set the races and classes. After that i pass the lists of factions, races and classes to the view
     * under different attribute name.
     * 
     * @param model the object of type {@link BaseHeroCreateViewModel}
     * @return the object of type {@link BaseHeroCreateViewModel}
     */
    BaseHeroCreateViewModel addFactionsToBaseModel(BaseHeroCreateViewModel model); 
}