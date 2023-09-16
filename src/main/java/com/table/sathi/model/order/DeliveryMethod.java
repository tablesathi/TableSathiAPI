package com.table.sathi.model.order;

public enum  DeliveryMethod {
    HOME("home"), // Home delivery
    STORE("store"); // In-store pickup

    private final String value;

    DeliveryMethod(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static DeliveryMethod fromValue(String value) {
        for (DeliveryMethod method : values()) {
            if (method.value.equalsIgnoreCase(value)) {
                return method;
            }
        }
        throw new IllegalArgumentException("Invalid DeliveryMethod: " + value);
    }
}
