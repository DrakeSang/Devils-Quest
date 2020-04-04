package com.DevilsQuest.app.validation.heroes;

public interface HeroCreateValidationService {
    /**
     * Checks if the hero name is free
     * 
     * @param heroName the hero name to search for
     * @return true if exists, otherwise return false  
     */
    boolean isHeroNameFree(String heroName);
}