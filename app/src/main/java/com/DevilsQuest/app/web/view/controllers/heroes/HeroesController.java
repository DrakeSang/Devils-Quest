package com.DevilsQuest.app.web.view.controllers.heroes;

import java.security.Principal;

import javax.validation.Valid;

import com.DevilsQuest.app.data.models.services.heroes.HeroCreateServiceModel;
import com.DevilsQuest.app.data.models.views.heroes.BaseHeroCreateViewModel;
import com.DevilsQuest.app.data.models.views.heroes.HeroCreateViewModel;
import com.DevilsQuest.app.services.FactionsService;
import com.DevilsQuest.app.services.GendersService;
import com.DevilsQuest.app.services.HeroClassesService;
import com.DevilsQuest.app.services.UsersService;
import com.DevilsQuest.app.validation.heroes.HeroCreateValidationService;
import com.DevilsQuest.app.web.base.BaseController;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/heroes")
public class HeroesController extends BaseController {
    private final static String HERO_CREATE_VIEW_NAME = "heroes/create-hero";
    
    private final FactionsService factionsService;
    private final GendersService gendersService;  
    private final HeroClassesService heroClassesService;
    private final UsersService usersService;   

    private final ModelMapper modelMapper;

    private final HeroCreateValidationService heroCreateValidationService;

    public HeroesController( 
        FactionsService factionsService, 
        GendersService gendersService,
        HeroClassesService heroClassesService,
        UsersService usersService,
        ModelMapper modelMapper,
        HeroCreateValidationService heroCreateValidationService) {
            this.factionsService = factionsService;
            this.gendersService = gendersService;
            this.heroClassesService = heroClassesService;
            this.usersService = usersService;
            this.modelMapper = modelMapper;
            this.heroCreateValidationService = heroCreateValidationService;
    }

    @ModelAttribute("heroCreateViewModel")
    public HeroCreateViewModel getHeroCreateViewModel() {
        return new HeroCreateViewModel();
    }

    public BaseHeroCreateViewModel getBaseHeroCreateViewModel() {
        return new BaseHeroCreateViewModel();
    }

    @GetMapping("/create")
    public ModelAndView getHeroCreateForm(
        @ModelAttribute("heroCreateViewModel") HeroCreateViewModel hero,
        ModelAndView modelAndView) {
            setBaseHeroCreateViewModel(modelAndView);
            
            return super.view(HERO_CREATE_VIEW_NAME, modelAndView);
    }

    @PostMapping("/create")
    public ModelAndView createHero(
        @Valid @ModelAttribute("heroCreateViewModel") HeroCreateViewModel hero, 
        BindingResult bindingResult,
        ModelAndView modelAndView, 
        Principal principal) {
            if (bindingResult.hasErrors()) { 
                setBaseHeroCreateViewModel(modelAndView);

                return super.view(HERO_CREATE_VIEW_NAME, modelAndView);
            } else {
                HeroCreateServiceModel heroCreateServiceModel = modelMapper.map(hero, HeroCreateServiceModel.class);

                if(!heroCreateValidationService.isHeroNameFree(heroCreateServiceModel.getName())) {
                    modelAndView.addObject("existedHeroName", "This hero name is unavailable.");

                    return super.view(HERO_CREATE_VIEW_NAME, modelAndView);
                } else if(usersService.getHeroCount(principal.getName()) == 10) {
                    modelAndView.addObject("charactersCount", "You can not create anymore heroes. You have the max count.");

                    return super.view(HERO_CREATE_VIEW_NAME, modelAndView);
                } else {
                    usersService.createHeroForUser(heroCreateServiceModel);

                    return super.redirect("/");
                }
            }
    }

    private void setBaseHeroCreateViewModel(ModelAndView modelAndView) {
        BaseHeroCreateViewModel model = factionsService.addFactionsToBaseModel(getBaseHeroCreateViewModel());
        modelAndView.addObject("factions", model.getFactionNames());

        gendersService.addGendersToBaseModel(model);
        modelAndView.addObject("genders", model.getGenderNames());

        heroClassesService.addClassesToBaseModel(model);
        modelAndView.addObject("classes", model.getClassNames());
    }
}