package com.mkandel.checklists.inbound.dtos;

import org.springframework.http.MediaType;

public class UserRoleDto {
    public static final String JSON_MIME_TYPE = "application/json;type=checklists-user-role;version=1.0.0";
    public static final MediaType JSON_MEDIA_TYPE = MediaType.parseMediaType(JSON_MIME_TYPE);
    private String id;
    private int user;
    private int role;

    public UserRoleDto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
