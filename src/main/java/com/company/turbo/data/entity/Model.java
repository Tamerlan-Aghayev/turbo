package com.company.turbo.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "model", cascade=CascadeType.ALL)
    private List<Vehicle> vehicles;
    @OneToMany(mappedBy = "model",cascade = CascadeType.ALL)
    private List<SubModel> subModels;
    private String name;
}
