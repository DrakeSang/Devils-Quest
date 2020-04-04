package com.DevilsQuest.app.web.api.controllers.classes;

import com.DevilsQuest.app.services.HeroClassesService;
import com.DevilsQuest.app.web.api.models.classes.HeroClassResponseModel;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClassesApiController {
    private final HeroClassesService heroClassesService;

    public ClassesApiController(HeroClassesService heroClassesService) {
        this.heroClassesService = heroClassesService;
    }

    @GetMapping("/api/classes/get-class-details/{className}")
    public ResponseEntity<HeroClassResponseModel> getClassDetailsByClassName(
        @PathVariable(value = "className") String className) {
            HeroClassResponseModel heroClassResponseModel = heroClassesService.getClassDetails(className);

            return new ResponseEntity<>(heroClassResponseModel, HttpStatus.OK);
    }
}