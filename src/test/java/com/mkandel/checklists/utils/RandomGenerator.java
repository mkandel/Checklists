/*
 * Copyright (c) 2018. Marc Kandel
 */

package com.mkandel.checklists.utils;

import org.apache.commons.text.RandomStringGenerator;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class RandomGenerator {

    public static String randomString(int length) {
        final RandomStringGenerator randomStringGenerator = new RandomStringGenerator.Builder()
                .withinRange('A', 'z')
                .filteredBy(Character::isLetter)
                .build();

        return randomStringGenerator.generate(length);
    }

    public static String randomString() {
        return randomString(8);
    }

    public static UUID randomUUID() {
        return UUID.randomUUID();
    }

    public static String randomUUIDString() {
        return randomUUID().toString();
    }

    public static int randomInteger(int floor, int ceiling) {
        assert floor <= ceiling : "floor must be less than ceiling!";
        return floor + ThreadLocalRandom.current().nextInt(ceiling - floor + 1);
    }

    public static int randomInteger(int ceiling) {
        return randomInteger(0, ceiling);
    }

    public static int randomInteger() {
        return randomInteger(999);
    }

    public static boolean randomBoolean() {
        return ThreadLocalRandom.current().nextBoolean();
    }

    public static <T> T randomEnum(Class<T> enumType) {
        final T[] values = enumType.getEnumConstants();
        return values[randomInteger(values.length - 1)];
    }

    public static String randomEmail() {
        return randomString() + "@" + randomString() + "." + randomString(3);
    }
}

