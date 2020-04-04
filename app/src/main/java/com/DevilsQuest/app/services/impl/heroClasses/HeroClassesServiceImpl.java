package com.DevilsQuest.app.services.impl.heroClasses;

import java.util.List;

import com.DevilsQuest.app.data.entities.heroes.HeroClass;
import com.DevilsQuest.app.data.enums.CharacterClass;
import com.DevilsQuest.app.data.models.views.heroes.BaseHeroCreateViewModel;
import com.DevilsQuest.app.data.repositories.HeroClassesRepository;
import com.DevilsQuest.app.services.HeroClassesService;
import com.DevilsQuest.app.web.api.models.classes.HeroClassResponseModel;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class HeroClassesServiceImpl implements HeroClassesService {
    private final HeroClassesRepository heroClassesRepository;

    private final ModelMapper modelMapper;

    public HeroClassesServiceImpl(HeroClassesRepository heroClassesRepository, ModelMapper modelMapper) {
        this.heroClassesRepository = heroClassesRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addClassesToBaseModel(BaseHeroCreateViewModel model) {
        List<HeroClass> heroClasses = heroClassesRepository.findAll();
        
        for (HeroClass heroClass : heroClasses) {
            model.addClassName(heroClass.getName().toDbValue());
        }
    }

    @Override
    public HeroClassResponseModel getClassDetails(String className) {
        HeroClass heroClass = heroClassesRepository.findByName(CharacterClass.fromDbValue(className));
        HeroClassResponseModel heroClassResponseModel = modelMapper.map(heroClass, HeroClassResponseModel.class);

        return heroClassResponseModel;
    }
}