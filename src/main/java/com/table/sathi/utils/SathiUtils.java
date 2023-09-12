package com.table.sathi.utils;

import com.table.sathi.exception.ErrorResponse;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class SathiUtils {
    public static ErrorResponse buildErrorResponse(String error, String message, HttpStatus httpStatus,Exception exception) {
        return ErrorResponse.builder()
                .error(error)
                .message(message)
                .httpStatus(httpStatus)
                .exceptionTime(LocalDateTime.now())
                .exception(exception)
                .build();
    }
}
