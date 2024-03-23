package com.company.turbo.data.dto.response;

import com.company.turbo.data.entity.Personal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShortPersonalResponseDTO extends ShortSellerResponseDTO{
    private String city;
    public ShortPersonalResponseDTO(Personal personal) {
        super(personal.getId(), personal.getName(), personal.getEmail(), personal.getPhoneNumber());
        this.city = personal.getCity().getValue();
    }
}
