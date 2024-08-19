package com.example.demo4.common;

import java.time.LocalDate;

public class ApiResponse {
    private final boolean success;
    private final String message;

    public ApiResponse(boolean success, String message, Object o) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }
    public String getMessage() {
        return message;
    }

    public String getTimetamp() {
        return LocalDate.now().toString();
    }
}
