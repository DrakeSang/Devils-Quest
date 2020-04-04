package com.DevilsQuest.app.data.repositories;

import com.DevilsQuest.app.data.entities.heroes.Race;
import com.DevilsQuest.app.data.enums.RaceName;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RacesRepository extends JpaRepository<Race, Long> {
    Race findByName(RaceName name);
}