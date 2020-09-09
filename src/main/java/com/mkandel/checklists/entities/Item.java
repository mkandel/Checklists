package com.mkandel.checklists.entities;

import java.time.LocalDateTime;

public class Item {
    private int id;
    private int itemTemplate;
    private boolean complete;
    private LocalDateTime completedDate;
    private int checklist;
}
