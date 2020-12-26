package com.DevilsQuest.app.factories.heroes.impl;

import com.DevilsQuest.app.base.TestBase;
import com.DevilsQuest.app.data.entities.heroes.Faction;
import com.DevilsQuest.app.data.entities.heroes.Hero;
import com.DevilsQuest.app.data.entities.heroes.HeroClass;
import com.DevilsQuest.app.data.entities.heroes.Race;
import com.DevilsQuest.app.data.enums.CharacterClass;
import com.DevilsQuest.app.data.enums.FactionName;
import com.DevilsQuest.app.data.enums.GenderName;
import com.DevilsQuest.app.data.enums.RaceName;
import com.DevilsQuest.app.data.models.services.heroes.HeroCreateServiceModel;
import com.DevilsQuest.app.data.repositories.*;
import com.DevilsQuest.app.factories.heroes.HeroesFactory;
import com.DevilsQuest.app.manager.classes.HeroClassDetailsManager;
import com.DevilsQuest.app.manager.classes.enums.ClassFightType;
import com.DevilsQuest.app.manager.classes.impl.MeleeHeroClassType;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import static org.junit.Assert.assertEquals;

public class HeroesFactoryTest extends TestBase {
    @Mock
    CharacterTypesRepository characterTypesRepository;

    @Mock
    AttributesRepository attributesRepository;

    @Mock
    FactionsRepository factionsRepository;

    @Mock
    RacesRepository racesRepository;

    @Mock
    ApplicationContext applicationContext;

    //@InjectMocks
    HeroesFactory factory;

    @Mock
    HeroClassesRepository heroClassesRepository;

    @Mock
    ArmorTypesRepository armorTypesRepository;

    @Mock
    ResourceGeneratorsRepository resourceGeneratorsRepository;

    HeroClassDetailsManager heroClassDetailsManager;

    @Test
    public void createHero_withValidData_shouldReturnHero() {
        factory = new HeroesFactoryImpl(characterTypesRepository, attributesRepository, factionsRepository, racesRepository, applicationContext);
        heroClassDetailsManager = new MeleeHeroClassType(heroClassesRepository, armorTypesRepository, resourceGeneratorsRepository);

        FactionName factionName = FactionName.HORDE;
        RaceName raceName = RaceName.ORC;
        GenderName genderName = GenderName.MALE;
        CharacterClass characterClass = CharacterClass.BARBARIAN;
        String heroName = "OneShot";

        HeroCreateServiceModel heroCreateServiceModel = new HeroCreateServiceModel();
        heroCreateServiceModel.setFaction(factionName);
        heroCreateServiceModel.setRace(raceName);
        heroCreateServiceModel.setGender(genderName);
        heroCreateServiceModel.setCharacterClass(characterClass);
        heroCreateServiceModel.setName(heroName);

        Faction faction = new Faction();
        faction.setName(heroCreateServiceModel.getFaction());
        Mockito.when(factionsRepository.findByName(FactionName.HORDE)).thenReturn(faction);
        Mockito.when(racesRepository.findByName(RaceName.ORC)).thenReturn(new Race());
        Mockito.when(applicationContext.getBean(ClassFightType.MELEE.name())).thenReturn(heroClassDetailsManager);
        Mockito.when(heroClassesRepository.findByName(CharacterClass.BARBARIAN)).thenReturn(new HeroClass());

        Hero hero = factory.create(heroCreateServiceModel, ClassFightType.MELEE);

        assertEquals(factionName, hero.getRaces().get(0).getFactions().get(0).getName());
        assertEquals(raceName, hero.getRaces().get(0).getName());
        assertEquals(characterClass, hero.getHeroClasses().get(0).getName());
        assertEquals(genderName, hero.getGender());
        assertEquals(heroName, hero.getName());
    }
}