package com.DevilsQuest.app.config.web;

import com.DevilsQuest.app.services.UsersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {
    private final AuthenticationSuccessHandler authSuccessHandler;
    private final AuthenticationFailureHandler authFailureHandler;

    private final UsersService usersService;
    private final PasswordEncoder passwordEncoder;
    
    private final HttpSessionCsrfTokenRepository httpSessionCsrfTokenRepository;

    public ApplicationSecurityConfig(AuthenticationSuccessHandler authSuccessHandler, AuthenticationFailureHandler authFailureHandler, UsersService usersService, PasswordEncoder passwordEncoder, HttpSessionCsrfTokenRepository httpSessionCsrfTokenRepository) {
        this.authSuccessHandler = authSuccessHandler;
        this.authFailureHandler = authFailureHandler;
        this.usersService = usersService;
        this.passwordEncoder = passwordEncoder;
        this.httpSessionCsrfTokenRepository = httpSessionCsrfTokenRepository;
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf()
            .csrfTokenRepository(csrfTokenRepository())
            .and()
                .authorizeRequests() // starting to authorize requests
                .antMatchers("/", "/index") 
                .permitAll() // on end point "/" permitting all requests
            .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**")
                .permitAll() // permitting all static files(css, js, images) to be accessable
            .antMatchers("/users/register") // on end point "/users/register" permitting all requests
                .permitAll()
            .antMatchers("/users/login") // on end point "/users/login" permitting all requests
                .permitAll()
            .antMatchers("/api/races/get-races-by-faction/Horde")
                .permitAll()
            .antMatchers("/api/races/get-races-by-faction/Alliance")
                .permitAll()
            .anyRequest()
                .authenticated() // any another request should be authenticated
            .and()
                .formLogin() // setting the login form
                .loginPage("/users/login") // setting the login page. It should be set on the end point
                .usernameParameter("username") // here should be the name of the html tag. If you login with email here should be email
                .passwordParameter("password") // here should be the name of the html tag.
                .successHandler(authSuccessHandler) // setting the handler on successfull authentication
                .failureHandler(authFailureHandler); // setting the handler for unsuccessfull authentication
    }

    /**
     * Setting globally the authentication to use the {@link UsersService}, which implements {@link 
     * UserDetailsService} and the {@link PasswordEncoder} for the password.
     * 
     * @param auth object of type {@link AuthenticationManagerBuilder} 
     * @throws Exception
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .userDetailsService(usersService)
            .passwordEncoder(passwordEncoder);
    }

    /**
     * Added the csrf token 
     * 
     * @return object of type {@link HttpSessionCsrfTokenRepository} 
     */
    private CsrfTokenRepository csrfTokenRepository() {
        httpSessionCsrfTokenRepository.setSessionAttributeName("_csrf");
        return httpSessionCsrfTokenRepository;
    }
}