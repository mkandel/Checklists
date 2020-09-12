/*
 * Copyright (c) 2020. Marc Kandel
 */

package com.mkandel.checklists.inbound.converters;

import com.mkandel.checklists.entities.Role;
import com.mkandel.checklists.inbound.dtos.RoleDto;
import org.modelmapper.ModelMapper;

import java.util.Collection;

import static java.util.stream.Collectors.toList;

public class RoleConverter {
    private static final ModelMapper modelMapper = new ModelMapper();

    public static Role toRole(RoleDto dto) {
        return modelMapper.map(dto, Role.class);
    }

    public static Collection<Role> toRoles(Collection<RoleDto> dtos) {
        return dtos.stream()
                .map(RoleConverter::toRole)
                .collect(toList());
    }

    public static RoleDto toRoleDto(Role Role) {
        return modelMapper.map(Role, RoleDto.class);
    }

    public static Collection<RoleDto> toRoleDtos(Collection<Role> Roles) {
        return Roles.stream()
                .map(RoleConverter::toRoleDto)
                .collect(toList());
    }
}
