package com.DevilsQuest.app.data.repositories;

import com.DevilsQuest.app.data.entities.heroes.HeroClass;
import com.DevilsQuest.app.data.enums.CharacterClass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroClassesRepository extends JpaRepository<HeroClass, Long> {
    HeroClass findByName(CharacterClass name);
}