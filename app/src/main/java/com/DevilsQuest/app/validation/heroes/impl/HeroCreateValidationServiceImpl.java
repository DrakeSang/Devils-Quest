package com.DevilsQuest.app.validation.heroes.impl;

import com.DevilsQuest.app.data.repositories.HeroesRepository;
import com.DevilsQuest.app.validation.heroes.HeroCreateValidationService;

import org.springframework.stereotype.Service;

@Service
public class HeroCreateValidationServiceImpl implements HeroCreateValidationService {
    private final HeroesRepository heroesRepository;

    public HeroCreateValidationServiceImpl(HeroesRepository heroesRepository) {
        this.heroesRepository = heroesRepository;
    }

	@Override
	public boolean isHeroNameFree(String heroName) {
        boolean isHeroNameFree = !heroesRepository.existsByName(heroName);

        return isHeroNameFree;
	}
}