package com.peeyushpareek.dataJPA.hospitalManagement.dto;

import com.peeyushpareek.dataJPA.hospitalManagement.entity.BloodGroupType;
import lombok.ToString;

@ToString
public class PatientBloodGroupCountResponse {

    private final BloodGroupType bloodGroupType;
    private final Long count;

    public PatientBloodGroupCountResponse(BloodGroupType bloodGroupType, Long count) {
        this.bloodGroupType = bloodGroupType;
        this.count = count;
    }

    public BloodGroupType getBloodGroupType() {
        return bloodGroupType;
    }

    public Long getCount() {
        return count;
    }
}
