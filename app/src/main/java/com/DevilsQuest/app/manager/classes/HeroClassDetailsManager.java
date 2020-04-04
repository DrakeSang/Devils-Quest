package com.DevilsQuest.app.manager.classes;

import com.DevilsQuest.app.data.entities.heroes.HeroClass;
import com.DevilsQuest.app.manager.classes.base.ClassFighTypeDetails;

public interface HeroClassDetailsManager {
    /**
     * This method create the hero class by the choosen class name(Barbarian, Crusader, Demon Hunter, Monk, Wi-
     * zard, Witch Doctor). I have devided the hero classes by fighting style melee(barbarian, crusader, monk),
     * caster(wizard, witch doctor) and range(demon hunter). Every class has different resource generator and 
     * armor type(barbarian use fury and can wear mail, wizards and witch doctors can wear leather and cloth and
     * use mana and etc...). I decided to create parent clas {@link ClassFighTypeDetails}, which has a map with
     * key the class fight type as enum(melee, caster and range) and value object of type {@link HeroClass}. In 
     * this class i set the resource generator and armor type for the specific class(barbarian, demon hunter, wi-
     * zard, etc...) and put it in the map. The interface has to simple method create the hero class with the spe-
     * cific details and get the hero class by the hero class fight type. I create three implementations of the
     * interface for melee, caster and range and simply call the mthods form the parent class, which i need.
     * That way i think it easy if i want to add new functionality like attack i can easily implement it in the 
     * specific implementation: caster will have attack bonus depending on their spell power, etc ...
     * 
     * @param heroClassName the hero class name(barbarian, monk, wizard, etc..) as string
     */
    void createHeroClass(String heroClassName);

    /**
     * This method returns the hero class with already settled resource generator and armor type. I do not pass
     * any argument in the method, because in my implementations(melee, caster and range) i am sure that from the
     * melee implementation i need to take from my map the hero class against melee fight style and it is the same
     * for the anotehr implementations.
     * 
     * @return object of type {@link HeroClass} 
     */
    HeroClass getHeroClass();
}