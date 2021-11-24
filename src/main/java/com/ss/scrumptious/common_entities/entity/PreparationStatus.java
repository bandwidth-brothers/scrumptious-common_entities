package com.ss.scrumptious.common_entities.entity;

public enum PreparationStatus{
    CREATING("CREATING"),
    CANCELLED("CANCELLED"),
    ORDER_PLACED("ORDER PLACED"),
    ACCEPTED("ACCEPTED"),
    PREPARING("PREPARING"),
    READY_FOR_PICKUP("READY FOR PICKUP"),
    DELIVERY("DELIVERY"),
    COMPLETED("COMPLETED");

    private final String status;

    PreparationStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

}
