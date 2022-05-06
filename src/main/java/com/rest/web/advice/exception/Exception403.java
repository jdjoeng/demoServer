package com.rest.web.advice.exception;

public class Exception403 extends RuntimeException {
    public Exception403(String msg, Throwable t) {
        super(msg, t);
    }

    public Exception403(String msg) {
        super(msg);
    }

    public Exception403() {
        super();
    }
}
