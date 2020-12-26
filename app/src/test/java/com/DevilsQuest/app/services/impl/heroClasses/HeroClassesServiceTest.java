//package com.DevilsQuest.app.services.impl.heroClasses;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//import java.util.stream.IntStream;
//
//import com.DevilsQuest.app.data.entities.heroes.HeroClass;
//import com.DevilsQuest.app.data.enums.CharacterClass;
//import com.DevilsQuest.app.data.models.views.heroes.BaseHeroCreateViewModel;
//import com.DevilsQuest.app.data.repositories.HeroClassesRepository;
//import com.DevilsQuest.app.services.HeroClassesService;
//import com.DevilsQuest.app.services.base.ServiceTestBase;
//import com.DevilsQuest.app.web.api.models.classes.HeroClassResponseModel;
//
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
//public class HeroClassesServiceTest extends ServiceTestBase {
//    List<HeroClass> heroClasses;
//
//    BaseHeroCreateViewModel baseHeroCreateViewModel;
//
//    @MockBean
//    HeroClassesRepository heroClassesRepository;
//
//    @Autowired
//    HeroClassesService heroClassesService;
//
//    @Override
//    protected void beforeEach() {
//        heroClasses = new ArrayList<>();
//        baseHeroCreateViewModel = new BaseHeroCreateViewModel();
//
//        Mockito.when(heroClassesRepository.findAll()).thenReturn(heroClasses);
//    }
//
//    @Test
//    void addHeroClassesToBaseModel_whenThereIsHeroClasses_shouldReturnNonEmptyList() {
//        heroClasses.clear();
//        heroClasses.addAll(getHeroClasses());
//
//        heroClassesService.addClassesToBaseModel(baseHeroCreateViewModel);
//
//        assertNotNull(baseHeroCreateViewModel.getClassNames());
//        assertEquals(6, baseHeroCreateViewModel.getClassNames().size());
//    }
//
//    @Test
//    void addHeroClassesToBaseModel_whenThereIsNoHeroClasses_shouldReturnEmptyList() {
//        heroClasses.clear();
//
//        heroClassesService.addClassesToBaseModel(baseHeroCreateViewModel);
//
//        assertEquals(0, baseHeroCreateViewModel.getClassNames().size());
//    }
//
//    @Test
//    void getClassDetails_whenThereIsClassDetails_shouldReturnNotNull() {
//        HeroClass heroClass = new HeroClass();
//        heroClass.setName(CharacterClass.BARBARIAN);
//        heroClass.setImageUrl("https://res.cloudinary.com/emicha/image/upload/v1586441725/DevilsQuest/heroes/create/barbarian_wdmfpi.jpg");
//        heroClass.setOverview("Barbarians are savage wanderers who never flinch from close-quarters combat. Mighty ground stomps, leaping attacks and dual-wielded slashes leave a barbarian’s enemies dead in their boots and send any survivors fleeing for cover.");
//
//        Mockito.when(heroClassesRepository.findByName(CharacterClass.BARBARIAN)).thenReturn(heroClass);
//
//        HeroClassResponseModel heroClassResponseModel = heroClassesService.getClassDetails(heroClass.getName().toDbValue());
//
//        assertNotNull(heroClassResponseModel);
//    }
//
//    private List<HeroClass> getHeroClasses() {
//        return getHeroClasses(6);
//    }
//
//    private List<HeroClass> getHeroClasses(int count) {
//        List<String> heroClasses = new ArrayList<>() {
//            private static final long serialVersionUID = 1L;
//
//            {
//                add("Barbarian");
//                add("Crusader");
//                add("Demon Hunter");
//                add("Monk");
//                add("Wizard");
//                add("Witch Doctor");
//            }
//        };
//
//        return IntStream.range(0, count)
//            .map(x -> x + 1)
//            .mapToObj(id -> {
//                HeroClass heroClass = new HeroClass();
//                heroClass.setId(id);
//                heroClass.setName(CharacterClass.fromDbValue(heroClasses.get(id - 1)));
//                return heroClass;
//            })
//            .collect(Collectors.toList());
//    }
//}