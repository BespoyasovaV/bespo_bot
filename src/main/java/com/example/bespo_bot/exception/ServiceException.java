package com.example.bespo_bot.exception;

/**
 * @author BespoyasovaV
 */
public class ServiceException extends Exception {
    public ServiceException(String message, Throwable throwable) {
        super(message, throwable);
    }

}
