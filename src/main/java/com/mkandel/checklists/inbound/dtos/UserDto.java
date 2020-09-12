/*
 * Copyright (c) 2020. Marc Kandel
 */

package com.mkandel.checklists.inbound.dtos;

import com.mkandel.checklists.entities.Checklist;
import com.mkandel.checklists.entities.Role;
import com.mkandel.checklists.entities.Usergroup;
import org.springframework.http.MediaType;

import java.util.List;

public class UserDto {
    public static final String JSON_MIME_TYPE = "application/json;type=checklists-user;version=1.0.0";
    public static final MediaType JSON_MEDIA_TYPE = MediaType.parseMediaType(JSON_MIME_TYPE);
    private String id;
    private String username;
    private String email;
    private String displayname;
    private boolean active;
    private List<Role> roles;
    private List<Usergroup> usergroups;
    private List<Checklist> assignedChecklists;

    public UserDto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getDisplayname() {
        return displayname;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roleDtos) {
        this.roles = roleDtos;
    }

    public List<Usergroup> getUsergroups() {
        return usergroups;
    }

    public void setUsergroups(List<Usergroup> usergroups) {
        this.usergroups = usergroups;
    }

    public List<Checklist> getAssignedChecklists() {
        return assignedChecklists;
    }

    public void setAssignedChecklists(List<Checklist> assignedChecklists) {
        this.assignedChecklists = assignedChecklists;
    }
}
