package com.ss.scrumptious.common_entities.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customer")
@Builder
public class Customer {


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

    @Builder.Default
    @Column(name = "loyalty_points", nullable = false)
    private Integer loyaltyPoints = 0;

    @Nullable
    @Column(name = "picture")
    private String picture;


    // without columnDefinition = "TINYINT" mysql will default to bit(1)
    @Builder.Default
    @Column(name = "veteran_status", columnDefinition = "TINYINT")
    private Boolean veteranStatus = false;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

}
