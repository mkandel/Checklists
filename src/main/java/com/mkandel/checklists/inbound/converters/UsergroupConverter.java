/*
 * Copyright (c) 2020. Marc Kandel
 */

package com.mkandel.checklists.inbound.converters;

import com.mkandel.checklists.entities.User;
import com.mkandel.checklists.entities.Usergroup;
import com.mkandel.checklists.inbound.dtos.UsergroupDto;
import com.mkandel.checklists.inbound.dtos.UsernameDto;
import org.modelmapper.ModelMapper;

import java.util.Collection;

import static java.util.stream.Collectors.toList;

public class UsergroupConverter {
    private static final ModelMapper modelMapper = new ModelMapper();

    public static Usergroup toUsergroup(UsergroupDto dto) {
        return modelMapper.map(dto, Usergroup.class);
    }

    public static Collection<Usergroup> toUsergroups(Collection<UsergroupDto> dtos) {
        return dtos.stream()
                .map(UsergroupConverter::toUsergroup)
                .collect(toList());
    }

    public static UsergroupDto toUsergroupDto(Usergroup usergroup) {
        modelMapper.typeMap(User.class, UsernameDto.class).addMapping(User::getUsername, UsernameDto::setUsername);
        return modelMapper.map(usergroup, UsergroupDto.class);
    }

    public static Collection<UsergroupDto> toUsergroupDtos(Collection<Usergroup> usergroups) {
        return usergroups.stream()
                .map(UsergroupConverter::toUsergroupDto)
                .collect(toList());
    }
}
