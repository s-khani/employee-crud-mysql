package com.sprogram.employeeWithMySql.advisor;

import com.sprogram.employeeWithMySql.dto.ErrorResponse;
import com.sprogram.employeeWithMySql.exception.EmployeeAlreadyExistException;
import com.sprogram.employeeWithMySql.exception.EmployeeNotExistException;
import com.sprogram.employeeWithMySql.exception.MobileNumberNotAllowedException;
import com.sprogram.employeeWithMySql.exception.NotFoundEmployeeException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.time.LocalDateTime;

import static org.springframework.http.HttpStatus.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler(NotFoundEmployeeException.class)
    public ErrorResponse handlerNotFoundEmployeeException(NotFoundEmployeeException exc) {

        return new ErrorResponse(LocalDateTime.now(),
                NOT_FOUND.value(),
                exc.getMessage(),
                ServletUriComponentsBuilder.fromCurrentRequest().build().toString()
        );

    }

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse handleBadRequest(MethodArgumentNotValidException exc) {

        return new ErrorResponse(LocalDateTime.now(),
                BAD_REQUEST.value(),
                exc.getMessage(),
                ServletUriComponentsBuilder.fromCurrentRequest().build().toString()
        );
    }

    @ResponseStatus(CONFLICT)
    @ExceptionHandler(EmployeeAlreadyExistException.class)
    public ErrorResponse handleEmployeeAlreadyExistException(EmployeeAlreadyExistException exc) {

        return new ErrorResponse(LocalDateTime.now(),
                CONFLICT.value(),
                exc.getMessage(),
                ServletUriComponentsBuilder.fromCurrentRequest().build().toString()
        );

    }

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(EmployeeNotExistException.class)
    public ErrorResponse handleEmployeeNotExistException(EmployeeNotExistException exc) {

        return new ErrorResponse(
                LocalDateTime.now(),
                BAD_REQUEST.value(),
                exc.getMessage(),
                ServletUriComponentsBuilder.fromCurrentRequest().build().toString()
        );
    }

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(MobileNumberNotAllowedException.class)
    public ErrorResponse handleMobileNumberNotAllowedException(MobileNumberNotAllowedException exc) {

        return new ErrorResponse(
                LocalDateTime.now(),
                BAD_REQUEST.value(),
                exc.getMessage(),
                ServletUriComponentsBuilder.fromCurrentRequest().build().toString()
        );
    }
}
