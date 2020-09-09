package com.mkandel.checklists.entities;

import javax.persistence.*;

@Entity
@Table(name = "usergroups")
public class Usergroup {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
    private String groupname;
//    private List<User> usergroupUsers;
//    private List<Role> usergroupRoles;
}
