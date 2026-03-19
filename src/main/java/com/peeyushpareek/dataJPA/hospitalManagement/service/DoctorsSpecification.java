package com.peeyushpareek.dataJPA.hospitalManagement.service;
import com.peeyushpareek.dataJPA.hospitalManagement.entity.DoctorsEntity;
import org.springframework.data.jpa.domain.Specification;

public class DoctorsSpecification {

    public static Specification<DoctorsEntity> hasSpecialization(String specialization) {
        return (root, query, criteriaBuilder) ->
                specialization == null ? null : criteriaBuilder
                        .equal(root.get("specialization"), specialization);
    }

    public static Specification<DoctorsEntity> hasDepartment(String department) {
        return (root, query, criteriaBuilder) ->
                department == null ? null : criteriaBuilder
                        .equal(root.get("department"), department);
    }

    public static Specification<DoctorsEntity> hasName(String name) {
        return (root, query, criteriaBuilder) ->
                name == null ? null : criteriaBuilder
                        .like(criteriaBuilder
                                .lower(root.get("name")), "%" + name.toLowerCase() + "%");
    }

    public static Specification<DoctorsEntity> hasGender(String gender) {
        return (root, query, criteriaBuilder) ->
                gender == null ? null : criteriaBuilder
                        .equal(root.get("gender"), gender);
    }

    public static Specification<DoctorsEntity> hasMinExperience(Integer minExperience) {
        return (root, query, criteriaBuilder) ->
                minExperience == null ? null : criteriaBuilder
                        .equal(root.get("minExperience"), minExperience);
    }

    public static Specification<DoctorsEntity> hasMaxExperience(Integer maxExperience) {
        return (root, query, criteriaBuilder) ->
                maxExperience == null ? null : criteriaBuilder
                        .equal(root.get("maxExperience"), maxExperience);
    }
}
