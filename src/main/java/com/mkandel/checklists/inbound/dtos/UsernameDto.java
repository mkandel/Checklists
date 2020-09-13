/*
 * Copyright (c) 2020. Marc Kandel
 */

package com.mkandel.checklists.inbound.dtos;

import org.springframework.http.MediaType;

public class UsernameDto {
    public static final String JSON_MIME_TYPE = "application/json;type=checklists-username;version=1.0.0";
    public static final MediaType JSON_MEDIA_TYPE = MediaType.parseMediaType(JSON_MIME_TYPE);
    private String username;


    public UsernameDto() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
