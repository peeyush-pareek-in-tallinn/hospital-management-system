package com.peeyushpareek.dataJPA.hospitalManagement.dto;

import com.peeyushpareek.dataJPA.hospitalManagement.entity.BloodGroupType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public class PatientCreateRequest {

    @NotBlank
    private String name;
    private LocalDate birthDate;

    @Email
    private String email;
    private String gender;
    private BloodGroupType bloodGroup;


    public PatientCreateRequest() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public BloodGroupType getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(BloodGroupType bloodGroup) {
        this.bloodGroup = bloodGroup;
    }
}
