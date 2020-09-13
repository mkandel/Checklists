/*
 * Copyright (c) 2020. Marc Kandel
 */

package com.mkandel.checklists.inbound.dtos;

import com.mkandel.checklists.entities.Role;
import com.mkandel.checklists.entities.User;
import org.springframework.http.MediaType;

import java.util.List;

public class UsergroupDto {
    public static final String JSON_MIME_TYPE = "application/json;type=checklists-usergroup;version=1.0.0";
    public static final MediaType JSON_MEDIA_TYPE = MediaType.parseMediaType(JSON_MIME_TYPE);
    private String id;
    private String groupname;
    private List<Role> roles;
    private List<User> users;

    public UsergroupDto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
