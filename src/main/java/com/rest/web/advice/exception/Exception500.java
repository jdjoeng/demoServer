package com.rest.web.advice.exception;

public class Exception500 extends RuntimeException {
    public Exception500(String msg, Throwable t) {
        super(msg, t);
    }

    public Exception500(String msg) {
        super(msg);
    }

    public Exception500() {
        super();
    }
}
