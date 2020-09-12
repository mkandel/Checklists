package com.mkandel.checklists.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "usergroups")
public class Usergroup {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
    private String groupname;
    //    private List<User> usergroupUsers;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "usergroup_roles",
            joinColumns = @JoinColumn(name = "usergroup"),
            inverseJoinColumns = @JoinColumn(name = "role"))
    private List<Role> usergroupRoles;

    public Usergroup() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public List<Role> getUsergroupRoles() {
        return usergroupRoles;
    }

    public void setUsergroupRoles(List<Role> usergroupRoles) {
        this.usergroupRoles = usergroupRoles;
    }
}
