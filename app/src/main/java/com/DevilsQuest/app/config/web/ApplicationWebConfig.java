package com.DevilsQuest.app.config.web;

import com.DevilsQuest.app.web.view.interceptors.UserHeroInterceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ApplicationWebConfig implements WebMvcConfigurer {
    UserHeroInterceptor userHeroInterceptor;

    public ApplicationWebConfig(UserHeroInterceptor userHeroInterceptor) {
        this.userHeroInterceptor = userHeroInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userHeroInterceptor).addPathPatterns("/heroes/create");
    }
}