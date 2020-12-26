//package com.DevilsQuest.app.validation.auth.impl;
//
//import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.mockito.Mockito.mock;
//
//import com.DevilsQuest.app.base.TestBase;
//import com.DevilsQuest.app.validation.auth.ProfilePicValidationService;
//
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.servlet.ModelAndView;
//
//public class ProfilePicValidationServiceTest extends TestBase {
//    @Autowired
//    ProfilePicValidationService service;
//
//    MultipartFile multipartFile = mock(MultipartFile.class);
//
//    ModelAndView modelAndView = new ModelAndView();
//
//    @Test
//    void isValid_whenSizeIsTooBig_shouldReturnFalse() {
//        Mockito.when(multipartFile.getSize()).thenReturn(5000000L);
//
//        boolean isValid = service.isValid(multipartFile, modelAndView);
//        assertFalse(isValid);
//    }
//
//    @Test
//    void isValid_whenExtensionIsWrong_shouldReturnFalse() {
//        Mockito.when(multipartFile.getOriginalFilename()).thenReturn("test.gif");
//
//        boolean isValid = service.isValid(multipartFile, modelAndView);
//        assertFalse(isValid);
//    }
//
//    @Test
//    void isValid_whenMultiPartFileIsCorrect_shouldReturnTrue() {
//        Mockito.when(multipartFile.getSize()).thenReturn(500000L);
//        Mockito.when(multipartFile.getOriginalFilename()).thenReturn("test.jpg");
//
//        boolean isValid = service.isValid(multipartFile, modelAndView);
//        assertFalse(isValid);
//    }
//}