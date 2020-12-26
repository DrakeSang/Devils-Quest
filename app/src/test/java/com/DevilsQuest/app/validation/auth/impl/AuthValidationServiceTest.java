//package com.DevilsQuest.app.validation.auth.impl;
//
//import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.mockito.Mockito.mock;
//
//import com.DevilsQuest.app.base.TestBase;
//import com.DevilsQuest.app.data.models.services.auth.RegisterUserServiceModel;
//import com.DevilsQuest.app.data.repositories.UsersRepository;
//import com.DevilsQuest.app.validation.auth.AuthValidationService;
//import com.DevilsQuest.app.validation.auth.ProfilePicValidationService;
//
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.servlet.ModelAndView;
//
//public class AuthValidationServiceTest extends TestBase {
//    MultipartFile multipartFile = mock(MultipartFile.class);
//
//    ModelAndView modelAndView = new ModelAndView();
//
//    @MockBean
//    UsersRepository usersRepository;
//
//    @MockBean
//    ProfilePicValidationService profilePicValidationService;
//
//    @Autowired
//    AuthValidationService authValidationService;
//
//    @Test
//    void isValid_whenUsernameIsNotFree_shouldReturnFalse() {
//        RegisterUserServiceModel registerUserModel = new RegisterUserServiceModel();
//        registerUserModel.setUsername("kiro");
//
//        Mockito.when(usersRepository.existsByUsername(registerUserModel.getUsername())).thenReturn(true);
//
//        boolean isValid = authValidationService.isValid(registerUserModel, multipartFile, modelAndView);
//        assertFalse(isValid);
//    }
//
//    @Test
//    void isValid_whenEmailIsNotFree_shouldReturnFalse() {
//        RegisterUserServiceModel registerUserModel = new RegisterUserServiceModel();
//        registerUserModel.setEmail("kiro@abv.bg");
//
//        Mockito.when(usersRepository.existsByEmail(registerUserModel.getUsername())).thenReturn(true);
//
//        boolean isValid = authValidationService.isValid(registerUserModel, multipartFile, modelAndView);
//        assertFalse(isValid);
//    }
//
//    @Test
//    void isValid_whenPasswordsAreNotEquals_shouldReturnFalse() {
//        RegisterUserServiceModel registerUserModel = new RegisterUserServiceModel();
//        registerUserModel.setPassword("123");
//        registerUserModel.setConfirmPassword("1234");
//
//        Mockito.when(usersRepository.existsByUsername(registerUserModel.getUsername())).thenReturn(false);
//        Mockito.when(usersRepository.existsByEmail(registerUserModel.getUsername())).thenReturn(false);
//        Mockito.when(profilePicValidationService.isValid(multipartFile, modelAndView)).thenReturn(true);
//
//        boolean isValid = authValidationService.isValid(registerUserModel, multipartFile, modelAndView);
//        assertFalse(isValid);
//    }
//
//    @Test
//    void isValid_whenUserRegisterModelIsValid_shouldReturnTrue() {
//        RegisterUserServiceModel registerUserModel = new RegisterUserServiceModel
//        (
//            "kiro",
//            "kiro@abv.bg",
//            "https://res.cloudinary.com/emicha/image/upload/v1585920482/DevilsQuest/auth/users/profile_pics/rgisnlqc9fyl6mlj93i1.jpg",
//            "123",
//            "123"
//        );
//
//        boolean isValid = authValidationService.isValid(registerUserModel, multipartFile, modelAndView);
//        assertFalse(isValid);
//    }
//}