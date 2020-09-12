/*
 * Copyright (c) 2020. Marc Kandel
 */

package com.mkandel.checklists.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
