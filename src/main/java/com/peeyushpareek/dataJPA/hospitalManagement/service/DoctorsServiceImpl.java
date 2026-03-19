package com.peeyushpareek.dataJPA.hospitalManagement.service;

import com.peeyushpareek.dataJPA.hospitalManagement.dto.*;
import com.peeyushpareek.dataJPA.hospitalManagement.entity.DoctorsEntity;
import com.peeyushpareek.dataJPA.hospitalManagement.exception.DoctorsNotFoundException;
import com.peeyushpareek.dataJPA.hospitalManagement.mapper.DoctorsMapper;
import com.peeyushpareek.dataJPA.hospitalManagement.repository.DoctorsRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DoctorsServiceImpl {

    @Autowired
    private DoctorsRepository doctorsRepository;
    private final Logger log = LoggerFactory.getLogger(DoctorsServiceImpl.class);

    public ApiResponse<List<DoctorsResponse>> getAllDoctors(Pageable pageable) {
        int requestedSize = pageable.getPageSize();
        int maxSize = 5;

        if(requestedSize > maxSize) {
            log.warn("Requested page size {} exceeds the max limit. Showing {} records instead.",
                    requestedSize, maxSize);
        }

        int size = Math.min(requestedSize, maxSize);

        Pageable limitedPageable = PageRequest.of(
                pageable.getPageNumber(),
                size,
                pageable.getSort()
        );

        Page<DoctorsEntity> doctorsEntityPage = doctorsRepository.findAll(limitedPageable);
        List<DoctorsResponse> data = doctorsEntityPage.map(DoctorsMapper::toDoctorsResponse).getContent();
        return new ApiResponse<>(
                HttpStatus.OK.value(),
                "Complete List of Doctors fetched Successfully",
                LocalDateTime.now(),
                data,
                doctorsEntityPage.getNumber(),
                doctorsEntityPage.getSize(),
                doctorsEntityPage.getNumberOfElements(),
                doctorsEntityPage.getTotalPages(),
                doctorsEntityPage.isLast()
        );
    }

    public ApiResponse<List<DoctorsBloodGroupCountResponse>> getBloodGroupList() {

        // Count BloodGroup Types With "projection"
        return new ApiResponse<>(
                HttpStatus.OK.value(),
                "Blood Group List fetched successfully",
                LocalDateTime.now(),
                doctorsRepository.countEachBloodGroupType());
    }

    public ApiResponse<DoctorsResponse> createNewDoctors(DoctorsCreateRequest doctorsCreateRequest) {

        DoctorsEntity entity = DoctorsMapper.toDoctorsEntity(doctorsCreateRequest);
        return new ApiResponse<>(
                HttpStatus.OK.value(),
                "New Record Added",
                LocalDateTime.now(),
                DoctorsMapper.toDoctorsResponse(doctorsRepository.save(entity)));

    }

    @Transactional
    public ApiResponse<DoctorsResponse> updateFieldsToDoctorsEntity(Long id, DoctorsFieldUpdateRequest doctorsFieldUpdateRequest) {

        DoctorsEntity entity = doctorsRepository.findById(id).orElseThrow(() -> new DoctorsNotFoundException(id));
        DoctorsMapper.updateFieldsToDoctorsEntity(entity, doctorsFieldUpdateRequest);
        return new ApiResponse<>(
                HttpStatus.OK.value(),
                "Field Updated Successfully",
                LocalDateTime.now(),
                DoctorsMapper.toDoctorsResponse(entity));

    }

    @Transactional
    public ApiResponse<DoctorsResponse> updateRecordToDoctorsEntity(Long id, DoctorsCreateRequest doctorsCreateRequest) {
        DoctorsEntity recordToUpdate = doctorsRepository.findById(id)
                .orElseThrow(() -> new DoctorsNotFoundException(id));
        DoctorsMapper.updateRecordToDoctorsEntity(recordToUpdate, doctorsCreateRequest);
        return new ApiResponse<>(
                HttpStatus.OK.value(),
                "Record Updated successfully",
                LocalDateTime.now(),
                DoctorsMapper.toDoctorsResponse(recordToUpdate));

    }

    public ApiResponse<DoctorsResponse> findDoctorsById(Long id) {
        DoctorsEntity doctorsEntity = doctorsRepository.findById(id)
                .orElseThrow(() -> new DoctorsNotFoundException(id));
        return new ApiResponse<>(
                HttpStatus.OK.value(),
                "Doctor Record fetched successfully",
                LocalDateTime.now(),
                DoctorsMapper.toDoctorsResponse(doctorsEntity)
        );
    }

    // Specific search endpoint response
    public ApiResponse<List<DoctorsResponse>> getDoctorsBySpecialization(String specialization, Pageable pageable) {
        int requestedSize = pageable.getPageSize();
        int maxSize = 5;

        if (requestedSize > maxSize) {
            log.warn("Requested number of records per page {} is not allowed. Showing {} records per page instead!",
                    requestedSize, maxSize);
        }

        int size = Math.min(requestedSize, maxSize);
        Pageable sizeUpdatedPageable = PageRequest.of(pageable.getPageNumber(), size, pageable.getSort());
        Page<DoctorsEntity> doctorsEntity = doctorsRepository.findDoctorsBySpecialization(
                specialization, sizeUpdatedPageable);
        List<DoctorsResponse> data = doctorsEntity.map(DoctorsMapper::toDoctorsResponse).getContent();
        return new ApiResponse<>(
                HttpStatus.OK.value(),
                "Records found successfully for Specialization: " + specialization,
                LocalDateTime.now(),
                data,
                doctorsEntity.getNumber(),
                doctorsEntity.getSize(),
                doctorsEntity.getNumberOfElements(),
                doctorsEntity.getTotalPages(),
                doctorsEntity.isLast()
        );
    }

// Search utility using a ✔ Filter DTO, ✔ Null-handling inside Specification,
// ✔ Clean chaining with .and() and ✔ Pageable + size limiting

    public ApiResponse<List<DoctorsResponse>> searchDoctors(DoctorFilter doctorFilter, Pageable pageable) {

        int maxSize = 5;
        if (pageable.getPageSize() > maxSize) {
            log.warn("Requested number of records per page {} is not allowed. Showing {} records per page instead!",
                    pageable.getPageSize(), maxSize);
        }

        Sort validatedSort = DoctorsValidSorts.validateSort(pageable.getSort());
        Pageable updatedPageable = PageRequest.of(pageable.getPageNumber(), Math.min(pageable.getPageSize(),
                maxSize), validatedSort);

        Specification<DoctorsEntity> entitySpecification = Specification
                .where(DoctorsSpecification.hasSpecialization(doctorFilter.getSpecialization()))
                .and(DoctorsSpecification.hasDepartment(doctorFilter.getDepartment()))
                .and(DoctorsSpecification.hasName(doctorFilter.getName()))
                .and(DoctorsSpecification.hasGender(doctorFilter.getGender()))
                .and(DoctorsSpecification.hasMinExperience(doctorFilter.getMinExperience()))
                .and(DoctorsSpecification.hasMaxExperience(doctorFilter.getMaxExperience()));

        Page<DoctorsEntity> doctorsEntityPage = doctorsRepository.findAll(entitySpecification,updatedPageable);

        List<DoctorsResponse> data = doctorsEntityPage.map(DoctorsMapper::toDoctorsResponse).getContent();
        return new ApiResponse<>(
                HttpStatus.OK.value(),
                "Doctors records fetched successfully",
                LocalDateTime.now(),
                data,
                doctorsEntityPage.getNumber(),
                doctorsEntityPage.getSize(),
                doctorsEntityPage.getNumberOfElements(),
                doctorsEntityPage.getTotalPages(),
                doctorsEntityPage.isLast()
        );
    }
}
