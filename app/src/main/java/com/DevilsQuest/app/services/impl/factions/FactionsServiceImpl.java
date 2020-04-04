package com.DevilsQuest.app.services.impl.factions;

import java.util.List;

import com.DevilsQuest.app.data.entities.heroes.Faction;
import com.DevilsQuest.app.data.models.views.heroes.BaseHeroCreateViewModel;
import com.DevilsQuest.app.data.repositories.FactionsRepository;
import com.DevilsQuest.app.services.FactionsService;

import org.springframework.stereotype.Service;

@Service
public class FactionsServiceImpl implements FactionsService {
    private final FactionsRepository factionsRepository;

    public FactionsServiceImpl(FactionsRepository factionsRepository) {
        this.factionsRepository = factionsRepository;
    }

    @Override
    public BaseHeroCreateViewModel addFactionsToBaseModel(BaseHeroCreateViewModel model) {
        List<Faction> factions = factionsRepository.findAll();
        for (Faction faction : factions) {
            model.addFactionName(faction.getName().toDbValue());
        }

        return model;
    }    
}