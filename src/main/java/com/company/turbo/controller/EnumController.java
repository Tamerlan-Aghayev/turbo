package com.company.turbo.controller;

import com.company.turbo.data.enums.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/enums")
public class EnumController {
    @GetMapping("/body_types")
    public ResponseEntity<List<String>> getBodyTypes(){
        return ResponseEntity.ok(Arrays.stream(BodyTypeEnum.values())
                .map(BodyTypeEnum::getValue)
                .toList());
    }
    @GetMapping("/cities")
    public ResponseEntity<List<String>> getCities(){
        return ResponseEntity.ok(Arrays.stream(CityEnum.values())
                .map(CityEnum::getValue)
                .toList());
    }
    @GetMapping("/currencies")
    public ResponseEntity<List<String>> getCurrencies(){
        return ResponseEntity.ok(Arrays.stream(CurrencyEnum.values())
                .map(CurrencyEnum::getValue)
                .toList());
    }
    @GetMapping("/colors")
    public ResponseEntity<List<String>> getColors(){
        return ResponseEntity.ok(Arrays.stream(ColorEnum.values())
                .map(ColorEnum::getValue)
                .toList());
    }
    @GetMapping("/distance_units")
    public ResponseEntity<List<String>> getDistanceUnits(){
        return ResponseEntity.ok(Arrays.stream(DistanceUnitEnum.values())
                .map(DistanceUnitEnum::getValue)
                .toList());
    }@GetMapping("/engine_sizes")
    public ResponseEntity<List<Integer>> getEngineSize(){
        return ResponseEntity.ok(Arrays.stream(EngineSizeEnum.values())
                .map(EngineSizeEnum::getVolume)
                .toList());
    }@GetMapping("/fuel_types")
    public ResponseEntity<List<String>> getFuelTypes(){
        return ResponseEntity.ok(Arrays.stream(FuelTypeEnum.values())
                .map(FuelTypeEnum::getValue)
                .toList());
    }@GetMapping("/market_place")
    public ResponseEntity<List<String>> getMarketPlaces(){
        return ResponseEntity.ok(Arrays.stream(MarketPlaceEnum.values())
                .map(MarketPlaceEnum::getValue)
                .toList());
    }@GetMapping("/ownerships")
    public ResponseEntity<List<String>> getOwnerships(){
        return ResponseEntity.ok(Arrays.stream(OwnershipEnum.values())
                .map(OwnershipEnum::getValue)
                .toList());
    }@GetMapping("/places")
    public ResponseEntity<List<String>> getPlaces(){
        return ResponseEntity.ok(Arrays.stream(PlaceEnum.values())
                .map(PlaceEnum::getValue)
                .toList());
    }@GetMapping("/seller_types")
    public ResponseEntity<List<String>> getSellerTypes(){
        return ResponseEntity.ok(Arrays.stream(SellerTypeEnum.values())
                .map(SellerTypeEnum::getValue)
                .toList());
    }@GetMapping("/steering")
    public ResponseEntity<List<String>> getSteering(){
        return ResponseEntity.ok(Arrays.stream(SteeringEnum.values())
                .map(SteeringEnum::getValue)
                .toList());
    }@GetMapping("/transmission")
    public ResponseEntity<List<String>> getTransmissions(){
        return ResponseEntity.ok(Arrays.stream(TransmissionEnum.values())
                .map(TransmissionEnum::getValue)
                .toList());
    }

}
