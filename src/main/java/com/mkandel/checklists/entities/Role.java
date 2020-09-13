/*
 * Copyright (c) 2020. Marc Kandel
 */

package com.mkandel.checklists.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    private int id;
    private String rolename;

    public Role() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String name) {
        this.rolename = name;
    }
}
