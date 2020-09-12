/*
 * Copyright (c) 2020. Marc Kandel
 */

package com.mkandel.checklists.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Collection;

@Entity
@Table(name = "users")
public class User {
    @Id
    private int id;
    private String username;
    private String email;
    private String displayname;
    private boolean active;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Collection<Role> roles;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_usergroups",
            joinColumns = @JoinColumn(name = "user"),
            inverseJoinColumns = @JoinColumn(name = "usergroup"))
    private Collection<Usergroup> usergroups;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "checklist_assignees",
            joinColumns = @JoinColumn(name = "user"),
            inverseJoinColumns = @JoinColumn(name = "checklist"))
    private Collection<Checklist> assignedChecklists;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getDisplayname() {
        return displayname;
    }

    public void setDisplayname(String displayName) {
        this.displayname = displayName;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public User() {
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    public Collection<Usergroup> getUsergroups() {
        return usergroups;
    }

    public void setUsergroups(Collection<Usergroup> usergroups) {
        this.usergroups = usergroups;
    }

    public Collection<Checklist> getAssignedChecklists() {
        return assignedChecklists;
    }

    public void setAssignedChecklists(Collection<Checklist> assignedChecklists) {
        this.assignedChecklists = assignedChecklists;
    }
}
