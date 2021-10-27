package com.ss.scrumptious.common_entities.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name="driver")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Driver {

    @Id
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @NotBlank
    @Column(nullable = false)
    private String firstName;

    @NotBlank
    @Column(nullable = false)
    private String lastName;

    @NotBlank
    @Column(nullable = false)
    private String phone;

    @NotBlank
    @Column(nullable = false)
    private String email;

    //@NotBlank
    @Column(name = "dob")//, nullable = false)
    private Date dob;

    //@NotBlank
    @Column(name = "license_num")
    private String licenseNumber;

    @Builder.Default
    @Column(name = "rating")
    private Float rating = 0.0f;

    private String picture;

    private String status;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;
}
