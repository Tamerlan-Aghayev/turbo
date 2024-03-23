package com.company.turbo.data.dto.common;

import com.company.turbo.data.dto.response.AllVehiclesResponseDTO;
import com.company.turbo.data.entity.Vehicle;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class FullSellerDTO {
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private String sellerType;
    private List<AllVehiclesResponseDTO> vehicles;

    public FullSellerDTO(Long id, String name, String email, String phoneNumber, String sellerType, List<Vehicle> vehicles) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.sellerType=sellerType;
        this.vehicles = vehicles.stream().map(AllVehiclesResponseDTO::new).toList();
    }
}
