package com.company.turbo.data.enums;

import lombok.Getter;

@Getter
public enum TransmissionEnum {
    FRONT("Front"),
    BACK("Back"),
    FULL("Full");

    private final String value;

    TransmissionEnum(String value) {
        this.value = value;
    }

    public static TransmissionEnum fromValue(String value) {
        for (TransmissionEnum transmission : TransmissionEnum.values()) {
            if (transmission.value.equals(value)) {
                return transmission;
            }
        }
        throw new IllegalArgumentException("No enum constant with value: " + value);
    }
}
