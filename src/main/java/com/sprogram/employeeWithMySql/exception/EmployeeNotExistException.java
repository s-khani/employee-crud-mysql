package com.sprogram.employeeWithMySql.exception;

public class EmployeeNotExistException extends RuntimeException {
    public EmployeeNotExistException() {
    }

    public EmployeeNotExistException(String message) {
        super(message);
    }

    public EmployeeNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeeNotExistException(Throwable cause) {
        super(cause);
    }

    public EmployeeNotExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
