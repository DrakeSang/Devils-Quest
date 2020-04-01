package com.DevilsQuest.app.handlers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

/**
 * Handler for successfull authentication.
 */
@Component
public class AuthSuccessHandler implements AuthenticationSuccessHandler {
    private final RedirectStrategy redirectStrategy;

    public AuthSuccessHandler(RedirectStrategy redirectStrategy) {
        this.redirectStrategy = redirectStrategy;
    }
 
    @Override
    public void onAuthenticationSuccess(
        HttpServletRequest httpServletRequest,
        HttpServletResponse httpServletResponse,
        org.springframework.security.core.Authentication authentication) throws IOException {
            redirectStrategy.sendRedirect(httpServletRequest, httpServletResponse, "/");
        }
}