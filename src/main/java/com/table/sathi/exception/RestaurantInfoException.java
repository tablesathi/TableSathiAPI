package com.table.sathi.exception;

public class RestaurantInfoException extends RuntimeException{
    private final ErrorResponse errorResponse;

    public RestaurantInfoException(ErrorResponse errorResponse) {
        super(errorResponse.getMessage());
        this.errorResponse = errorResponse;
    }

    public ErrorResponse getErrorResponse() {
        return errorResponse;
    }
}
