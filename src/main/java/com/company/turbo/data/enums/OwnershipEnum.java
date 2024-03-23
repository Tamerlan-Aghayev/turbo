package com.company.turbo.data.enums;

import lombok.Getter;

@Getter
public enum OwnershipEnum {
    FIRST("First"),
    SECOND("Second"),
    THIRD("Third"),
    FOURTH_AND_MORE("Fourth and More");

    private final String value;

    OwnershipEnum(String value) {
        this.value = value;
    }

    public static OwnershipEnum fromValue(String value) {
        for (OwnershipEnum ownership : OwnershipEnum.values()) {
            if (ownership.value.equals(value)) {
                return ownership;
            }
        }
        throw new IllegalArgumentException("No enum constant with value: " + value);
    }
}
