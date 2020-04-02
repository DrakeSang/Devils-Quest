package com.DevilsQuest.app.handlers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

@Component
public class AuthFailureHandler implements AuthenticationFailureHandler {
    private final RedirectStrategy redirectStrategy;

    public AuthFailureHandler(RedirectStrategy redirectStrategy) {
        this.redirectStrategy = redirectStrategy;
    }

    @Override
    public void onAuthenticationFailure(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            AuthenticationException exception) throws IOException, ServletException {
                httpServletRequest.getSession().setAttribute("wrongCredentials", "Your credentials are wrong.");
                redirectStrategy.sendRedirect(httpServletRequest, httpServletResponse, "/users/login?error=true");
    }
}