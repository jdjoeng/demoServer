package com.rest.web.advice.exception;

public class Exception401 extends RuntimeException {
    public Exception401(String msg, Throwable t) {
        super(msg, t);
    }

    public Exception401(String msg) {
        super(msg);
    }

    public Exception401() {
        super();
    }
}
