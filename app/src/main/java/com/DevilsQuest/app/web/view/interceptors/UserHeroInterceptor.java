package com.DevilsQuest.app.web.view.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DevilsQuest.app.services.HeroesService;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class UserHeroInterceptor implements HandlerInterceptor {
    private final HeroesService heroesService;

    public UserHeroInterceptor(HeroesService heroesService) {
            this.heroesService = heroesService;
    }

    @Override
    public void postHandle(
        HttpServletRequest httpServletRequest, 
        HttpServletResponse httpServletResponse, 
        Object handler, 
        ModelAndView modelAndView) throws Exception {
            heroesService.setHeroesCountByUsernameOfUser(httpServletRequest);
        }
}