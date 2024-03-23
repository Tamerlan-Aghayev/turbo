package com.company.turbo.data.enums;

import lombok.Getter;

@Getter
public enum SellerTypeEnum {
    SALON("Salon"),
    PERSONAL("Personal");
    private final String value;

    SellerTypeEnum(String value) {
        this.value = value;
    }

    public static SellerTypeEnum fromValue(String value) {
        for (SellerTypeEnum seller : SellerTypeEnum.values()) {
            if (seller.value.equals(value)) {
                return seller;
            }
        }
        throw new IllegalArgumentException("No enum constant with value: " + value);
    }
}
