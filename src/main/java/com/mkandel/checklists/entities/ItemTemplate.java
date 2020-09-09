package com.mkandel.checklists.entities;

import javax.persistence.*;

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
