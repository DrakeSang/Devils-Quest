package com.DevilsQuest.app.handlers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DevilsQuest.app.services.HeroesService;

import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class AuthSuccessHandler implements AuthenticationSuccessHandler {
    private final HeroesService heroesService;

    private final RedirectStrategy redirectStrategy;

    public AuthSuccessHandler(HeroesService heroesService, RedirectStrategy redirectStrategy) {
            this.heroesService = heroesService;
            this.redirectStrategy = redirectStrategy;
    }
 
    @Override
    public void onAuthenticationSuccess(
        HttpServletRequest httpServletRequest,
        HttpServletResponse httpServletResponse,
        org.springframework.security.core.Authentication authentication) throws IOException {
            heroesService.setHeroesCountByUsernameOfUser(httpServletRequest);

            redirectStrategy.sendRedirect(httpServletRequest, httpServletResponse, "/");
        }
}