package com.nan.boilerplate.springboot.security.dto;

import com.nan.boilerplate.springboot.model.UserRole;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class AuthenticatedUserDto {

    private String name;

    private String username;

    private String password;

    private UserRole userRole;

}
