/*
 * Copyright (c) 2020. Marc Kandel
 */

package com.mkandel.checklists.inbound.entities;

import com.mkandel.checklists.BaseUnitTest;
import com.mkandel.checklists.entities.User;
import com.mkandel.checklists.inbound.entities.builders.UserBuilder;
import org.junit.Test;

import java.util.List;
import java.util.stream.Stream;

import static com.mkandel.checklists.utils.RandomGenerator.randomInteger;
import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

public class UserUnitTest extends BaseUnitTest {

    int size = randomInteger(5, 10);
    List<User> users = Stream
            .generate(() ->
                    new UserBuilder()
                            .withid()
                            .build())
            .limit(size)
            .collect(toList());

    @Test
    public void testOne() {
        assertThat(users).isNotNull();
        assertThat(users).hasSize(size);
    }

}