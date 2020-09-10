package com.mkandel.checklists.inbound.controllers;

import com.mkandel.checklists.entities.User;
import com.mkandel.checklists.exceptions.UserNotFoundException;
import com.mkandel.checklists.inbound.converters.UserConverter;
import com.mkandel.checklists.inbound.dtos.RoleDto;
import com.mkandel.checklists.inbound.dtos.UserDto;
import com.mkandel.checklists.outbound.repositories.RoleRepository;
import com.mkandel.checklists.outbound.repositories.UserRepository;
import com.mkandel.checklists.outbound.repositories.UserRolesRepository;
import com.mkandel.checklists.utils.Routes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@RestController
public class UserController {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserRolesRepository userRolesRepository;

    @Autowired
    public UserController(UserRepository userRepository,
                          RoleRepository roleRepository,
                          UserRolesRepository userRolesRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.userRolesRepository = userRolesRepository;
    }

    @GetMapping(value = Routes.USERS, produces = RoleDto.JSON_MIME_TYPE)
    public List<UserDto> users() {

        return userRepository.findAll()
                .stream()
                .map(UserConverter::toUserDto)
                .collect(toList());
    }

    @GetMapping(value = Routes.USER, produces = RoleDto.JSON_MIME_TYPE)
    public UserDto userById(@PathVariable int id) throws UserNotFoundException {
        final Optional<User> optionalUser = userRepository.findById(id);
        return processOptionalUser(optionalUser, "No user with id '" + id + "' exists.");
    }

    @GetMapping(value = Routes.USER_BY_USERNAME, produces = RoleDto.JSON_MIME_TYPE)
    public UserDto userByUsername(@PathVariable String username) throws UserNotFoundException {
        final Optional<User> optionalUser = userRepository.findByUsername(username);
        return processOptionalUser(optionalUser, "No user with username '" + username + "' exists.");
    }

    @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
    private <T> UserDto processOptionalUser(Optional<User> optionalUser, T exceptionMessage) throws UserNotFoundException {
        return optionalUser
                .stream()
                .findFirst()
                .map(UserConverter::toUserDto)
                .orElseThrow(() -> new UserNotFoundException("User does not exist: '" + exceptionMessage + "'"));
    }
}
