package com.DevilsQuest.app.services.impl.users;

import com.DevilsQuest.app.services.AuthenticatedUserService;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthenticatedUserServiceImpl implements AuthenticatedUserService {
    @Override
    public String getUsername() {
        Authentication authentication = getAuthentication();

        return authentication.getName();
    }

    @Override
    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
}