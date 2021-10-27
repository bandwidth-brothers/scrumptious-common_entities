package com.ss.scrumptious.common_entities.entity;

public enum PreparationStatus{
    ORDER_PLACED("ORDER PLACED"),
    CANCELLED("CANCELLED"),
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
