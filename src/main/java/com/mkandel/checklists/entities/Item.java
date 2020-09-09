package com.mkandel.checklists.entities;

import javax.persistence.*;
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
