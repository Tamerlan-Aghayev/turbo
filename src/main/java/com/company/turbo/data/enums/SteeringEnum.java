package com.company.turbo.data.enums;

import lombok.Getter;

@Getter
public enum SteeringEnum {
    MANUAL("Manual"),
    POWER_ASSISTED("Power Assisted"),
    FOUR_WHEEL("Four Wheel"),
    VARIABLE_RATIO("Variable Ratio"),
    ELECTRIC_POWER("Electric Power"),
    RACK_AND_PINION("Rack and Pinion");

    private final String value;

    SteeringEnum(String value) {
        this.value = value;
    }

    public static SteeringEnum fromValue(String value) {
        for (SteeringEnum steering : SteeringEnum.values()) {
            if (steering.value.equals(value)) {
                return steering;
            }
        }
        throw new IllegalArgumentException("No enum constant with value: " + value);
    }
}
