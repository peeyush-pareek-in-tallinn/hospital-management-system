package com.peeyushpareek.dataJPA.hospitalManagement.exception;

public class DoctorsNotFoundException extends RuntimeException {

    public DoctorsNotFoundException(Long id) {
        super("Doctor not found with ID: " + id);
    }
}
