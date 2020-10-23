package com.sogeti.weatherapp.web.controllers;


import com.sogeti.weatherapp.common.exceptions.UserNotFoundException;
import com.sogeti.weatherapp.common.model.LoginCredentials;
import com.sogeti.weatherapp.common.model.User;
import com.sogeti.weatherapp.services.IAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class AuthController {

    @Autowired
    public IAuthenticationService authService;

    @GetMapping(value = "/")
    public String defaultRedirect(){
        return "redirect:/login";
    }

    @GetMapping(value = "/login")
    public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView("login", "credentials", new LoginCredentials());
    }

    @PostMapping(value = "/login")
    public String login(HttpSession session, @Valid @ModelAttribute("credentials") LoginCredentials credentials) {
        User user = authService.isUserValid(credentials);
        if(user == null){
            throw new UserNotFoundException("User not found, credentials are invalid");
        }
        session.setAttribute("authUser", user);
        return"redirect:/web/weather";
    }



}
