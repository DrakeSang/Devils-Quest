//package com.DevilsQuest.app.validation.heroes.impl;
//
//import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//import com.DevilsQuest.app.base.TestBase;
//import com.DevilsQuest.app.data.entities.heroes.Hero;
//import com.DevilsQuest.app.data.repositories.HeroesRepository;
//import com.DevilsQuest.app.validation.heroes.HeroCreateValidationService;
//
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
//public class HeroCreateValidationServiceTest extends TestBase {
//    static Hero hero;
//
//    @MockBean
//    HeroesRepository heroesRepository;
//
//    @Autowired
//    HeroCreateValidationService heroCreateValidationService;
//
//    @BeforeAll
//    protected static void beforeAll() {
//        hero = new Hero();
//        hero.setName("kiro");
//    }
//
//    @Test
//    void isValid_whenUsernameIsNotFree_shouldReturnFalse() {
//        Mockito.when(heroesRepository.existsByName(hero.getName())).thenReturn(true);
//
//        boolean isValid = heroCreateValidationService.isHeroNameFree(hero.getName());
//
//        assertFalse(isValid);
//    }
//
//    @Test
//    void isValid_whenUsernameIsFree_shouldReturnTrue() {
//        Mockito.when(heroesRepository.existsByName(hero.getName())).thenReturn(false);
//
//        boolean isValid = heroCreateValidationService.isHeroNameFree(hero.getName());
//
//        assertTrue(isValid);
//    }
//}