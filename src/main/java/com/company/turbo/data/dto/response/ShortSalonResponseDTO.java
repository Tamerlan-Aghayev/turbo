package com.company.turbo.data.dto.response;

import com.company.turbo.data.entity.Salon;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShortSalonResponseDTO extends ShortSellerResponseDTO {
    private String location;
    private String description;
    private String workingHours;
    private int announcements;

    public ShortSalonResponseDTO(Salon salon) {
        super(salon.getId(), salon.getName(), salon.getEmail(), salon.getPhoneNumber());
        this.location = salon.getLocation();
        this.description = salon.getDescription();
        this.workingHours = salon.getWorkingHours();
        this.announcements = salon.getAnnouncements();
    }
}
