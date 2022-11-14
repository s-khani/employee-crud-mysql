package com.sprogram.employeeWithMySql.exception;

public class NotFoundEmployeeException extends RuntimeException {

    public NotFoundEmployeeException() {
    }

    public NotFoundEmployeeException(String message) {
        super(message);
    }

    public NotFoundEmployeeException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundEmployeeException(Throwable cause) {
        super(cause);
    }

    public NotFoundEmployeeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
