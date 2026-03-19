package com.peeyushpareek.dataJPA.hospitalManagement.dto;

import com.peeyushpareek.dataJPA.hospitalManagement.entity.BloodGroupType;
import jakarta.validation.constraints.Email;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class DoctorsFieldUpdateRequest {

    private String name;
    private LocalDate birthDate;
    private String specialization;
    private String Department;
    private String position;
    @Email
    private String email;
    private String gender;
    private BloodGroupType bloodGroup;

    public DoctorsFieldUpdateRequest() {

    }
}

