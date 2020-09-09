package com.mkandel.checklists.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    private int id;
    private String username;
    private String email;
    private String displayName;
    private boolean active;
//    private List<Role> roles;
//    private List<Usergroup> usergroups;
//    private List<Checklist> assignedChecklists;
//    private List<Checklist> createdChecklists;
}
