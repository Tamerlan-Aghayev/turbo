package com.company.turbo.data.dto.common;

import com.company.turbo.data.entity.SubModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubModelDTO {
    private Long id;
    private String name;

    public SubModelDTO(SubModel subModel){
        this.id= subModel.getId();
        this.name=subModel.getName();
    }
}