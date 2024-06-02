package com.nan.boilerplate.springboot.security.mapper;

import com.nan.boilerplate.springboot.model.User;
import com.nan.boilerplate.springboot.security.dto.AuthenticatedUserDto;
import com.nan.boilerplate.springboot.security.dto.RegistrationRequest;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-18T16:26:30+0900",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.9 (Amazon.com Inc.)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public User convertToUser(RegistrationRequest registrationRequest) {
        if ( registrationRequest == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.name( registrationRequest.getName() );
        user.username( registrationRequest.getUsername() );
        user.password( registrationRequest.getPassword() );
        user.email( registrationRequest.getEmail() );

        return user.build();
    }

    @Override
    public AuthenticatedUserDto convertToAuthenticatedUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        AuthenticatedUserDto authenticatedUserDto = new AuthenticatedUserDto();

        authenticatedUserDto.setName( user.getName() );
        authenticatedUserDto.setUsername( user.getUsername() );
        authenticatedUserDto.setPassword( user.getPassword() );
        authenticatedUserDto.setUserRole( user.getUserRole() );

        return authenticatedUserDto;
    }

    @Override
    public User convertToUser(AuthenticatedUserDto authenticatedUserDto) {
        if ( authenticatedUserDto == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.name( authenticatedUserDto.getName() );
        user.username( authenticatedUserDto.getUsername() );
        user.password( authenticatedUserDto.getPassword() );
        user.userRole( authenticatedUserDto.getUserRole() );

        return user.build();
    }
}
