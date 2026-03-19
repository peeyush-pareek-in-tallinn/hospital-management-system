package com.peeyushpareek.dataJPA.hospitalManagement.controller;

import com.peeyushpareek.dataJPA.hospitalManagement.dto.*;
import com.peeyushpareek.dataJPA.hospitalManagement.service.PatientServiceImpl;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController {

    private final PatientServiceImpl patientService;

    PatientController(PatientServiceImpl patientServiceImpl) {
        this.patientService = patientServiceImpl;
    }

    @GetMapping("/")
    public String hello() {
        return "Welcome to PeeyshPareek Hospital Management System";
    }

    @GetMapping("/patient/all")
    public Page<PatientResponse> getAllPatients(
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "3") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDir) {
        return patientService.getAllPatients(pageNumber, size, sortBy, sortDir);
    }

    @GetMapping("/patient/bloodgroupcount")
    public List<PatientBloodGroupCountResponse> getBloodGroupCount() {
        return patientService.getBloodGroupList();
    }

    @PostMapping("/patient")
    public PatientResponse addNewPatient(@Valid @RequestBody PatientCreateRequest patientCreateRequest) {
        return patientService.createNewPatient(patientCreateRequest);
    }

    @PatchMapping("/patient/{id}")
    public PatientResponse fieldUpdatePatient(@PathVariable Long id, @RequestBody PatientUpdateRequest patientUpdateRequest) {
        return patientService.updateFieldsToPatientEntity(id, patientUpdateRequest);
    }

    @PutMapping("/patient/{id}")
    public PatientResponse updatePatient(@PathVariable Long id, @Valid @RequestBody PatientCreateRequest patientCreateRequest) {
        return patientService.updateRecordToPatientEntity(id, patientCreateRequest);
    }
}
