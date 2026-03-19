package com.peeyushpareek.dataJPA.hospitalManagement.controller;

import com.peeyushpareek.dataJPA.hospitalManagement.dto.*;
import com.peeyushpareek.dataJPA.hospitalManagement.service.DoctorsServiceImpl;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DoctorsController {

    private final DoctorsServiceImpl doctorsService;

    DoctorsController(DoctorsServiceImpl doctorsService) {
        this.doctorsService = doctorsService;
    }

    @GetMapping("/doctors/all")
    public ApiResponse<List<DoctorsResponse>> getAllDoctors(
            @PageableDefault(size = 3, sort = "id") Pageable pageable) {
        return doctorsService.getAllDoctors(pageable);
    }

    @GetMapping("/doctors/bloodgroupcount")
    public ApiResponse<List<DoctorsBloodGroupCountResponse>> getBloodGroupCount() {
        return doctorsService.getBloodGroupList();
    }

    @PostMapping("/doctors")
    public ApiResponse<DoctorsResponse> addNewDoctors(
            @Valid @RequestBody DoctorsCreateRequest doctorsCreateRequest) {
        return doctorsService.createNewDoctors(doctorsCreateRequest);
    }

    @PatchMapping("/doctors/{id}")
    public ApiResponse<DoctorsResponse> fieldUpdateDoctors(
            @PathVariable Long id,
            @RequestBody DoctorsFieldUpdateRequest doctorsFieldUpdateRequest) {
        return doctorsService.updateFieldsToDoctorsEntity(id, doctorsFieldUpdateRequest);
    }

    @PutMapping("/doctors/{id}")
    public ApiResponse<DoctorsResponse> updateDoctors(
            @PathVariable Long id,
            @Valid @RequestBody DoctorsCreateRequest doctorsCreateRequest) {
        return doctorsService.updateRecordToDoctorsEntity(id, doctorsCreateRequest);
    }

    @GetMapping("/doctors/{id}")
    public ApiResponse<DoctorsResponse> findDoctorsById(@PathVariable Long id) {
        return doctorsService.findDoctorsById(id);
    }

    @GetMapping("/doctors/specialization/{specialization}")
    public ApiResponse<List<DoctorsResponse>> getDoctorsBySpecialization(
            @PathVariable String specialization,
            @PageableDefault(size = 3, sort = "id") Pageable pageable) {
        return doctorsService.getDoctorsBySpecialization(specialization, pageable);
    }

    @GetMapping("/doctors")
    public ApiResponse<List<DoctorsResponse>> searchDoctors(
            DoctorFilter doctorFilter, Pageable pageable) {
        return doctorsService.searchDoctors(doctorFilter, pageable);
    }
}
