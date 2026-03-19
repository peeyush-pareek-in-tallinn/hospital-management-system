package com.peeyushpareek.dataJPA.hospitalManagement.repository;

import com.peeyushpareek.dataJPA.hospitalManagement.dto.PatientBloodGroupCountResponse;
import com.peeyushpareek.dataJPA.hospitalManagement.entity.BloodGroupType;
import com.peeyushpareek.dataJPA.hospitalManagement.entity.PatientEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PatientRepository extends JpaRepository<PatientEntity, Long> {

    @Query("select p from PatientEntity p where p.bloodGroup = ?1")
    List<PatientEntity> findByBloodGroup(BloodGroupType bloodGroupType);

    @Query("select p from PatientEntity p where p.birthDate > :birthDate")
    List<PatientEntity> findByBornAfterDate(@Param("birthDate")LocalDate birthDate);

    @Transactional
    @Modifying
    @Query("update PatientEntity p set p.name = :name where p.id = id")
    int updateNameWithId(@Param("name") String name, @Param("id") Long id);

    // Count BloodGroup Types With "projection"
//    @Query("select new com.peeyushpareek.dataJPA.hospitalManagement.dto.PatientBloodGroupCountResponse(" +
//            "p.bloodGroup, Count(p)) from PatientEntity p group by p.bloodGroup")
//    List<PatientBloodGroupCountResponse> countEachBloodGroupType();

    // Count BloodGroup Types Without "projection"
    @Query("select p.bloodGroup, Count(p) from PatientEntity p group by p.bloodGroup")
    List<Object[]> countEachBloodGroupType();
}
