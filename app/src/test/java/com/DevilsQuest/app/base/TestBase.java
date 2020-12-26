package com.DevilsQuest.app.base;

import org.junit.Before;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest
//@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class TestBase {
    @Before
    public void setupTest() {
        MockitoAnnotations.initMocks(this);
        this.beforeEach();
    }

    protected void beforeEach() {
    }
}