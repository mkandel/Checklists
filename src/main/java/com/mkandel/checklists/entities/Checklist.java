package com.mkandel.checklists.entities;

import javax.persistence.*;
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
