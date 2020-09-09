package com.mkandel.checklists.utils;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("checklists")
public class Routes {
    public final String ROOT = "/api";
    public String BASE;
    // Housekeeping
    public String HEALTH;
    public String VALIDATE_EMAIL;
    // User Controller
    public String USERS;
    public String USER;
    public String USER_BY_USERNAME;
    // Testing
    public String USERNAMES;
    public String USER_TYPES;
    public String ADD_USER;
    // Dummy route to play around with
    public String TEAPOT;
    private String apiver;
    private boolean initHasRun = false;

    // apiver initializes really late, after the constructor anyway ...  I hate needing the Init() method but it works ...
    public void Init() {
        if (initHasRun) return;

        BASE = ROOT + apiver;

        HEALTH = BASE + "/health";
        VALIDATE_EMAIL = BASE + "/validateEmail/{email}";

        USERS = BASE + "/users";
        USER = BASE + "/user/{id}";
        USER_BY_USERNAME = BASE + "/userByUsername/{username}";

        // Testing
        USERNAMES = BASE + "/usernames";
        USER_TYPES = USERS + "/types";
        ADD_USER = BASE + "/userByUsername/{username}/{fName}/{lName}/{email}/{type}";

        // Dummy route to play around with
        TEAPOT = BASE + "/teapot";
        initHasRun = true;
    }

    public String getApiver() {
        return apiver;
    }

    public void setApiver(String apiver) {
        this.apiver = apiver;
    }
}
