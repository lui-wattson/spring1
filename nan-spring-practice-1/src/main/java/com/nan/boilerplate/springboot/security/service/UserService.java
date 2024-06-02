package com.nan.boilerplate.springboot.security.service;

import com.nan.boilerplate.springboot.model.User;
import com.nan.boilerplate.springboot.security.dto.AuthenticatedUserDto;
import com.nan.boilerplate.springboot.security.dto.RegistrationRequest;
import com.nan.boilerplate.springboot.security.dto.RegistrationResponse;


public interface UserService {

    User findByUsername(String username);

    RegistrationResponse registration(RegistrationRequest registrationRequest);

    AuthenticatedUserDto findAuthenticatedUserByUsername(String username);

}
