package com.company.turbo.data.dto.common;

import com.company.turbo.data.entity.Personal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FullPersonalDTO extends FullSellerDTO {
    private String city;


    public FullPersonalDTO(Personal personal) {
        super(personal.getId(), personal.getName(), personal.getEmail(), personal.getPhoneNumber(), personal.getSellerType().getValue(), personal.getVehicles());
        this.city = personal.getCity().getValue();

    }
}
