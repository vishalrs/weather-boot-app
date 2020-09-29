package com.sogeti.weatherapp.services;

import com.sogeti.weatherapp.common.model.LoginCredentials;
import com.sogeti.weatherapp.common.model.User;

public interface IAuthenticationService {

    User isUserValid(LoginCredentials credentials);
}
