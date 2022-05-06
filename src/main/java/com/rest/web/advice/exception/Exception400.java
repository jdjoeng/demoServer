package com.rest.web.advice.exception;

public class Exception400 extends RuntimeException {
    public Exception400(String msg, Throwable t) {
        super(msg, t);
    }

    public Exception400(String msg) {
        super(msg);
    }

    public Exception400() {
        super();
    }
}
