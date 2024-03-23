package com.company.turbo.data.entity;

import com.company.turbo.data.enums.CityEnum;
import com.company.turbo.data.enums.SellerTypeEnum;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("Personal")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Personal extends Seller{
    @Enumerated(EnumType.STRING)
    private final SellerTypeEnum sellerType=SellerTypeEnum.PERSONAL;
    @Enumerated(EnumType.STRING)
    private CityEnum city;
}
