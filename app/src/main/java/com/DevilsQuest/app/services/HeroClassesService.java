package com.DevilsQuest.app.services;

import com.DevilsQuest.app.data.models.views.heroes.BaseHeroCreateViewModel;
import com.DevilsQuest.app.web.api.models.classes.HeroClassResponseModel;

public interface HeroClassesService {
    /**
     * This method adds the classes to object of type {@link BaseHeroCreateViewModel} so i can use them on
     * the select box of classes on creation process of the hero
     * 
     * @param model object of type {@link BaseHeroCreateViewModel}
     */
    void addClassesToBaseModel(BaseHeroCreateViewModel model);

    /**
     * This method will return the class details(image and overview of the class) so i can load them dynamically
     * depending on which class the user choosed on creation process of the hero
     * 
     * @param className the name of the class choosen by the hero
     * @return object of type {@link HeroClassResponseModel}, which will keep the image and the overview for the 
     * specific class, which user choosed
     */
    HeroClassResponseModel getClassDetails(String className);
}