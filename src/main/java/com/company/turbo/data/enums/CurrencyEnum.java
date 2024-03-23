package com.company.turbo.data.enums;

import lombok.Getter;

@Getter
public enum CurrencyEnum {
    AZN("AZN"),
    EUR("EUR"),
    USD("USD");

    private final String value;

    CurrencyEnum(String value) {
        this.value = value;
    }

    public static CurrencyEnum fromValue(String value) {
        for (CurrencyEnum currency : CurrencyEnum.values()) {
            if (currency.value.equals(value)) {
                return currency;
            }
        }
        throw new IllegalArgumentException("No enum constant with value: " + value);
    }
}
