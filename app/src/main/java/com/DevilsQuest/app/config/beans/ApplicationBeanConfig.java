package com.DevilsQuest.app.config.beans;

import com.DevilsQuest.app.data.repositories.ArmorTypesRepository;
import com.DevilsQuest.app.data.repositories.HeroClassesRepository;
import com.DevilsQuest.app.data.repositories.RacesRepository;
import com.DevilsQuest.app.data.repositories.ResourceGeneratorsRepository;
import com.DevilsQuest.app.manager.classes.HeroClassDetailsManager;
import com.DevilsQuest.app.manager.classes.impl.CasterHeroClassType;
import com.DevilsQuest.app.manager.classes.impl.MeleeHeroClassType;
import com.DevilsQuest.app.manager.classes.impl.RangeHeroClasstype;
import com.DevilsQuest.app.manager.factions.FactionManager;
import com.DevilsQuest.app.manager.factions.impl.AllianceFactionImpl;
import com.DevilsQuest.app.manager.factions.impl.HordeFactionImpl;
import com.DevilsQuest.app.services.UsersService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

@Configuration
public class ApplicationBeanConfig {
    private UsersService usersService;

    private RacesRepository racesRepository;
    private HeroClassesRepository heroClassesRepository;
    private ArmorTypesRepository armorTypesRepository;
    private ResourceGeneratorsRepository resourceGeneratorsRepository;

    public ApplicationBeanConfig(
        UsersService usersService, 
        RacesRepository racesRepository,
        HeroClassesRepository heroClassesRepository,
        ArmorTypesRepository armorTypesRepository,
        ResourceGeneratorsRepository resourceGeneratorsRepository) {
            this.usersService = usersService;
            this.racesRepository = racesRepository;
            this.heroClassesRepository = heroClassesRepository;
            this.armorTypesRepository = armorTypesRepository;
            this.resourceGeneratorsRepository = resourceGeneratorsRepository;
    }    
    
    @Bean
    public UsersService usersService() {
        return usersService;
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public RedirectStrategy redirectStrategy() {
        return new DefaultRedirectStrategy();
    }

    @Bean
    public HttpSessionCsrfTokenRepository httpSessionCsrfTokenRepository() {
        return new HttpSessionCsrfTokenRepository();
    }

    /**
     * Creating bean for alliance faction manager. I use it when i want to get different races depending on 
     * faction name(Alliance or Horde)
     * 
     * @param factionManager object of type {@link FactionManager}. It is interface, which has methods for
     * creating a faction and getting the races names as strings for that faction.
     * @return object of type {@link AllianceFactionImpl}. The impl for the alliance faction.
     */
    @Bean(name = "Alliance")
    public FactionManager getAllianceFactionManager(@Qualifier("Alliance") FactionManager factionManager) {
        return new AllianceFactionImpl(racesRepository);
    }

    /**
     * Creating bean for horde faction manager.
     * 
     * @param factionManager object of type {@link FactionManager}. 
     * @return object of type {@link AllianceFactionImpl}. The impl for the horde faction.
     */
    @Bean(name = "Horde")
    public FactionManager getHordeFactionManager(@Qualifier("Horde") FactionManager factionManager) {
        return new HordeFactionImpl(racesRepository);
    }

    /**
     * Creating bean for melee hero class details manager.
     * 
     * @param heroClassDetailsManager object of type {@link HeroClassDetailsManager}
     * @return the specific implementation of the interface using qualifier
     */
    @Bean(name = "MELEE")
    public HeroClassDetailsManager getMeleeHeroClassManager(
        @Qualifier("MELEE") HeroClassDetailsManager heroClassDetailsManager) {
            return new MeleeHeroClassType(
                heroClassesRepository, 
                armorTypesRepository, 
                resourceGeneratorsRepository);
    }

    /**
     * Creating bean for caster hero class details manager.
     * 
     * @param heroClassDetailsManager object of type {@link HeroClassDetailsManager}
     * @return the specific implementation of the interface using qualifier
     */
    @Bean(name = "CASTER")
    public HeroClassDetailsManager getCasterHeroClassManager(
        @Qualifier("CASTER") HeroClassDetailsManager heroClassDetailsManager) {
            return new CasterHeroClassType(
                heroClassesRepository, 
                armorTypesRepository, 
                resourceGeneratorsRepository);
    }

    /**
     * Creating bean for range hero class details manager.
     * 
     * @param heroClassDetailsManager object of type {@link HeroClassDetailsManager}
     * @return the specific implementation of the interface using qualifier
     */
    @Bean(name = "RANGE")
    public HeroClassDetailsManager getRangeHeroClassManager(
        @Qualifier("RANGE") HeroClassDetailsManager heroClassDetailsManager) {
            return new RangeHeroClasstype(
                heroClassesRepository, 
                armorTypesRepository, 
                resourceGeneratorsRepository);
    }
}