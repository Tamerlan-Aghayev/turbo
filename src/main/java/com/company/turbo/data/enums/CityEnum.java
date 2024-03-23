package com.company.turbo.data.enums;
import lombok.Getter;

@Getter
public enum CityEnum {
    SIYAZAN("Siyazan"),
    BAKU("Baku"),
    GANJA("Ganja"),
    SUMQAYIT("Sumqayit"),
    LANKARAN("Lankaran"),
    SHIRVAN("Shirvan"),
    NAKHCHIVAN("Nakhchivan"),
    BARDA("Barda");

    private final String value;

    CityEnum(String value) {
        this.value = value;
    }

    public static CityEnum fromValue(String value) {
        for (CityEnum city : CityEnum.values()) {
            if (city.value.equals(value)) {
                return city;
            }
        }
        throw new IllegalArgumentException("No enum constant with value: " + value);
    }
}
