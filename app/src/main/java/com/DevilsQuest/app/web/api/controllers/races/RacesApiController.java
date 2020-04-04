package com.DevilsQuest.app.web.api.controllers.races;

import java.util.List;

import com.DevilsQuest.app.manager.factions.FactionManager;
import com.DevilsQuest.app.web.base.BaseController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/races/get-races-by-faction")
public class RacesApiController extends BaseController {
    @Autowired
    private ApplicationContext applicationContext;

    @GetMapping("/{factionName}")
    public ResponseEntity<List<String>> getRacesNamesByFactionName(
        @PathVariable(value = "factionName") String factionName) {
            /**
             * I need the applicationContext so i can get the specific bean for teh faction manager. You remem-
             * ber our beans for Alliance and Horde faction manager. I pass the choosed faction name from the 
             * user and getting the implentation of that specific faction manager(Alliance or Horde), so i can
             * load the specific races for that faction.
             */
            FactionManager factionManager = (FactionManager) applicationContext.getBean(factionName);
            factionManager.createFaction(factionName);
            
            /**
             * Getting list of race names as strings. I need only the race names and nothing more, so i 
             * thought that it will be not necessary to add a new class only with one property name of the
             * race. Later if i need more things for the races i will create a class to keep my properties.
             */
            List<String> racesNames = factionManager.getRacesNamesByFactionName(factionName);

            return new ResponseEntity<>(racesNames, HttpStatus.OK);
    }    
}