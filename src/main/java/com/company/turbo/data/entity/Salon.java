package com.company.turbo.data.entity;

import com.company.turbo.data.enums.SellerTypeEnum;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@EqualsAndHashCode(callSuper = true)

@Entity
@DiscriminatorValue("Salon")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Salon extends Seller{
    @Enumerated(EnumType.STRING)
    private final SellerTypeEnum sellerType=SellerTypeEnum.SALON;
    private String location;
    private String description;
    private String workingHours;
    private int announcements;

}
