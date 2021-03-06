package com.DevilsQuest.app.web.view.controllers.auth;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.DevilsQuest.app.data.models.services.auth.RegisterUserServiceModel;
import com.DevilsQuest.app.data.models.views.auth.RegisterUserViewModel;
import com.DevilsQuest.app.services.AuthService;
import com.DevilsQuest.app.services.AuthenticatedUserService;
import com.DevilsQuest.app.validation.auth.AuthValidationService;
import com.DevilsQuest.app.web.base.BaseController;

import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/users")
public class AuthController extends BaseController {
    private final static String USER_LOGIN_VIEW_NAME = "auth/login";

    private final static String USER_REGISTER_VIEW_NAME = "auth/register";

    private final static String USER_REDIRECT_VIEW_NAME = "/users/login";

    private final AuthenticatedUserService authenticatedUserService;

    private final AuthValidationService authValidationService;

    private final AuthService authService;

    private final ModelMapper mapper;

    public AuthController(
        AuthenticatedUserService authenticatedUserService,
        AuthValidationService authValidationService, 
        AuthService authService, 
        ModelMapper mapper) {
            this.authenticatedUserService = authenticatedUserService;
            this.authValidationService = authValidationService;
            this.authService = authService;
            this.mapper = mapper;
    }

    @ModelAttribute("userRegisterViewModel")
    public RegisterUserViewModel getRegisterUserModel() {
        return new RegisterUserViewModel();
    }

    @GetMapping("/login")
    public ModelAndView getLoginForm() {
        return super.view(USER_LOGIN_VIEW_NAME);
    }
    
    @GetMapping("/logout")
    public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = authenticatedUserService.getAuthentication();
        if (auth != null){    
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }

        return super.redirect(USER_REDIRECT_VIEW_NAME);
    }

    @GetMapping("/register")
    public ModelAndView getRegisterForm(@ModelAttribute("userRegisterViewModel") RegisterUserViewModel model) {
        return super.view(USER_REGISTER_VIEW_NAME);
    }

    @PostMapping("/register")
    public ModelAndView register(@Valid @ModelAttribute("userRegisterViewModel") RegisterUserViewModel model, BindingResult bindingResult, ModelAndView modelAndView) throws IOException {
        if (bindingResult.hasErrors()) {
            return super.view(USER_REGISTER_VIEW_NAME);
        } else {            
            RegisterUserServiceModel serviceModel = mapper.map(model, RegisterUserServiceModel.class);
            
            // After we get the validated input from the user validated by using the spring annotations(not null, the size of the fiels) we need to make some extra validating like is the username free, are the passwords equals and maybe check the email using some regex. I check the whole form and after the all fo the input fields are entered then it will go here and add the new messages for the specific input field(username is not free, email is not correct, the passwords are not equals)
            if(!authValidationService.isValid(serviceModel, model.getImage(), modelAndView)) {
                return super.view(USER_REGISTER_VIEW_NAME, modelAndView);
            } else {
                authService.register(serviceModel, model.getImage());

                return super.redirect(USER_REDIRECT_VIEW_NAME);
            }
        }
    }      
}