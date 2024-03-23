package com.company.turbo.data.dto.common;

import com.company.turbo.data.entity.Salon;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class FullSalonDTO extends FullSellerDTO {
    private String location;
    private String description;
    private String workingHours;
    private int announcements;

    public FullSalonDTO(Salon salon) {
        super(salon.getId(), salon.getName(), salon.getEmail(), salon.getPhoneNumber(), salon.getSellerType().getValue(), salon.getVehicles());
        this.location = salon.getLocation();
        this.description = salon.getDescription();
        this.workingHours = salon.getWorkingHours();
        this.announcements = salon.getAnnouncements();
    }
}
