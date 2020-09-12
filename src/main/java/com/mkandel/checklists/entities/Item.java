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
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
    private int itemTemplate;
    private boolean complete;
    private LocalDateTime completedDate;
    private int checklist;
}
