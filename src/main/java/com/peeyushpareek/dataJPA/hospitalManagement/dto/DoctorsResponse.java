package com.peeyushpareek.dataJPA.hospitalManagement.dto;

import com.peeyushpareek.dataJPA.hospitalManagement.entity.BloodGroupType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
public class DoctorsResponse {

    private long id;
    private String name;
    private LocalDate birthDate;
    private String specialization;
    private String department;
    private String position;
    private int experience;
    private String email;
    private String gender;
    private BloodGroupType bloodGroup;

}
