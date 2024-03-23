package com.company.turbo.data.dto.common;

import com.company.turbo.data.entity.Year;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class YearDTO {
    private Long id;
    private Integer year;

    public YearDTO(Year year){
        this.id=year.getId();
        this.year=year.getYear();
    }
}
