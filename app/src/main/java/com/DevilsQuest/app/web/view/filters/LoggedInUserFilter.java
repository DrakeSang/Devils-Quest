package com.DevilsQuest.app.web.view.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.DevilsQuest.app.services.AuthenticatedUserService;

import org.springframework.stereotype.Component;

@Component
public class LoggedInUserFilter implements Filter {
    private final AuthenticatedUserService authenticatedUserService;

    public LoggedInUserFilter(AuthenticatedUserService authenticatedUserService) {
        this.authenticatedUserService = authenticatedUserService;
    }

    /**
     * This filter triggers every time we make a request to the site even when we vist the index page. At the
     * begining of course the username will anonymousUser, which comes from spring security. We check if the user 
     * trying to log in is registered or it is anonymous user so we can put in the session attribute with key
     * username and value the username of the currenly logged in user. I use this attribute in my header and 
     * another templates to show different links in the index template.
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        String username = authenticatedUserService.getUsername();

        if(username.equals("anonymousUser")) {
            filterChain.doFilter(request, response);

            return;
        }

        HttpSession session = ((HttpServletRequest) request).getSession();
        session.setAttribute("username", username);

        filterChain.doFilter(request, response);
    }
}