/*
 * Copyright (c) 2020. Marc Kandel
 */

package com.mkandel.checklists.inbound.entities.builders;

import com.mkandel.checklists.entities.Role;
import com.mkandel.checklists.entities.User;

import java.util.List;

import static com.mkandel.checklists.utils.RandomGenerator.*;

public class UserBuilder implements Builder<User> {

    private int id = randomInteger();
    private String username = randomString();
    private String email = randomEmail();
    private String displayName = randomString();
    private Boolean active = randomBoolean();
    private List<Role> roles;
//    private UsOerType type = randomEnum(UserType.class);

    @Override
    public User build() {
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setEmail(email);
        user.setDisplayname(displayName);
        user.setActive(active);

        return user;
    }

    public UserBuilder withId(int id) {
        this.id = id;
        return this;
    }

    public UserBuilder withid() {
        return this.withId(randomInteger());
    }

    public UserBuilder withUsername(String username) {
        this.username = username;
        return this;
    }

    public UserBuilder withUsername() {
        return this.withUsername(randomString());
    }

    public UserBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public UserBuilder withEmail() {
        return this.withEmail(randomString());
    }

    public UserBuilder withDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    public UserBuilder withDisplayName() {
        return this.withDisplayName(randomString());
    }

    public UserBuilder withActive(Boolean active) {
        this.active = active;
        return this;
    }

    public UserBuilder UserBuilderwithActive() {
        return this.withActive(randomBoolean());
    }
}
