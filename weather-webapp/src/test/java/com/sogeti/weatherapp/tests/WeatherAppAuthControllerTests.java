package com.sogeti.weatherapp.tests;

import com.sogeti.weatherapp.common.model.LoginCredentials;
import com.sogeti.weatherapp.common.model.User;
import com.sogeti.weatherapp.services.IAuthenticationService;
import com.sogeti.weatherapp.web.controllers.AuthController;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = AuthController.class)
public class WeatherAppAuthControllerTests {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    IAuthenticationService authService;


    @Test
    public void testGetLoginPage() throws Exception {
        mockMvc.perform(get("/login")).andExpect(status().isOk());
    }

    @Test
    public void testValidLoginScenario() throws Exception {
        //LoginCredentials credentials = new LoginCredentials("vvv", "vvv");
        when(authService.isUserValid(any())).thenReturn(new User());
        mockMvc.perform(post("/login").param("username", "vvv")
        .param("password", "vvv"))
                .andExpect(status().is3xxRedirection());
    }



}
