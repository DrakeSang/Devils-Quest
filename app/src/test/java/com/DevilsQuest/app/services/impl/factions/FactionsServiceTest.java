package com.DevilsQuest.app.services.impl.factions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.DevilsQuest.app.data.entities.heroes.Faction;
import com.DevilsQuest.app.data.enums.FactionName;
import com.DevilsQuest.app.data.models.views.heroes.BaseHeroCreateViewModel;
import com.DevilsQuest.app.data.repositories.FactionsRepository;
import com.DevilsQuest.app.services.FactionsService;
import com.DevilsQuest.app.services.base.ServiceTestBase;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

public class FactionsServiceTest extends ServiceTestBase {
    List<Faction> factions;

    BaseHeroCreateViewModel baseHeroCreateViewModel;

    @MockBean
    FactionsRepository factionsRepository;

    @Autowired
    FactionsService factionsService;

    @Override
    protected void beforeEach() {
        factions = new ArrayList<>();
        baseHeroCreateViewModel = new BaseHeroCreateViewModel();

        Mockito.when(factionsRepository.findAll()).thenReturn(factions);
    }

    @Test
    void addFactionsToBaseModel_whenThereIsFactions_shouldReturnNonEmptyList() {
        factions.clear();
        factions.addAll(getFactions());

        factionsService.addFactionsToBaseModel(baseHeroCreateViewModel);
        
        assertNotNull(baseHeroCreateViewModel.getFactionNames());
        assertEquals(2, baseHeroCreateViewModel.getFactionNames().size());
    }

    @Test
    void addFactionsToBaseModel_whenThereIsNoFactions_shouldReturnEmptyList() {
        factions.clear();

        factionsService.addFactionsToBaseModel(baseHeroCreateViewModel);

        assertEquals(0, baseHeroCreateViewModel.getFactionNames().size());
    }

    private List<Faction> getFactions() {
        return getFactions(2);
    }

    private List<Faction> getFactions(int count) {
        List<String> factionsNames = new ArrayList<>() {
            private static final long serialVersionUID = 1L;

            {
                add("Alliance");
                add("Horde");
            }
        };

        return IntStream.range(0, count)
            .map(x -> x + 1)
            .mapToObj(id -> {
                Faction faction = new Faction();
                faction.setId(id);
                faction.setName(FactionName.fromDbValue(factionsNames.get(id - 1)));
                return faction;
            })
            .collect(Collectors.toList());
    }
}