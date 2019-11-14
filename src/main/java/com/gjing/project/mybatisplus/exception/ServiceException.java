package com.gjing.project.mybatisplus.exception;

/**
 * Service层异常
 * @author Gjing
 **/
public class ServiceException extends RuntimeException {
    public ServiceException(String message) {
        super(message);
    }
}
