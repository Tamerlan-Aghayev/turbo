package com.company.turbo.data.enums;

import lombok.Getter;

@Getter
public enum FuelTypeEnum {
    PETROL("Petrol"),
    DIESEL("Diesel"),
    ELECTRIC("Electric"),
    HYBRID("Hybrid"),
    NATURAL_GAS("Natural Gas"),
    BIOETHANOL("Bioethanol"),
    HYDROGEN("Hydrogen");

    private final String value;

    FuelTypeEnum(String value) {
        this.value = value;
    }

    public static FuelTypeEnum fromValue(String value) {
        for (FuelTypeEnum fuelType : FuelTypeEnum.values()) {
            if (fuelType.value.equals(value)) {
                return fuelType;
            }
        }
        throw new IllegalArgumentException("No enum constant with value: " + value);
    }
}
