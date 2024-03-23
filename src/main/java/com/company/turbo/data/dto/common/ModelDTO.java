package com.company.turbo.data.dto.common;

import com.company.turbo.data.entity.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModelDTO {
    private Long id;
    private String name;

    public ModelDTO(Model model){
        this.id= model.getId();
        this.name=model.getName();
    }
}
