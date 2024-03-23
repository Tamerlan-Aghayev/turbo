package com.company.turbo.data.enums;

import lombok.Getter;

@Getter
public enum DistanceUnitEnum {
    KM("Kilometer"),
    MI("Mile");

    private final String value;

    DistanceUnitEnum(String value) {
        this.value = value;
    }

    public static DistanceUnitEnum fromValue(String value) {
        for (DistanceUnitEnum unit : DistanceUnitEnum.values()) {
            if (unit.value.equals(value)) {
                return unit;
            }
        }
        throw new IllegalArgumentException("No enum constant with value: " + value);
    }
}
