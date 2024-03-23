package com.company.turbo.data.enums;


import lombok.Getter;

@Getter
public enum EngineSizeEnum {
    VOLUME_500(500),
    VOLUME_1000(1000),
    VOLUME_1500(1500),
    VOLUME_2000(2000),
    VOLUME_2500(2500),
    VOLUME_3000(3000),
    VOLUME_3500(3500),
    VOLUME_4000(4000),
    VOLUME_4500(4500),
    VOLUME_5000(5000),
    VOLUME_5500(5500),
    VOLUME_6000(6000),
    VOLUME_6500(6500),
    VOLUME_7000(7000),
    VOLUME_7500(7500),
    VOLUME_8000(8000),
    VOLUME_8500(8500),
    VOLUME_9000(9000),
    VOLUME_9500(9500),
    VOLUME_10000(10000),
    VOLUME_10500(10500),
    VOLUME_11000(11000),
    VOLUME_11500(11500),
    VOLUME_12000(12000),
    VOLUME_12500(12500),
    VOLUME_13000(13000),
    VOLUME_13500(13500),
    VOLUME_14000(14000),
    VOLUME_14500(14500),
    VOLUME_15000(15000),
    VOLUME_15500(15500),
    VOLUME_16000(16000);

    private final int volume;

    EngineSizeEnum(int volume) {
        this.volume = volume;
    }

    public static EngineSizeEnum fromVolume(int volume) {
        for (EngineSizeEnum size : EngineSizeEnum.values()) {
            if (size.volume == volume) {
                return size;
            }
        }
        throw new IllegalArgumentException("No enum constant with volume: " + volume);
    }
}

