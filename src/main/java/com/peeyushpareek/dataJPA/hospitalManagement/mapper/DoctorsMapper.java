package com.peeyushpareek.dataJPA.hospitalManagement.mapper;

import com.peeyushpareek.dataJPA.hospitalManagement.dto.DoctorsCreateRequest;
import com.peeyushpareek.dataJPA.hospitalManagement.dto.DoctorsFieldUpdateRequest;
import com.peeyushpareek.dataJPA.hospitalManagement.dto.DoctorsResponse;
import com.peeyushpareek.dataJPA.hospitalManagement.entity.DoctorsEntity;

public class DoctorsMapper {

    public static DoctorsResponse toDoctorsResponse(DoctorsEntity doctorsEntity) {
        return new DoctorsResponse(
                doctorsEntity.getId(),
                doctorsEntity.getName(),
                doctorsEntity.getBirthDate(),
                doctorsEntity.getDepartment(),
                doctorsEntity.getSpecialization(),
                doctorsEntity.getPosition(),
                doctorsEntity.getExperience(),
                doctorsEntity.getEmail(),
                doctorsEntity.getGender(),
                doctorsEntity.getBloodGroup()
        );
    }

    public static void mapFields(DoctorsEntity doctorsEntity, DoctorsCreateRequest doctorsCreateRequest) {
        doctorsEntity.setName(doctorsCreateRequest.getName());
        doctorsEntity.setBirthDate(doctorsCreateRequest.getBirthDate());
        doctorsEntity.setSpecialization(doctorsCreateRequest.getSpecialization());
        doctorsEntity.setDepartment(doctorsEntity.getDepartment());
        doctorsEntity.setPosition(doctorsEntity.getPosition());
        doctorsEntity.setEmail(doctorsCreateRequest.getEmail());
        doctorsEntity.setGender(doctorsCreateRequest.getGender());
        doctorsEntity.setBloodGroup(doctorsCreateRequest.getBloodGroup());
    }

    public static DoctorsEntity toDoctorsEntity(DoctorsCreateRequest doctorsCreateRequest) {
        DoctorsEntity doctorsEntity = new DoctorsEntity();
        mapFields(doctorsEntity, doctorsCreateRequest);
        return doctorsEntity;
    }

    public static void updateFieldsToDoctorsEntity(DoctorsEntity doctorsEntity, DoctorsFieldUpdateRequest doctorsFieldUpdateRequest) {
        if (doctorsFieldUpdateRequest.getName() != null) {
            doctorsEntity.setName(doctorsFieldUpdateRequest.getName());
        }
        if (doctorsFieldUpdateRequest.getName() != null) {
            doctorsEntity.setBirthDate(doctorsFieldUpdateRequest.getBirthDate());
        }
        if (doctorsFieldUpdateRequest.getName() != null) {
            doctorsEntity.setSpecialization(doctorsFieldUpdateRequest.getSpecialization());
        }
        if (doctorsFieldUpdateRequest.getName() != null) {
            doctorsEntity.setDepartment(doctorsFieldUpdateRequest.getDepartment());
        }
        if (doctorsFieldUpdateRequest.getName() != null) {
            doctorsEntity.setPosition(doctorsFieldUpdateRequest.getPosition());
        }
        if (doctorsFieldUpdateRequest.getName() != null) {
            doctorsEntity.setEmail(doctorsFieldUpdateRequest.getEmail());
        }
        if (doctorsFieldUpdateRequest.getName() != null) {
            doctorsEntity.setGender(doctorsFieldUpdateRequest.getGender());
        }
        if (doctorsFieldUpdateRequest.getName() != null) {
            doctorsEntity.setBloodGroup(doctorsFieldUpdateRequest.getBloodGroup());
        }
    }

    public static void updateRecordToDoctorsEntity(DoctorsEntity doctorsEntity, DoctorsCreateRequest doctorsCreateRequest) {
        mapFields(doctorsEntity, doctorsCreateRequest);

    }

}
