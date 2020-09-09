/*
 * Copyright (c) 2018. Marc Kandel
 */

package com.mkandel.checklists.inbound.converters;

import com.mkandel.checklists.entities.User;
import com.mkandel.checklists.inbound.dtos.UserDto;
import org.modelmapper.ModelMapper;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class UserConverter {
    private static final ModelMapper modelMapper = new ModelMapper();

    public static User toUser(UserDto dto) {
        return modelMapper.map(dto, User.class);
    }

    public static List<User> toUser(List<UserDto> dtos) {
        return dtos.stream()
                .map(UserConverter::toUser)
                .collect(toList());
    }

    public static UserDto toUserDto(User user) {
        return modelMapper.map(user, UserDto.class);
    }

    public static List<UserDto> toUserDto(List<User> users) {
        return users.stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .collect(toList());
    }
}
