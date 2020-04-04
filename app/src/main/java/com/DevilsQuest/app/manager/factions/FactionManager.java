package com.DevilsQuest.app.manager.factions;

import java.util.List;

public interface FactionManager {
    /**
     * Method for creating a hashmap with key the faction name and value list of available races
     * 
     * @param factionName name of the faction
     */
    void createFaction(String factionName);

    /**
     * Method for getting list of strings containing the names of the races for specific faction
     * 
     * @param factionName name of the faction
     * @return list of objects of type {@link String}
     */
    List<String> getRacesNamesByFactionName(String factionName);
}