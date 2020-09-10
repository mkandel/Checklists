package com.mkandel.checklists.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Collection;

@Entity
@Table(name = "user_roles")
public class UserRole {
    @Id
//    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "user")
    private Collection<User> users;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role")
    private Role role;

    public UserRole() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
