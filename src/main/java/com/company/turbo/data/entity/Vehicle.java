package com.company.turbo.data.entity;

import com.company.turbo.data.enums.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;

    @ManyToOne
    @JoinColumn(name = "submodel_id")
    private SubModel subModel;

    @Enumerated(EnumType.STRING)
    private BodyTypeEnum bodyType;

    private Long distance;

    @Enumerated(EnumType.STRING)
    private DistanceUnitEnum distanceUnit;

    @Enumerated(EnumType.STRING)
    private ColorEnum color;

    private BigDecimal cost;

    @Enumerated(EnumType.STRING)
    private CurrencyEnum currency;

    private Boolean accident;
    private Boolean colored;
    private Boolean wrecked;

    @Enumerated(EnumType.STRING)
    private PlaceEnum place;

    private String vinCode;

    private String description;

    @Enumerated(EnumType.STRING)
    private FuelTypeEnum fuelType;

    @ManyToOne
    @JoinColumn(name = "year_id")
    private Year year;

    @Enumerated(EnumType.STRING)
    private EngineSizeEnum engineSize;

    private Double horsePower;

    private Boolean leatherInterior;
    private Boolean ABS;
    private Boolean parkingRadar;
    private Boolean ventilation;
    private Boolean curtain;

    @Lob
    private byte[] image;
    @Enumerated(EnumType.STRING)
    private SellerTypeEnum sellerType;
    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;
    private LocalDate publishTime;
    private Long view;
}
