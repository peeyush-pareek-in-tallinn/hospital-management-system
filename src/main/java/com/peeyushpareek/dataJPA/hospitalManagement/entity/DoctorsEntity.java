package com.peeyushpareek.dataJPA.hospitalManagement.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@ToString
@Getter
@Setter
public class DoctorsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // To automatically generate ID in DB
    private long id;

    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 30, message = "name can be of length 3 to 30 characters")
    private String name;

    private LocalDate birthDate;

    private String specialization;

    private String Department;

    private String position;

    private int experience;

    @Email //Validates the input email format
    private String email;

    private String gender;

    @Enumerated(EnumType.STRING)
    private BloodGroupType bloodGroup;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

}
