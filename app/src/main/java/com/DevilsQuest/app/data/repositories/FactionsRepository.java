package com.DevilsQuest.app.data.repositories;

import com.DevilsQuest.app.data.entities.heroes.Faction;
import com.DevilsQuest.app.data.enums.FactionName;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FactionsRepository extends JpaRepository<Faction, Long> {
    Faction findByName(FactionName factionName);
}