package com.company.turbo.data.dto.response;

import com.company.turbo.data.entity.Personal;
import com.company.turbo.data.entity.Salon;
import com.company.turbo.data.entity.Seller;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class ShortSellerResponseDTO {
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    public static ShortSellerResponseDTO getShortSellerDTO(Seller seller){
        if(seller instanceof Salon salon){
            return new ShortSalonResponseDTO(salon);
        }
        else if(seller instanceof Personal personal){
            return new ShortPersonalResponseDTO(personal);
        }
        else{
            throw new RuntimeException();
        }
    }
}

