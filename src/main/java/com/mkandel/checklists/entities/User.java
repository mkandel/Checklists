package com.mkandel.checklists.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Collection;

@Entity
@Table(name = "users")
public class User {
    @Id
//    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
    private String username;
    private String email;
    private String displayname;
    private boolean active;
    //    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "users")
    @OneToMany(fetch = FetchType.LAZY)
//    @JoinTable(name = "user_roles")
//    @JoinColumn(name = "user")
    private Collection<Role> roles;
//    private List<Role> roles;
//    private List<Usergroup> usergroups;
//    private List<Checklist> assignedChecklists;
//    private List<Checklist> createdChecklists;

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
}
