package com.sprogram.employeeWithMySql.exception;

public class MobileNumberNotAllowedException extends RuntimeException {
    public MobileNumberNotAllowedException() {
    }

    public MobileNumberNotAllowedException(String message) {
        super(message);
    }

    public MobileNumberNotAllowedException(String message, Throwable cause) {
        super(message, cause);
    }

    public MobileNumberNotAllowedException(Throwable cause) {
        super(cause);
    }

    public MobileNumberNotAllowedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
