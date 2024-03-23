package com.company.turbo.data.enums;
import lombok.Getter;

@Getter
public enum ColorEnum {
    BLACK("Black"),
    WHITE("White"),
    RED("Red"),
    BLUE("Blue"),
    SILVER("Silver"),
    GREY("Grey"),
    GREEN("Green"),
    YELLOW("Yellow"),
    ORANGE("Orange"),
    PURPLE("Purple"),
    BROWN("Brown"),
    GOLD("Gold"),
    PINK("Pink");

    private final String value;

    ColorEnum(String value) {
        this.value = value;
    }

    public static ColorEnum fromValue(String value) {
        for (ColorEnum color : ColorEnum.values()) {
            if (color.value.equals(value)) {
                return color;
            }
        }
        throw new IllegalArgumentException("No enum constant with value: " + value);
    }
}
