package com.DevilsQuest.app.web.controllers.base;

import org.springframework.web.servlet.ModelAndView;

public class BaseController {
    /**
     * Method for returning template to show to the user, but this time you pass the view and object of type {@link ModelAndView} and you can use it to add the objects you want to display in the view.
     */
    public ModelAndView view(String viewName, ModelAndView modelAndView) {
        modelAndView.setViewName(viewName);

        return modelAndView;
    }

    /**
     * Method for returning template to show to the user on register,login,create hero and etc...
     * 
     * @param viewName the name of the template to show
     * @return object of type {@link ModelAndView}
     */
    public ModelAndView view(String viewName) {
        return this.view(viewName, new ModelAndView());
    }

    /**
     * Method for redirecting the user to different templates, cause many times i need to use "redirect:/users/login" and i extracted it in a method.
     * 
     * @param url the url which youw ant to redirect to the user("/users/login after successful registration")
     * @return object of type {@link ModelAndView}
     */
    public ModelAndView redirect(String url) {
        return this.view("redirect:" + url);
    }
}