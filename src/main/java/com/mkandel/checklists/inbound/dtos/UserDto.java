/*
 * Copyright (c) 2018. Marc Kandel
 */

package com.mkandel.checklists.inbound.dtos;

import org.springframework.http.MediaType;

public class UserDto {
    public static final String JSON_MIME_TYPE = "application/json;type=checklists-user;version=1.0.0";
    public static final MediaType JSON_MEDIA_TYPE = MediaType.parseMediaType(JSON_MIME_TYPE);
    private String id;
    private String username;
    private String email;
    private String displayname;
    private boolean active;

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


}
