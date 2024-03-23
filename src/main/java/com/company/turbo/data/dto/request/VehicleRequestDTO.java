package com.company.turbo.data.dto.request;

import com.company.turbo.data.dto.response.ShortSellerResponseDTO;
import com.company.turbo.data.enums.SellerTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleRequestDTO {
    private Long id;
    private String model;
    private String subModel;
    private String bodyType;
    private Long distance;
    private String distanceUnit;
    private String color;
    private BigDecimal cost;
    private String currency;
    private Boolean accident;
    private Boolean colored;
    private Boolean wrecked;
    private String place;
    private String vinCode;
    private String description;
    private String fuelType;
    private Integer year;
    private Integer engineSize;
    private Double horsePower;
    private Boolean leatherInterior;
    private Boolean ABS;
    private Boolean parkingRadar;
    private Boolean ventilation;
    private Boolean curtain;
    private byte[] image;
    private LocalDate publishTime;
    private Long view;
}
