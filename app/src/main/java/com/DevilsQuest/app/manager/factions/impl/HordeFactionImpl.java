package com.DevilsQuest.app.manager.factions.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.DevilsQuest.app.data.entities.heroes.Race;
import com.DevilsQuest.app.data.enums.RaceName;
import com.DevilsQuest.app.data.repositories.RacesRepository;
import com.DevilsQuest.app.manager.factions.FactionManager;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("Horde")
public class HordeFactionImpl implements FactionManager {
    private RacesRepository racesRepository;

    private static Map<String, List<String>> faction;

    public HordeFactionImpl(RacesRepository racesRepository) {
        this.racesRepository = racesRepository;
    }

    @Override
    public void createFaction(String factionName) {
        faction = new HashMap<>();
        faction.put(factionName, new ArrayList<>());
    }

    @Override
    public List<String> getRacesNamesByFactionName(String factionName) {
        Race firstRace = racesRepository.findByName(RaceName.ORC);
        Race secondRace = racesRepository.findByName(RaceName.TROLL);
        Race thirdRace = racesRepository.findByName(RaceName.UNDEAD);

        List<String> racesNames = List.of(
            firstRace.getName().toDbValue(), 
            secondRace.getName().toDbValue(), 
            thirdRace.getName().toDbValue()
        );

        faction.get(factionName).addAll(racesNames);

        return faction.get(factionName);
    }    
}