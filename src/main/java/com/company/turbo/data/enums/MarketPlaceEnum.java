package com.company.turbo.data.enums;

import lombok.Getter;

@Getter
public enum MarketPlaceEnum {
    AMERICA("America"),
    EUROPE("Europe"),
    CHINA("China"),
    OTHER("Other"),
    DUBAI("Dubai"),
    KOREA("Korea"),
    RUSSIA("Russia"),
    JAPAN("Japan");

    private final String value;

    MarketPlaceEnum(String value) {
        this.value = value;
    }

    public static MarketPlaceEnum fromValue(String value) {
        for (MarketPlaceEnum marketPlace : MarketPlaceEnum.values()) {
            if (marketPlace.value.equals(value)) {
                return marketPlace;
            }
        }
        throw new IllegalArgumentException("No enum constant with value: " + value);
    }
}
