package com.mkandel.checklists.entities;

import java.time.LocalDateTime;

public class Checklist {
    private int id;
    private String name;
    private int checklistTemplate;
    private int creator;
    private LocalDateTime createDate;
    private LocalDateTime updatrDate;
    private boolean complete;
    private LocalDateTime completedDate;
//    private List<Item> items;
}
