package com.peeyushpareek.dataJPA.hospitalManagement.dto;

import com.peeyushpareek.dataJPA.hospitalManagement.entity.BloodGroupType;
import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
public class PatientResponse {

    private long id;
    private String name;
    private LocalDate birthDate;
    private String email;
    private String gender;
    private BloodGroupType bloodGroup;
    private Long insuranceId;
    private LocalDate insuranceValidUntil;

    public PatientResponse(long id,
                           String name,
                           LocalDate birthDate,
                           String email,
                           String gender,
                           BloodGroupType bloodGroup,
                           Long insuranceId,
                           LocalDate insuranceValidUntil) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.email = email;
        this.gender = gender;
        this.bloodGroup = bloodGroup;
        this.insuranceId = insuranceId;
        this.insuranceValidUntil = insuranceValidUntil;
    }

    public PatientResponse(){}

    public BloodGroupType getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(BloodGroupType bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public Long getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(long insuranceId) {
        this.insuranceId = insuranceId;
    }

    public LocalDate getInsuranceValidUntil() {
        return insuranceValidUntil;
    }

    public void setInsuranceValidUntil(LocalDate insuranceValidUntil) {
        this.insuranceValidUntil = insuranceValidUntil;
    }
}
