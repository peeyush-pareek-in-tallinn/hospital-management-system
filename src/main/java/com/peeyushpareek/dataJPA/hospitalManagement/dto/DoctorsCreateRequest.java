package com.peeyushpareek.dataJPA.hospitalManagement.dto;

import com.peeyushpareek.dataJPA.hospitalManagement.entity.BloodGroupType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
public class DoctorsCreateRequest {

    @NotBlank
    private String name;
    private LocalDate birthDate;
    private String specialization;
    private String department;
    private String position;

    @Email
    private String email;
    private String gender;
    private BloodGroupType bloodGroup;

}
