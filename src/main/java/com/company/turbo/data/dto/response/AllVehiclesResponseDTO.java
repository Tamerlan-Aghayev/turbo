package com.company.turbo.data.dto.response;

import com.company.turbo.data.entity.Vehicle;
import com.company.turbo.data.entity.Year;
import com.company.turbo.data.enums.CurrencyEnum;
import com.company.turbo.data.enums.DistanceUnitEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AllVehiclesResponseDTO {
    private Long id;
    private BigDecimal cost;
    private LocalDate publishTime;
    private int year;
    private int engineSize;
    private String currency;
    private Long distance;
    private String distanceUnit;
    private byte[] image;
    public AllVehiclesResponseDTO(Vehicle vehicle){
        this.id= vehicle.getId();
        this.cost = vehicle.getCost();
        this.publishTime = vehicle.getPublishTime();
        this.year = vehicle.getYear().getYear();
        this.engineSize = vehicle.getEngineSize().getVolume();
        this.currency = vehicle.getCurrency().getValue();
        this.distance = vehicle.getDistance();
        this.distanceUnit = vehicle.getDistanceUnit().getValue();
        this.image=vehicle.getImage();
    }
}
