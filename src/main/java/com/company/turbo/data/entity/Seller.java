package com.company.turbo.data.entity;

import com.company.turbo.data.enums.CityEnum;
import com.company.turbo.data.enums.SellerTypeEnum;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "seller", discriminatorType=DiscriminatorType.STRING)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Getter
    @Enumerated(EnumType.STRING)
    private SellerTypeEnum sellerType;
    private String name;
    private String email;
    private String phoneNumber;

    @OneToMany(mappedBy = "seller",cascade = CascadeType.ALL)
    private List<Vehicle> vehicles;
}
