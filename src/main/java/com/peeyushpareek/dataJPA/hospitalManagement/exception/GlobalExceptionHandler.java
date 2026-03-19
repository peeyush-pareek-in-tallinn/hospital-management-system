package com.peeyushpareek.dataJPA.hospitalManagement.exception;

import com.peeyushpareek.dataJPA.hospitalManagement.dto.ApiErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PatientNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handlePatientNotFound(PatientNotFoundException exception, HttpServletRequest request) {
        ApiErrorResponse errorResponse = new ApiErrorResponse(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                "Patient not found",
                exception.getMessage(),
                request.getRequestURI());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiErrorResponse> handleValidationException(
            MethodArgumentNotValidException exception,
            HttpServletRequest request) {

        Map<String, String> errorMap = new HashMap<>();

        exception.getBindingResult()
                .getFieldErrors()
                .forEach(fieldError -> errorMap.put(fieldError.getField(), fieldError.getDefaultMessage()));

        ApiErrorResponse apiErrorResponse = new ApiErrorResponse(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                "Validation Failed",
                "Invalid Request Fields",
                request.getRequestURI()
        );
        apiErrorResponse.setValidationErrors(errorMap);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .header("X-Error-Code", "Validation Failed")
                .body(apiErrorResponse);
//        return ResponseEntity.badRequest().body(apiErrorResponse);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorResponse> handleGeneralException(Exception exception, HttpServletRequest request) {
        ApiErrorResponse apiErrorResponse = new ApiErrorResponse(
                LocalDateTime.now(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Internal server error",
                exception.getMessage(),
                request.getRequestURI());
        return new ResponseEntity<>(apiErrorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
