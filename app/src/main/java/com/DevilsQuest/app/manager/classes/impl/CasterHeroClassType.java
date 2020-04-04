package com.DevilsQuest.app.manager.classes.impl;

import com.DevilsQuest.app.data.entities.heroes.HeroClass;
import com.DevilsQuest.app.data.repositories.ArmorTypesRepository;
import com.DevilsQuest.app.data.repositories.HeroClassesRepository;
import com.DevilsQuest.app.data.repositories.ResourceGeneratorsRepository;
import com.DevilsQuest.app.manager.classes.HeroClassDetailsManager;
import com.DevilsQuest.app.manager.classes.base.ClassFighTypeDetails;
import com.DevilsQuest.app.manager.classes.enums.ClassFightType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("CASTER")
public class CasterHeroClassType extends ClassFighTypeDetails implements HeroClassDetailsManager {
    @Autowired
    public CasterHeroClassType(
        HeroClassesRepository heroClassesRepository, 
        ArmorTypesRepository armorTypesRepository,
        ResourceGeneratorsRepository resourceGeneratorsRepository) {
            super(heroClassesRepository, armorTypesRepository, resourceGeneratorsRepository);
    }

    @Override
    public void createHeroClass(String heroClassName) {
        setHeroClassDetails(heroClassName);
    }

    @Override
    public HeroClass getHeroClass() {
        return getHeroClassDetails(ClassFightType.CASTER);
    }    
}