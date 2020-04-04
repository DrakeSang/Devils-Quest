package com.DevilsQuest.app.services.impl.heroes;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import com.DevilsQuest.app.data.entities.auth.User;
import com.DevilsQuest.app.data.entities.heroes.Hero;
import com.DevilsQuest.app.data.enums.CharacterClass;
import com.DevilsQuest.app.data.models.services.heroes.HeroCreateServiceModel;
import com.DevilsQuest.app.data.repositories.HeroesRepository;
import com.DevilsQuest.app.data.repositories.UsersRepository;
import com.DevilsQuest.app.factories.heroes.HeroesFactory;
import com.DevilsQuest.app.manager.classes.enums.ClassFightType;
import com.DevilsQuest.app.services.AuthenticatedUserService;
import com.DevilsQuest.app.services.HeroesService;

import org.springframework.stereotype.Service;

@Service
public class HeroesServiceImpl implements HeroesService {
    private final AuthenticatedUserService authenticatedUserService;
    private final UsersRepository usersRepository;
    private final HeroesRepository heroesRepository;

    private final HeroesFactory heroesFactory;

    public HeroesServiceImpl(AuthenticatedUserService authenticatedUserService, UsersRepository usersRepository, HeroesRepository heroesRepository, HeroesFactory heroesFactory) {
        this.authenticatedUserService = authenticatedUserService;
        this.usersRepository = usersRepository;
        this.heroesRepository = heroesRepository;
        this.heroesFactory = heroesFactory;
    }

    @Override
    public void setHeroesCountByUsernameOfUser(HttpServletRequest httpServletRequest) {
        String username = authenticatedUserService.getUsername();
        int heroesCountForUser = getHeroesCountByUsernameOfUser(username);

        if(heroesCountForUser > 0) {
            httpServletRequest.getSession().setAttribute("heroesCount", heroesCountForUser);
        }
    }

    private int getHeroesCountByUsernameOfUser(String username) {
        return heroesRepository.getByUserUsername(username).size();
    }

    @Override
    public void create(HeroCreateServiceModel heroCreateServiceModel) {
        /**
         * Getting the class fight type(melee, caster, range) by the choosen class from the user
         */
        ClassFightType classFightType = getHeroFightTypeByClass(heroCreateServiceModel.getCharacterClass().toDbValue());
        Hero hero = heroesFactory.create(heroCreateServiceModel, classFightType);
        
        /**
         * Getting the currently logged in user and setting on the created hero the id of the user, because in
         * the db in the hero table i keep the user id of the user who created the hero and the user table i keep
         * it simple only with email, password, username and avatar pic. 
         */
        Optional<User> userResult = usersRepository.findByUsername(authenticatedUserService.getUsername());
        User user = userResult.get();
        
        hero.setUser(user);

        heroesRepository.save(hero);
    }

    private ClassFightType getHeroFightTypeByClass(String heroClassName) {
        if (
            heroClassName.equals(CharacterClass.BARBARIAN.toDbValue()) || 
            heroClassName.equals(CharacterClass.CRUSADER.toDbValue()) ||
            heroClassName.equals(CharacterClass.MONK.toDbValue())
        ) {
            return ClassFightType.MELEE;
        } else if(heroClassName.equals(CharacterClass.DEMON_HUNTER.toDbValue())) {
            return ClassFightType.RANGE;
        } else {
            return ClassFightType.CASTER;
        }
    }
}