/*
 * Copyright (c) 2020. Marc Kandel
 */

package com.mkandel.checklists.inbound.controllers;

import com.mkandel.checklists.entities.Usergroup;
import com.mkandel.checklists.exceptions.UsergroupNotFoundException;
import com.mkandel.checklists.inbound.converters.UsergroupConverter;
import com.mkandel.checklists.inbound.dtos.UsergroupDto;
import com.mkandel.checklists.outbound.repositories.UsergroupRepository;
import com.mkandel.checklists.utils.Routes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import static com.mkandel.checklists.utils.ErrorMessageConstants.NO_SUCH_USERGROUP;
import static com.mkandel.checklists.utils.ErrorMessageConstants.USERGROUP_DOES_NOT_EXIST;

@RestController
public class UsergroupController {

    private final UsergroupRepository usergroupRepository;

    @Autowired
    public UsergroupController(UsergroupRepository usergroupRepository) {
        this.usergroupRepository = usergroupRepository;
    }

    @GetMapping(value = Routes.USERGROUPS, produces = UsergroupDto.JSON_MIME_TYPE)
    public Collection<UsergroupDto> usergroups() {

        return UsergroupConverter.toUsergroupDtos(new ArrayList<>(usergroupRepository.findAll()));
    }

    @GetMapping(value = Routes.USERGROUP, produces = UsergroupDto.JSON_MIME_TYPE)
    public UsergroupDto usergroupById(@PathVariable int id) throws UsergroupNotFoundException {
        return processOptionalUsergroup(usergroupRepository.findById(id), NO_SUCH_USERGROUP + id);
    }

    @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
    private <T> UsergroupDto processOptionalUsergroup(Optional<Usergroup> optionalUsergroup, T exceptionMessage) throws UsergroupNotFoundException {
        return optionalUsergroup
                .stream()
                .findFirst()
                .map(UsergroupConverter::toUsergroupDto)
                .orElseThrow(() -> new UsergroupNotFoundException(USERGROUP_DOES_NOT_EXIST + exceptionMessage));
    }
}
