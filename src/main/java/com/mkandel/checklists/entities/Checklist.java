/*
 * Copyright (c) 2020. Marc Kandel
 */

package com.mkandel.checklists.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "checklists")
public class Checklist {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
    private String name;
    private int checklistTemplate;
    private int creator;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private boolean complete;
    private LocalDateTime completedDate;
//    private List<Item> items;
}
