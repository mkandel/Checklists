package com.mkandel.checklists.entities;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int Id;
    private String Name;
}
