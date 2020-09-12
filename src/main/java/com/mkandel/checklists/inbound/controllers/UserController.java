package com.mkandel.checklists.inbound.controllers;

import com.mkandel.checklists.entities.User;
import com.mkandel.checklists.exceptions.UserNotFoundException;
import com.mkandel.checklists.inbound.converters.UserConverter;
import com.mkandel.checklists.inbound.dtos.RoleDto;
import com.mkandel.checklists.inbound.dtos.UserDto;
import com.mkandel.checklists.outbound.repositories.UserRepository;
import com.mkandel.checklists.utils.Routes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import static com.mkandel.checklists.utils.ErrorMessageConstants.NO_SUCH_USERNAME;
import static com.mkandel.checklists.utils.ErrorMessageConstants.NO_SUCH_USER_ID;
import static com.mkandel.checklists.utils.ErrorMessageConstants.USER_DOES_NOT_EXIST;

@RestController
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping(value = Routes.USERS, produces = RoleDto.JSON_MIME_TYPE)
    public Collection<UserDto> users() {

        return UserConverter.toUserDtos(new ArrayList<>(userRepository.findAll()));
    }

    @GetMapping(value = Routes.USER, produces = RoleDto.JSON_MIME_TYPE)
    public UserDto userById(@PathVariable int id) throws UserNotFoundException {
        final Optional<User> optionalUser = userRepository.findById(id);
        return processOptionalUser(optionalUser, NO_SUCH_USER_ID + id);
    }

    @GetMapping(value = Routes.USER_BY_USERNAME, produces = RoleDto.JSON_MIME_TYPE)
    public UserDto userByUsername(@PathVariable String username) throws UserNotFoundException {
        final Optional<User> optionalUser = userRepository.findByUsername(username);
        return processOptionalUser(optionalUser, NO_SUCH_USERNAME + username);
    }

    @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
    private <T> UserDto processOptionalUser(Optional<User> optionalUser, T exceptionMessage) throws UserNotFoundException {
        return optionalUser
                .stream()
                .findFirst()
                .map(UserConverter::toUserDto)
                .orElseThrow(() -> new UserNotFoundException(USER_DOES_NOT_EXIST + exceptionMessage));
    }
}
