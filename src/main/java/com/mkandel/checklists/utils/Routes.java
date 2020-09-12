/*
 * Copyright (c) 2020. Marc Kandel
 */

package com.mkandel.checklists.utils;

public class Routes {
    // Root and base URLs
    public final static String ROOT = "/api";
    public final static String BASE = ROOT + "/v1";
    // Housekeeping
    public static final String HEALTH = BASE + "/health";
    public static final String VALIDATE_EMAIL = BASE + "/validate-email/{email}";
    // Users
    public static final String USERS = BASE + "/users";
    public static final String USER = BASE + "/user/{id}";
    // Roles
    public static final String ROLES = BASE + "/roles";
    public static final String ROLE = BASE + "/role/{id}";
    // UserRoles
    public static final String USER_ROLES = BASE + "/user-roles";
    public static final String USER_ROLE = BASE + "/user-role/{id}";

    // Testing.  TODO: Remove these eventually
    public static final String USER_BY_USERNAME = BASE + "/user-by-username/{username}";
    public static final String USERNAMES = BASE + "/usernames";
    public static final String ADD_USER = USER_BY_USERNAME + "/{username}/{email}/{displayname}/{active}";
    // Dummy route to play around with
    public static final String TEAPOT = BASE + "/teapot";
}
