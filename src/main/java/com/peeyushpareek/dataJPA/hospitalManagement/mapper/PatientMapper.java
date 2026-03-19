package com.peeyushpareek.dataJPA.hospitalManagement.mapper;

import com.peeyushpareek.dataJPA.hospitalManagement.dto.PatientCreateRequest;
import com.peeyushpareek.dataJPA.hospitalManagement.dto.PatientResponse;
import com.peeyushpareek.dataJPA.hospitalManagement.dto.PatientUpdateRequest;
import com.peeyushpareek.dataJPA.hospitalManagement.entity.PatientEntity;

public class PatientMapper {

    public static PatientResponse toPatientResponse(PatientEntity patientEntity) {

        return PatientResponse.builder()
                .birthDate(patientEntity.getBirthDate())
                .email(patientEntity.getEmail())
                .id(patientEntity.getId())
                .name(patientEntity.getName())
                .gender(patientEntity.getGender())
                .bloodGroup(patientEntity.getBloodGroup())
                .insuranceId(patientEntity.getInsurance() == null ? null : patientEntity.getInsurance().getId())
                .insuranceValidUntil(patientEntity.getInsurance() == null ? null : patientEntity.getInsurance().getValidUntil())
                .build();

    }

    public static void mapFields(PatientEntity patientEntity, PatientCreateRequest patientCreateRequest) {
        patientEntity.setName(patientCreateRequest.getName());
        patientEntity.setBirthDate(patientCreateRequest.getBirthDate());
        patientEntity.setEmail(patientCreateRequest.getEmail());
        patientEntity.setGender(patientCreateRequest.getGender());
        patientEntity.setBloodGroup(patientCreateRequest.getBloodGroup());
    }

    public static PatientEntity toPatientEntity(PatientCreateRequest patientCreateRequest) {
        PatientEntity patientEntity = new PatientEntity();
        mapFields(patientEntity, patientCreateRequest);
        return patientEntity;
    }

    public static void updateFieldsToPatientEntity(PatientEntity patientEntity, PatientUpdateRequest patientUpdateRequest) {
        if (patientUpdateRequest.getName() != null) {
            patientEntity.setName(patientUpdateRequest.getName());
        }
        if (patientUpdateRequest.getBirthDate() != null) {
            patientEntity.setBirthDate(patientUpdateRequest.getBirthDate());
        }
        if (patientUpdateRequest.getEmail() != null) {
            patientEntity.setEmail(patientUpdateRequest.getEmail());
        }
        if (patientUpdateRequest.getGender() != null) {
            patientEntity.setGender(patientUpdateRequest.getGender());
        }
        if (patientUpdateRequest.getBloodGroup() != null) {
            patientEntity.setBloodGroup(patientUpdateRequest.getBloodGroup());
        }
    }

    public static void updateRecordToPatientEntity(PatientEntity patientEntity, PatientCreateRequest patientCreateRequest) {
        mapFields(patientEntity, patientCreateRequest);

    }

}
