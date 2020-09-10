package com.mkandel.checklists.inbound.converters;

import com.mkandel.checklists.entities.UserRole;
import com.mkandel.checklists.inbound.dtos.UserRoleDto;
import org.modelmapper.ModelMapper;

import java.util.Collection;

import static java.util.stream.Collectors.toList;

public class UserRoleConverter {
    private static final ModelMapper modelMapper = new ModelMapper();

    public static UserRole toUserRole(UserRoleDto dto) {
        return modelMapper.map(dto, UserRole.class);
    }

    public static Collection<UserRole> toUserRoles(Collection<UserRoleDto> dtos) {
        return dtos.stream()
                .map(UserRoleConverter::toUserRole)
                .collect(toList());
    }

    public static UserRoleDto toUserRoleDto(UserRole userRole) {
        return modelMapper.map(userRole, UserRoleDto.class);
    }

    public static Collection<UserRoleDto> toUserRoleDtos(Collection<UserRole> userRoles) {
        return userRoles.stream()
                .map(UserRoleConverter::toUserRoleDto)
                .collect(toList());
    }
}
