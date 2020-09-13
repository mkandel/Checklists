/*
 * Copyright (c) 2020. Marc Kandel
 */

package com.mkandel.checklists.inbound.converters;

import com.mkandel.checklists.entities.User;
import com.mkandel.checklists.inbound.dtos.UserDto;
import com.mkandel.checklists.inbound.dtos.UsernameDto;
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
                .map(UserConverter::toUserDto)
                .collect(toList());
    }

    public static UsernameDto toUsernameDto(User user) {
        return modelMapper.map(user, UsernameDto.class);
    }

    public static Collection<UsernameDto> toUsernameDtos(Collection<User> users) {
        return users.stream()
                .map(UserConverter::toUsernameDto)
                .collect(toList());
    }
}
