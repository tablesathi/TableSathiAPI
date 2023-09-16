package com.table.sathi.model.order;

public enum OrderStatus {
    IS_CANCELLED("isCancelled"),
    IS_CONFIRMED("isConfirmed"),
    IS_SHIPPED("isShipped"),
    IS_DELIVERED("isDelivered");

    private final String value;

    OrderStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static OrderStatus fromValue(String value) {
        for (OrderStatus status : values()) {
            if (status.value.equalsIgnoreCase(value)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid OrderStatus value: " + value);
    }
}
