//package com.DevilsQuest.app.services.impl.genders;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//import java.util.stream.IntStream;
//
//import com.DevilsQuest.app.data.entities.genders.Gender;
//import com.DevilsQuest.app.data.enums.GenderName;
//import com.DevilsQuest.app.data.models.views.heroes.BaseHeroCreateViewModel;
//import com.DevilsQuest.app.data.repositories.GendersRepository;
//import com.DevilsQuest.app.services.GendersService;
//import com.DevilsQuest.app.services.base.ServiceTestBase;
//
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
//public class GendersServiceTest extends ServiceTestBase {
//    List<Gender> genders;
//
//    BaseHeroCreateViewModel baseHeroCreateViewModel;
//
//    @MockBean
//    GendersRepository gendersRepository;
//
//    @Autowired
//    GendersService gendersService;
//
//    @Override
//    protected void beforeEach() {
//        genders = new ArrayList<>();
//        baseHeroCreateViewModel = new BaseHeroCreateViewModel();
//
//        Mockito.when(gendersRepository.findAll()).thenReturn(genders);
//    }
//
//    @Test
//    void addGendersToBaseModel_whenThereIsGenders_shouldReturnNonEmptyList() {
//        genders.clear();
//        genders.addAll(getGenders());
//
//        gendersService.addGendersToBaseModel(baseHeroCreateViewModel);
//
//        assertNotNull(baseHeroCreateViewModel.getGenderNames());
//        assertEquals(2, baseHeroCreateViewModel.getGenderNames().size());
//    }
//
//    @Test
//    void addGendersToBaseModel_whenThereIsNoGenders_shouldReturnEmptyList() {
//        genders.clear();
//
//        gendersService.addGendersToBaseModel(baseHeroCreateViewModel);
//
//        assertEquals(0, baseHeroCreateViewModel.getGenderNames().size());
//    }
//
//    private List<Gender> getGenders() {
//        return getGenders(2);
//    }
//
//    private List<Gender> getGenders(int count) {
//        List<String> gendersNames = new ArrayList<>() {
//            private static final long serialVersionUID = 1L;
//
//            {
//                add("Male");
//                add("Female");
//            }
//        };
//
//        return IntStream.range(0, count)
//            .map(x -> x + 1)
//            .mapToObj(id -> {
//                Gender gender = new Gender();
//                gender.setId(id);
//                gender.setName(GenderName.fromDbValue(gendersNames.get(id - 1)));
//                return gender;
//            })
//            .collect(Collectors.toList());
//    }
//}