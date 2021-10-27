package com.ss.scrumptious.common_entities.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

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

    @OneToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;

    @Column(name = "estimated_delivery_time")
    private ZonedDateTime estimatedDeliveryTime;

    @Column(name = "delivery_status")
    private String deliveryStatus;

    @Column(name = "actual_delivery_time")
    private ZonedDateTime actualDeliveryTime;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;



}
