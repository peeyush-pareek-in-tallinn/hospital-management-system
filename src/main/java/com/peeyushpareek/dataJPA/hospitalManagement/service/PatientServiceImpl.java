package com.peeyushpareek.dataJPA.hospitalManagement.service;

import com.peeyushpareek.dataJPA.hospitalManagement.dto.PatientBloodGroupCountResponse;
import com.peeyushpareek.dataJPA.hospitalManagement.dto.PatientCreateRequest;
import com.peeyushpareek.dataJPA.hospitalManagement.dto.PatientUpdateRequest;
import com.peeyushpareek.dataJPA.hospitalManagement.entity.BloodGroupType;
import com.peeyushpareek.dataJPA.hospitalManagement.entity.PatientEntity;
import com.peeyushpareek.dataJPA.hospitalManagement.dto.PatientResponse;
import com.peeyushpareek.dataJPA.hospitalManagement.exception.PatientNotFoundException;
import com.peeyushpareek.dataJPA.hospitalManagement.mapper.PatientMapper;
import com.peeyushpareek.dataJPA.hospitalManagement.repository.PatientRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;
    private final Logger log = LoggerFactory.getLogger(PatientServiceImpl.class);

    public Page<PatientResponse> getAllPatients(int pageNumber, int size, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
        size = Math.min(size, 5);
        if(size > 5) {
            log.warn("Requested page size {} exceeds the max limit. Showing 5 records instead.", size);
        }
        PageRequest pageRequest = PageRequest.of(pageNumber, size, sort);
        Page<PatientEntity> patientEntityList = patientRepository.findAll(pageRequest);

        // Using a Mapper class to map the patient list to patient response
        return patientEntityList.map(PatientMapper::toPatientResponse);

        // Mapping patient list manually in service implementation
//        return patientEntityList
//                .stream()
//                .map(patientEntity -> new PatientResponse(
//                        patientEntity.getId(),
//                        patientEntity.getName(),
//                        patientEntity.getBirthDate(),
//                        patientEntity.getEmail(),
//                        patientEntity.getGender(),
//                        patientEntity.getBloodGroup()))
//                .toList();

    }

    public List<PatientBloodGroupCountResponse> getBloodGroupList() {

        // Count BloodGroup Types With "projection"
//        return patientRepository.countEachBloodGroupType();

        // Count BloodGroup Types Without "projection"
        List<Object[]> bloodGroupList = patientRepository.countEachBloodGroupType();
        List<PatientBloodGroupCountResponse> result;
        result = bloodGroupList.stream()
                .map(objects -> new PatientBloodGroupCountResponse(
                        (BloodGroupType) objects[0],
                        (Long) objects[1])).toList();
        return result;

    }

    public PatientResponse createNewPatient(PatientCreateRequest patientCreateRequest) {

        PatientEntity entity = PatientMapper.toPatientEntity(patientCreateRequest);
        return PatientMapper.toPatientResponse(patientRepository.save(entity));

    }

    @Transactional
    public PatientResponse updateFieldsToPatientEntity(Long id, PatientUpdateRequest patientUpdateRequest) {

        PatientEntity entity = patientRepository.findById(id).orElseThrow(() -> new NoSuchElementException("No Patient found with ID: " + id + " !"));
        PatientMapper.updateFieldsToPatientEntity(entity, patientUpdateRequest);
        return PatientMapper.toPatientResponse(entity);

    }

    @Transactional
    public PatientResponse updateRecordToPatientEntity(Long id, PatientCreateRequest patientCreateRequest) {
        PatientEntity recordToUpdate = patientRepository.findById(id).orElseThrow(() -> new PatientNotFoundException(id));
        PatientMapper.updateRecordToPatientEntity(recordToUpdate, patientCreateRequest);
        return PatientMapper.toPatientResponse(recordToUpdate);

    }
}
