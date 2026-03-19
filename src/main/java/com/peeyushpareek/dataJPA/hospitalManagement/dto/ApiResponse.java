package com.peeyushpareek.dataJPA.hospitalManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> {

    private int status;
    private String message;
    private LocalDateTime timeStamp;

    private T data;

    private Integer page;
    private Integer size;
    private Integer totalElements;
    private Integer totalPages;
    private Boolean last;

    public ApiResponse(int status, String message, LocalDateTime timeStamp, T data) {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
        this.data = data;
    }
}
