package com.DevilsQuest.app.factories.heroes.impl;

import java.util.List;

import com.DevilsQuest.app.config.annotations.Factory;
import com.DevilsQuest.app.data.entities.heroes.Attribute;
import com.DevilsQuest.app.data.entities.heroes.CharacterType;
import com.DevilsQuest.app.data.entities.heroes.Faction;
import com.DevilsQuest.app.data.entities.heroes.Hero;
import com.DevilsQuest.app.data.entities.heroes.HeroClass;
import com.DevilsQuest.app.data.entities.heroes.Race;
import com.DevilsQuest.app.data.models.services.heroes.HeroCreateServiceModel;
import com.DevilsQuest.app.data.repositories.AttributesRepository;
import com.DevilsQuest.app.data.repositories.CharacterTypesRepository;
import com.DevilsQuest.app.data.repositories.FactionsRepository;
import com.DevilsQuest.app.data.repositories.RacesRepository;
import com.DevilsQuest.app.factories.heroes.HeroesFactory;
import com.DevilsQuest.app.manager.classes.HeroClassDetailsManager;
import com.DevilsQuest.app.manager.classes.enums.ClassFightType;

import org.springframework.context.ApplicationContext;

@Factory
public class HeroesFactoryImpl implements HeroesFactory {
    private final CharacterTypesRepository characterTypesRepository;
    private final AttributesRepository attributesRepository;
    private final FactionsRepository factionsRepository;
    private final RacesRepository racesRepository;

    private final ApplicationContext applicationContext;

    public HeroesFactoryImpl(
        CharacterTypesRepository characterTypesRepository,
        AttributesRepository attributesRepository, 
        FactionsRepository factionsRepository, 
        RacesRepository racesRepository, 
        ApplicationContext applicationContext) {
            this.characterTypesRepository = characterTypesRepository;
            this.attributesRepository = attributesRepository;
            this.factionsRepository = factionsRepository;
            this.racesRepository = racesRepository;
            this.applicationContext = applicationContext;
    }

    @Override
    public Hero create(HeroCreateServiceModel heroCreateServiceModel, ClassFightType classFightType) {
        Hero hero = new Hero();

        /**
         * Setting the hero name and gender using the post details from the model.
         */
        hero.setName(heroCreateServiceModel.getName());
        hero.setGender(heroCreateServiceModel.getGender());

        /**
         * Setting the hero character type. I have two character types: player and non-player. Every hero is a 
         * player and later if i add npcs they will be set as non-player.
         */
        CharacterType characterType = characterTypesRepository.findByName("Player");
        hero.addCharacterType(characterType);

        /**
         * Setting the attributes of the hero: strength, attack, defence,etc ...
         */
        List<Attribute> characterAttributes = attributesRepository.findAll();
        for (Attribute attribute : characterAttributes) {
            hero.addAttribute(attribute); 
        }

        /**
         * Setting the faction and the race of the hero.
         */
        Faction faction = factionsRepository.findByName(heroCreateServiceModel.getFaction());
        Race race = racesRepository.findByName(heroCreateServiceModel.getRace());
        race.addFaction(faction);
        hero.addRace(race);

        /**
         * Getting the specific implementation of the interface by the class fight type(melee, caster, range).
         * The spring will see the 3 implementations, but by using the qualifier annotation it will make a 
         * sigleton of the specific qualifier.
         */
        HeroClassDetailsManager heroClassDetailsManager = 
            (HeroClassDetailsManager) applicationContext.getBean(classFightType.name());        
        heroClassDetailsManager.createHeroClass(heroCreateServiceModel.getCharacterClass().toDbValue());
        
        /**
         * Getting the hero class and set it to the hero of the user.
         */
        HeroClass heroClass = heroClassDetailsManager.getHeroClass();
        hero.addHeroCLass(heroClass);

        return hero;
    }
}