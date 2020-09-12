/*
 * Copyright (c) 2020. Marc Kandel
 */

package com.mkandel.checklists.inbound.controllers;

import com.mkandel.checklists.utils.EmailValidator;
import com.mkandel.checklists.utils.Routes;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class APIv1Controller {

    @RequestMapping(Routes.BASE)
    public String apiRoot() {
        return "Welcome to the API version 1!";
    }

    @RequestMapping(Routes.HEALTH)
    public HashMap<String, String> health() {
        final HashMap<String, String> ret = new HashMap<>();
        ret.put("status", "ok");
        return ret;
    }

    @RequestMapping(Routes.TEAPOT)
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    public HttpStatus teapot() {
        return HttpStatus.I_AM_A_TEAPOT;
    }

    @GetMapping(Routes.VALIDATE_EMAIL)
    public Map<String, String> validateEmail(@PathVariable String email) {
        final Map<String, String> ret = new HashMap<>();
        ret.put("email", email);
        if (EmailValidator.validateEmail(email)) {
            ret.put("status", "ok");
        } else {
            ret.put("status", "invalid");
        }
        return ret;
    }
}
