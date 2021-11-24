package com.ss.scrumptious.common_entities.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Table(name="delivery")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @Column(name = "estimated_delivery_time")
    private ZonedDateTime estimatedDeliveryTime;

    @Builder.Default
    @Column(name = "delivery_status")
    //@Enumerated(EnumType.STRING)
    private String deliveryStatus = "UNASSIGNED";

    @Column(name = "actual_delivery_time")
    private ZonedDateTime actualDeliveryTime;

    @Column(name = "driver_compensation")
    private Float driverCompensation;

    @Column(name = "picked_up_at")
    private ZonedDateTime pickedUpAt;

}
