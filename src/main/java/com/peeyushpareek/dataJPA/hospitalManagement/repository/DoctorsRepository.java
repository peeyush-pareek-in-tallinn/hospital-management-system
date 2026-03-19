package com.peeyushpareek.dataJPA.hospitalManagement.repository;

import com.peeyushpareek.dataJPA.hospitalManagement.dto.DoctorsBloodGroupCountResponse;
import com.peeyushpareek.dataJPA.hospitalManagement.entity.BloodGroupType;
import com.peeyushpareek.dataJPA.hospitalManagement.entity.DoctorsEntity;
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

public interface DoctorsRepository extends JpaRepository<DoctorsEntity, Long>, JpaSpecificationExecutor<DoctorsEntity> {

    @Query("select d from DoctorsEntity d where d.bloodGroup = ?1")
    List<DoctorsEntity> findByBloodGroup(@Param("bloodGroup") BloodGroupType bloodGroupType);

    @Query("select d from DoctorsEntity d where d.birthDate > :birthDate")
    List<DoctorsEntity> findByBornAfterDate(@Param("birthDate")LocalDate birthDate);

    @Transactional
    @Modifying
    @Query("update DoctorsEntity d set d.name = :name where d.id = id")
    int updateNameWithId(@Param("name") String name, @Param("id") Long id);

    // Count BloodGroup Types With "projection"
    @Query("select new com.peeyushpareek.dataJPA.hospitalManagement.dto.DoctorsBloodGroupCountResponse(" +
            "d.bloodGroup, Count(d)) from DoctorsEntity d group by d.bloodGroup")
    List<DoctorsBloodGroupCountResponse> countEachBloodGroupType();

    Page<DoctorsEntity> findDoctorsBySpecialization(String specialization, Pageable pageable);

}
