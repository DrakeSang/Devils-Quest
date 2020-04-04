package com.DevilsQuest.app.data.repositories;

import com.DevilsQuest.app.data.entities.heroes.ArmorType;
import com.DevilsQuest.app.data.enums.ArmorTypeName;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArmorTypesRepository extends JpaRepository<ArmorType, Long> {
    ArmorType findByName(ArmorTypeName name);
}