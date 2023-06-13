package com.example;

/**
 * ServiceException
 *
 * @author TomLuo
 * @date 2023年06月04日 20:45
 */
public class ServiceException extends RuntimeException {
    public ServiceException(String msg) {
        super(msg);
    }
}