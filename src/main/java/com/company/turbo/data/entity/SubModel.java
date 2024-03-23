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
public class SubModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "subModel",cascade = CascadeType.ALL)
    private List<Vehicle> vehicles;
    @ManyToOne
    @JoinColumn(name="model_id")
    private Model model;
    private String name;
}
