package com.peeyushpareek.dataJPA.hospitalManagement.dto;

import lombok.Getter;
import java.time.LocalDateTime;
import java.util.Map;

@Getter
public class ApiErrorResponse {
    private LocalDateTime timeStamp;
    private int statusCode;
    private String errorDesc;
    private String message;
    private String path;
    private Map<String, String> validationErrors;

    public ApiErrorResponse(LocalDateTime timeStamp,
                            int statusCode,
                            String errorDesc,
                            String message,
                            String path) {
        this.timeStamp = timeStamp;
        this.statusCode = statusCode;
        this.errorDesc = errorDesc;
        this.message = message;
        this.path = path;
    }

    public void setValidationErrors(Map<String, String> validationErrors) {
        this.validationErrors = validationErrors;
    }
}
