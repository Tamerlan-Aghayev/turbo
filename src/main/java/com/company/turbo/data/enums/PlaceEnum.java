package com.company.turbo.data.enums;

import jakarta.persistence.GeneratedValue;
import lombok.Getter;

@Getter
public enum PlaceEnum {
    ONE("1"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT_AND_MORE("8+");
    private final String value;
    PlaceEnum(String value){
        this.value=value;
    }
    public static PlaceEnum fromValue(String value) {
        for (PlaceEnum place : PlaceEnum.values()) {
            if (place.value.equals(value)) {
                return place;
            }
        }
        throw new IllegalArgumentException("No enum constant with value: " + value);
    }
}
