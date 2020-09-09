package com.mkandel.checklists.utils;

public class Routes {

    public final static String ROOT = "/api";
    public final static String BASE = ROOT + "/v1";
    // Housekeeping
    public static final String HEALTH = BASE + "/health";
    public static final String VALIDATE_EMAIL = BASE + "/validateEmail/{email}";
    // User Controller
    public static final String USERS = BASE + "/users";
    public static final String USER = BASE + "/user/{id}";
    public static final String USER_BY_USERNAME = BASE + "/userByUsername/{username}";
    // Testing.  TODO: Remove these eventually
    public static final String USERNAMES = BASE + "/usernames";
    public static final String USER_TYPES = USERS + "/types";
    public static final String ADD_USER = USER_BY_USERNAME + "/{username}/{email}/{displayname}/{active}";
    // Dummy route to play around with
    public static final String TEAPOT = BASE + "/teapot";
    private static LogUtil logger;
    private static boolean initHasRun = false;

    public Routes(LogUtil logger) {
        Routes.logger = logger;
        Routes.logger.trace("Routes: Constructor complete.");
    }
}
