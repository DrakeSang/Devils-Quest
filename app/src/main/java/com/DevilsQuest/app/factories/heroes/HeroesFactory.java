package com.DevilsQuest.app.factories.heroes;

import com.DevilsQuest.app.data.entities.heroes.Hero;
import com.DevilsQuest.app.data.models.services.heroes.HeroCreateServiceModel;
import com.DevilsQuest.app.manager.classes.enums.ClassFightType;

public interface HeroesFactory {
    /**
     * Method for creating the hero by given class fight type
     * 
     * @param serviceModel object of type {@link HeroCreateServiceModel}
     * @param classFightType object of type {@link ClassFightType}
     * @return object of type {@link Hero}
     */
    Hero create(HeroCreateServiceModel serviceModel, ClassFightType classFightType);
}   