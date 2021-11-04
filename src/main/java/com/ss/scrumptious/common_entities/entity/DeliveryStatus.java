package com.ss.scrumptious.common_entities.entity;

public enum DeliveryStatus {
    UNASSIGNED("UNASSIGNED"),
    DRIVER_ASSIGNED("DRIVER ASSIGNED"),
    PICKED_UP("PICKED UP"),
    IN_TRANSIT("IN TRANSIT"),
    ARRIVED("ARRIVED"),
    COMPLETED("COMPLETED");

    private final String status;

    DeliveryStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

}
