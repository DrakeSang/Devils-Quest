package com.DevilsQuest.app.data.repositories;

import java.util.Set;

import com.DevilsQuest.app.data.entities.heroes.Hero;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HeroesRepository extends JpaRepository<Hero, Long> {
    /**
     * Check if hero exists 
     * 
     * @param heroName the hero name to search for
     * @return true if exists, otherwise return false 
     */
    boolean existsByName(String heroName);

    /**
     * Returns object of type {@link Hero} by given username of the currently logged user
     * 
     * @param username the username of the user
     * @return object of type {@link Hero}
     */
    Set<Hero> getByUserUsername(String username);
}