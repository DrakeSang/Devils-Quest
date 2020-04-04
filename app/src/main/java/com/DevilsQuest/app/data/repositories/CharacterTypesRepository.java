package com.DevilsQuest.app.data.repositories;

import com.DevilsQuest.app.data.entities.heroes.CharacterType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterTypesRepository extends JpaRepository<CharacterType, Long> {
    CharacterType findByName(String name);
}