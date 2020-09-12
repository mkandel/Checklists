/*
 * Copyright (c) 2018. Marc Kandel
 */

package com.mkandel.checklists.inbound.converters;

import com.mkandel.checklists.entities.User;
import com.mkandel.checklists.inbound.dtos.UserDto;
import org.modelmapper.ModelMapper;

import java.util.Collection;

import static java.util.stream.Collectors.toList;

public class UserConverter {
    private static final ModelMapper modelMapper = new ModelMapper();

    public static User toUser(UserDto dto) {
        return modelMapper.map(dto, User.class);
    }

    public static Collection<User> toUsers(Collection<UserDto> dtos) {
        return dtos.stream()
                .map(UserConverter::toUser)
                .collect(toList());
    }

    public static UserDto toUserDto(User user) {
        return modelMapper.map(user, UserDto.class);
    }

    public static Collection<UserDto> toUserDtos(Collection<User> users) {
        return users.stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .collect(toList());
    }

//    public class RolesListConverter extends AbstractConverter<Collection<Role>, Collection<String>> {
//
//        @Override
//        protected Collection<String> convert(Collection<Role> roles) {
//
//            return roles
//                    .stream()
//                    .map(Role::getName)
//                    .collect(Collectors.toList());
//        }
//    }
}
