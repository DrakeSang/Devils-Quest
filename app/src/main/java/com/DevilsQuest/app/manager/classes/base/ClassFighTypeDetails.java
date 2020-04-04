package com.DevilsQuest.app.manager.classes.base;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.DevilsQuest.app.data.entities.heroes.ArmorType;
import com.DevilsQuest.app.data.entities.heroes.HeroClass;
import com.DevilsQuest.app.data.entities.heroes.ResourceGenerator;
import com.DevilsQuest.app.data.enums.ArmorTypeName;
import com.DevilsQuest.app.data.enums.CharacterClass;
import com.DevilsQuest.app.data.enums.ResourceGeneratorName;
import com.DevilsQuest.app.data.repositories.ArmorTypesRepository;
import com.DevilsQuest.app.data.repositories.HeroClassesRepository;
import com.DevilsQuest.app.data.repositories.ResourceGeneratorsRepository;
import com.DevilsQuest.app.manager.classes.enums.ClassFightType;

public class ClassFighTypeDetails {    
    private Map<ClassFightType, HeroClass> classFightTypes;

    private HeroClassesRepository heroClassesRepository;
    private ArmorTypesRepository armorTypesRepository;
    private ResourceGeneratorsRepository resourceGeneratorsRepository;

    public ClassFighTypeDetails(
        HeroClassesRepository heroClassesRepository, 
        ArmorTypesRepository armorTypesRepository, 
        ResourceGeneratorsRepository resourceGeneratorsRepository) {
            classFightTypes = new HashMap<>();
            this.heroClassesRepository = heroClassesRepository;
            this.armorTypesRepository = armorTypesRepository;
            this.resourceGeneratorsRepository = resourceGeneratorsRepository;
    }
    
    public HeroClass getHeroClassDetails(ClassFightType classFightType) {
        return this.classFightTypes.get(classFightType);
    }

    public void setHeroClassDetails(String heroClassName) {     
        HeroClass heroClass = heroClassesRepository.findByName(CharacterClass.fromDbValue(heroClassName));

        if (
            heroClassName.equals(CharacterClass.BARBARIAN.toDbValue()) || 
            heroClassName.equals(CharacterClass.CRUSADER.toDbValue()) ||
            heroClassName.equals(CharacterClass.MONK.toDbValue())
        ) {
            classFightTypes.put(ClassFightType.MELEE, heroClass);
            
            ArmorType armorType = armorTypesRepository.findByName(ArmorTypeName.MAIL);          
            heroClass.addArmorType(armorType);
            
            setClassResourceGenerator(heroClassName, heroClass);
        } else if(heroClassName.equals(CharacterClass.DEMON_HUNTER.toDbValue())) {
            classFightTypes.put(ClassFightType.RANGE, heroClass);

            ArmorType armorType = armorTypesRepository.findByName(ArmorTypeName.MAIL);          
            heroClass.addArmorType(armorType);

            setClassResourceGenerator(heroClassName, heroClass);
        } else {
            classFightTypes.put(ClassFightType.CASTER, heroClass);

            ArmorType firstArmorType = armorTypesRepository.findByName(ArmorTypeName.CLOTH);  
            ArmorType secondArmorType = armorTypesRepository.findByName(ArmorTypeName.LEATHER);      
            
            List<ArmorType> armorTypes = List.of(firstArmorType, secondArmorType);

            heroClass.addArmorTypes(armorTypes);
            setClassResourceGenerator(heroClassName, heroClass);
        }
    }

    private void setClassResourceGenerator(String heroClassName, HeroClass heroClass) {
        if(heroClassName.equals(CharacterClass.BARBARIAN.toDbValue())) {
            ResourceGenerator resourceGenerator = resourceGeneratorsRepository.findByName(ResourceGeneratorName.FURY);
            heroClass.addResourceGenerator(resourceGenerator);
        } else if (heroClassName.equals(CharacterClass.CRUSADER.toDbValue())){
            ResourceGenerator resourceGenerator = resourceGeneratorsRepository.findByName(ResourceGeneratorName.WRATH);
            heroClass.addResourceGenerator(resourceGenerator); 
        } else if (heroClassName.equals(CharacterClass.MONK.toDbValue())){
            ResourceGenerator resourceGenerator = resourceGeneratorsRepository.findByName(ResourceGeneratorName.SPIRIT);
            heroClass.addResourceGenerator(resourceGenerator); 
        } else if (heroClassName.equals(CharacterClass.DEMON_HUNTER.toDbValue())){
            ResourceGenerator resourceGenerator = resourceGeneratorsRepository.findByName(ResourceGeneratorName.DEISCIPLINE);
            heroClass.addResourceGenerator(resourceGenerator); 
        } else {
            ResourceGenerator resourceGenerator = resourceGeneratorsRepository.findByName(ResourceGeneratorName.MANA);
            heroClass.addResourceGenerator(resourceGenerator); 
        }
    }
}