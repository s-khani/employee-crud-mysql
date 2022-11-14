package com.sprogram.employeeWithMySql.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;


public record ErrorResponse(
        LocalDateTime timestamps,
        int status,
        String errorMessage,
        String path
) {
}
