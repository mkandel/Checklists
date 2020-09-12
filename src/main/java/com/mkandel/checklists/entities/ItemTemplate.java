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
@Table(name = "item_templates")
public class ItemTemplate {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
    private String name;
    private String text;
    private int position;
    private int checklistTemplate;
}
