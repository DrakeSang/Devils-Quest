//package com.DevilsQuest.app.web.api;
//
//import com.DevilsQuest.app.data.entities.heroes.Faction;
//import com.DevilsQuest.app.data.enums.FactionName;
//import com.DevilsQuest.app.web.base.ApiTestBase;
//
//import org.junit.jupiter.api.Test;
//
//import java.util.Arrays;
//
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//public class RacesApiControllerTest extends ApiTestBase {
//    @Test
//    void getRacesNamesByFactionName_whenThereIsRacesInDB_shouldReturnNonEmptyList() {
//         Faction faction = new Faction();
//         faction.setName(FactionName.HORDE);
//
//         String[] response = getRestTemplate().getForObject
//         (
//             getFullUrl("/api/races/get-races-by-faction/" + faction.getName().toDbValue()),
//             String[].class
//         );
//
//         assertNotNull(response);
//         assertTrue(Arrays.asList(response).contains("Orc"));
//         assertTrue(Arrays.asList(response).contains("Troll"));
//         assertTrue(Arrays.asList(response).contains("Undead"));
//    }
//}