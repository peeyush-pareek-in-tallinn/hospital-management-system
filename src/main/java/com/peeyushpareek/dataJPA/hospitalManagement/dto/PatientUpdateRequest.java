package com.peeyushpareek.dataJPA.hospitalManagement.dto;

import com.peeyushpareek.dataJPA.hospitalManagement.entity.BloodGroupType;
import jakarta.validation.constraints.Email;
import lombok.Getter;

import java.time.LocalDate;
@Getter
public class PatientUpdateRequest {

    private String name;
    private LocalDate birthDate;
    @Email
    private String email;
    private String gender;
    private BloodGroupType bloodGroup;

    public PatientUpdateRequest() {

    }
}

