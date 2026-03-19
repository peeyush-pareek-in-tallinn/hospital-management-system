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
public class PatientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // To automatically generate ID in DB
    private long id;

    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 30, message = "name can be of length 3 to 30 characters")
    private String name;

    private LocalDate birthDate;

    @Email //Validates the input email format
    private String email;

    private String gender;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    private BloodGroupType bloodGroup;

    @OneToOne
    @JoinColumn(name = "insurance_id")
    private InsuranceEntity insurance;



//    @Override
//    public String toString() {
//        final StringBuilder sb = new StringBuilder("PatientEntity: ");
//        sb.append("id - ").append(id);
//        sb.append(", name - '").append(name).append('\'');
//        sb.append(", birthDate - ").append(birthDate);
//        sb.append(", email - '").append(email).append('\'');
//        sb.append(", gender - '").append(gender).append('\'');
//        return sb.toString();
//    }

//    public long getId() {
//        return id;
//    }
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public LocalDate getBirthDate() {
//        return birthDate;
//    }
//    public void setBirthDate(LocalDate birthDate) {
//        this.birthDate = birthDate;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getGender() {
//        return gender;
//    }
//    public void setGender(String gender) {
//        this.gender = gender;
//    }
}
