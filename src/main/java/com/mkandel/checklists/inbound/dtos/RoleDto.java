/*
 * Copyright (c) 2020. Marc Kandel
 */

package com.mkandel.checklists.inbound.dtos;

import org.springframework.http.MediaType;

public class RoleDto {
    public static final String JSON_MIME_TYPE = "application/json;type=checklists-role;version=1.0.0";
    public static final MediaType JSON_MEDIA_TYPE = MediaType.parseMediaType(JSON_MIME_TYPE);
    private String id;
    private String rolename;

    public RoleDto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
}
