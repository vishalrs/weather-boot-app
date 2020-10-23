package com.sogeti.weatherapp.common.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginCredentials {

    @NotBlank
    private String username;
    @NotBlank
    private String password;

}
