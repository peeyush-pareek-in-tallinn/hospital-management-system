package com.peeyushpareek.dataJPA.hospitalManagement.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoctorFilter {

    private String specialization;
    private String department;
    private String name;
    private String gender;
    private Integer minExperience;
    private Integer maxExperience;
}
