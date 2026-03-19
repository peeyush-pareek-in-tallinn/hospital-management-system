package com.peeyushpareek.dataJPA.hospitalManagement.dto;

import com.peeyushpareek.dataJPA.hospitalManagement.entity.BloodGroupType;
import com.peeyushpareek.dataJPA.hospitalManagement.entity.PatientEntity;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class InsuranceResponse {

    private long id;
    private String policyNumber;
    private String provider;
    private LocalDate validUntil;
    private String patientName;
}
