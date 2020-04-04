package com.DevilsQuest.app.services.impl.genders;

import java.util.List;

import com.DevilsQuest.app.data.entities.genders.Gender;
import com.DevilsQuest.app.data.models.views.heroes.BaseHeroCreateViewModel;
import com.DevilsQuest.app.data.repositories.GendersRepository;
import com.DevilsQuest.app.services.GendersService;

import org.springframework.stereotype.Service;

@Service
public class GendersServiceImpl implements GendersService {
    private final GendersRepository gendersRepository;

    public GendersServiceImpl(GendersRepository gendersRepository) {
        this.gendersRepository = gendersRepository;
    }

    @Override
    public void addGendersToBaseModel(BaseHeroCreateViewModel model) {
        List<Gender> genders = gendersRepository.findAll();
        
        for (Gender gender : genders) {
            model.addGenderName(gender.getName().toDbValue());
        }
    } 
}