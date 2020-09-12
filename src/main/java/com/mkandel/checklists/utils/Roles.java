/*
 * Copyright (c) 2020. Marc Kandel
 */

package com.mkandel.checklists.utils;

public enum Roles {
    USER(1, "User"),
    CREATOR(2, "Creator"),
    ASSIGNER(3, "Assigner"),
    ADMIN(4, "Administrator");

    private final double id;
    private final String text;

    Roles(double id, String text) {
        this.id = id;
        this.text = text;
    }

    public double getId() {
        return id;
    }

    public String getText() {
        return text;
    }
}
