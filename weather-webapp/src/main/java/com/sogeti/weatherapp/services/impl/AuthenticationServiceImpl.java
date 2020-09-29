package com.sogeti.weatherapp.services.impl;


import com.sogeti.weatherapp.common.model.LoginCredentials;
import com.sogeti.weatherapp.common.model.User;
import com.sogeti.weatherapp.repositories.UserRepository;
import com.sogeti.weatherapp.services.IAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements IAuthenticationService {

    @Autowired
    UserRepository repository;


    public User isUserValid(LoginCredentials credentials){
        User user = repository.findByUsernameAndPassword(credentials.getUsername(), credentials.getPassword());
        return user;
    }
}
