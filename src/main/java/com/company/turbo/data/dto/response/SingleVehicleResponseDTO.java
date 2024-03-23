package com.company.turbo.data.dto.response;

import com.company.turbo.data.entity.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SingleVehicleResponseDTO {

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
    private ShortSellerResponseDTO seller;
    private LocalDate publishTime;
    private Long view;

    public SingleVehicleResponseDTO(Vehicle vehicle) {
        this.id = vehicle.getId();
        this.model = vehicle.getModel().getName();
        this.subModel = vehicle.getSubModel().getName();
        this.bodyType = vehicle.getBodyType().getValue();
        this.distance = vehicle.getDistance();
        this.distanceUnit = vehicle.getDistanceUnit().getValue();
        this.color = vehicle.getColor().getValue();
        this.cost = vehicle.getCost();
        this.currency = vehicle.getCurrency().getValue();
        this.accident = vehicle.getAccident();
        this.colored = vehicle.getColored();
        this.wrecked = vehicle.getWrecked();
        this.place = vehicle.getPlace().getValue();
        this.vinCode = vehicle.getVinCode();
        this.description = vehicle.getDescription();
        this.fuelType = vehicle.getFuelType().getValue();
        this.year = vehicle.getYear().getYear();
        this.engineSize = vehicle.getEngineSize().getVolume();
        this.horsePower = vehicle.getHorsePower();
        this.leatherInterior = vehicle.getLeatherInterior();
        this.ABS = vehicle.getABS();
        this.parkingRadar = vehicle.getParkingRadar();
        this.ventilation = vehicle.getVentilation();
        this.curtain = vehicle.getCurtain();
        this.image = vehicle.getImage();
        this.seller = ShortSellerResponseDTO.getShortSellerDTO(vehicle.getSeller());
        this.publishTime = vehicle.getPublishTime();
        this.view = vehicle.getView();
    }
}
