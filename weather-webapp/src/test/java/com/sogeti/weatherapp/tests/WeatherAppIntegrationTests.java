package com.sogeti.weatherapp.tests;

import com.sogeti.weatherapp.common.model.User;
import com.sogeti.weatherapp.repositories.UserRepository;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@ActiveProfiles("acc")
@AutoConfigureMockMvc
public class WeatherAppIntegrationTests {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    UserRepository userRepository;

    @Test
    public void testGetCurrentWeatherInfo() throws Exception {
        User user = userRepository.findByName("Vishal,S");
        mockMvc.perform(get("/web/weather").sessionAttr("authUser", user))
                .andExpect(status().isOk())
                .andExpect(view().name("weather"))
                .andExpect(content().string(Matchers.containsString("Weather")));
    }
}
