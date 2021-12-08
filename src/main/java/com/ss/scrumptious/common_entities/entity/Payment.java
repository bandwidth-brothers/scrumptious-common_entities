package com.ss.scrumptious.common_entities.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "payment")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Customer customer;

    @NotNull
    private String name;

    private String stripeId;

    @Builder.Default
    @Column(columnDefinition = "TINYINT")
    private Boolean refunded = false;

    private String paymentStatus;

}
