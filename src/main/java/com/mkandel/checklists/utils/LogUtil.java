/*
 * Copyright (c) 2020. Marc Kandel
 */

package com.mkandel.checklists.utils;

import com.mkandel.checklists.ChecklistsApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class LogUtil {
    private final Logger logger;

    public LogUtil() {
        logger = LoggerFactory.getLogger(ChecklistsApplication.class);
        logger.trace("LogUtil: Constructor complete.");
    }

    public void info(String message) {
        logger.info(message);
    }

    public void debug(String message) {
        logger.debug(message);
    }

    public void warn(String message) {
        logger.warn(message);
    }

    public void trace(String message) {
        logger.trace(message);
    }

    public void error(String message) {
        logger.error(message);
    }
}
