package com.sogeti.weatherapp.tests;

import com.sogeti.weatherapp.common.model.User;
import com.sogeti.weatherapp.repositories.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest(showSql = true)
public class WeatherAppJpaTests {

    @Autowired
    UserRepository userRepository;

    @Test
    public void testIfGetUserQueryReturnValidUser(){
        User user = userRepository.findByUsernameAndPassword("vvv", "vvv");
        Assertions.assertThat(user.getUsername()).isEqualTo("vvv");
    }

    @Test
    public void testIfGetUserQueryReturnValidUserGivenName(){
        User user = userRepository.findByName("Vishal,S");
        Assertions.assertThat(user).isNotNull();
    }


}
