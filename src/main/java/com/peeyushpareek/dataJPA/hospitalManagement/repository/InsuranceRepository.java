package com.peeyushpareek.dataJPA.hospitalManagement.repository;

import com.peeyushpareek.dataJPA.hospitalManagement.dto.DoctorsBloodGroupCountResponse;
import com.peeyushpareek.dataJPA.hospitalManagement.dto.InsuranceResponse;
import com.peeyushpareek.dataJPA.hospitalManagement.entity.BloodGroupType;
import com.peeyushpareek.dataJPA.hospitalManagement.entity.DoctorsEntity;
import com.peeyushpareek.dataJPA.hospitalManagement.entity.InsuranceEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface InsuranceRepository extends JpaRepository<InsuranceEntity, Long>, JpaSpecificationExecutor<DoctorsEntity> {

    // query for insurance info + patient name
//    @Query("select new com.peeyushpareek.dataJPA.hospitalManagement.dto.InsuranceResponse(" +
//            "i.id, i.provider, p.name) from InsuranceEntity i join i.patient p")
//    List<InsuranceResponse> findAllInsuranceWithPatientName();


}
