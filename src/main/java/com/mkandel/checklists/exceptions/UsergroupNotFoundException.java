/*
 * Copyright (c) 2020. Marc Kandel
 */

package com.mkandel.checklists.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UsergroupNotFoundException extends Exception {

    public UsergroupNotFoundException(String message) {
        super(message);
    }
}
