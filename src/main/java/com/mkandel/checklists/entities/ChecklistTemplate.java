package com.mkandel.checklists.entities;

import javax.persistence.*;

@Entity
@Table(name = "checklist_templates")
public class ChecklistTemplate {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
    private int creator;
    private String name;
//    private List<ItemTemplate> itemTemplates;
}
