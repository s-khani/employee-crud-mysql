package com.sprogram.employeeWithMySql.exception;

public class EmployeeAlreadyExistException extends RuntimeException {
    public EmployeeAlreadyExistException() {
    }

    public EmployeeAlreadyExistException(String message) {
        super(message);
    }

    public EmployeeAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeeAlreadyExistException(Throwable cause) {
        super(cause);
    }

    public EmployeeAlreadyExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
