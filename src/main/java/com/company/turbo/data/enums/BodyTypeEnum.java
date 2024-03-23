package com.company.turbo.data.enums;
import lombok.Getter;

@Getter
public enum BodyTypeEnum {
    SEDAN("Sedan"),
    SUV("SUV"),
    HATCHBACK("Hatchback"),
    COUPE("Coupe"),
    CONVERTIBLE("Convertible"),
    WAGON("Wagon"),
    TRUCK("Truck"),
    VAN("Van"),
    MPV("MPV"),
    CUV("CUV"),
    PICKUP("Pickup"),
    SPORTS_CAR("Sports Car"),
    LIMOUSINE("Limousine"),
    MINIVAN("Minivan"),
    ROADSTER("Roadster"),
    COMPACT("Compact"),
    OTHER("Other");

    private final String value;

    BodyTypeEnum(String value) {
        this.value = value;
    }

    public static BodyTypeEnum fromValue(String value) {
        for (BodyTypeEnum type : BodyTypeEnum.values()) {
            if (type.value.equals(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("No enum constant with value: " + value);
    }
}
