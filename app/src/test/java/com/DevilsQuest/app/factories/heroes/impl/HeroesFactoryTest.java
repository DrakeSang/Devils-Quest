package com.DevilsQuest.app.factories.heroes.impl;

import com.DevilsQuest.app.base.TestBase;
import com.DevilsQuest.app.factories.heroes.HeroesFactory;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class HeroesFactoryTest extends TestBase {
    @Autowired
    HeroesFactory factory;

    @Test
    void createHero_withValidData_shouldReturnHero() {
        /** TODO: Need to fix my test */
        
        // FactionName factionName = FactionName.HORDE;
        // RaceName raceName = RaceName.ORC;
        // GenderName genderName = GenderName.MALE;
        // CharacterClass characterClass = CharacterClass.BARBARIAN;
        // String heroName = "OneShot";

        // HeroCreateServiceModel heroCreateServiceModel = new HeroCreateServiceModel();
        // heroCreateServiceModel.setFaction(factionName);
        // heroCreateServiceModel.setRace(raceName);
        // heroCreateServiceModel.setGender(genderName);
        // heroCreateServiceModel.setCharacterClass(characterClass);
        // heroCreateServiceModel.setName(heroName);

        // Hero hero = factory.create(heroCreateServiceModel, ClassFightType.MELEE);

        // assertEquals(factionName, hero.getRaces().get(0).getFactions().get(0).getName());
        // assertEquals(raceName, hero.getRaces().get(0).getName());
        // assertEquals(characterClass, hero.getHeroClasses().get(0).getName());
        // assertEquals(genderName, hero.getGender());
        // assertEquals(heroName, hero.getName());
    }
}