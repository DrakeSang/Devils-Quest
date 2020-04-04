package com.DevilsQuest.app.data.repositories;

import com.DevilsQuest.app.data.entities.heroes.CharacterAttribute;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterAttributesRepository extends JpaRepository<CharacterAttribute, Long> {
}