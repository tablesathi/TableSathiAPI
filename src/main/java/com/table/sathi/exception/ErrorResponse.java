package com.table.sathi.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class ErrorResponse {
    private String error;
    private String message;
    private HttpStatus httpStatus;
    private LocalDateTime exceptionTime;
    private Exception exception;

}
