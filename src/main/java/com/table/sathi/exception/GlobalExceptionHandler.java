package com.table.sathi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler {
    @ExceptionHandler({RuntimeException.class, Exception.class})
    public ResponseEntity<ErrorResponse> handleGenericException(Exception ex) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ErrorResponse.builder()
                        .error("Unknown Exception")
                        .message("An unknown error occurred")
                        .build());
    }

    @ExceptionHandler({RestaurantInfoException.class})
    public ResponseEntity<ErrorResponse> restaurantInfoException(RestaurantInfoException ex) {
        ErrorResponse errorResponse=ex.getErrorResponse();
        return ResponseEntity
                .status(errorResponse.getHttpStatus())
                .body(errorResponse);
    }

}
