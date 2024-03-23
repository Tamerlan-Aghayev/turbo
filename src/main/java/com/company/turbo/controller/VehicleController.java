package com.company.turbo.controller;

import com.company.turbo.data.dto.request.ParamsRequestDTO;
import com.company.turbo.data.dto.request.VehicleRequestDTO;
import com.company.turbo.data.dto.response.AllVehiclesResponseDTO;
import com.company.turbo.service.VehicleServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vehicle")
public class VehicleController {
    private final VehicleServiceImpl vehicleService;

    @PostMapping
    public ResponseEntity<Void> addVehicle(@RequestBody VehicleRequestDTO vehicleRequestDTO, @RequestParam("seller_id") Long sellerId) {
        vehicleService.addOrUpdateVehicle(vehicleRequestDTO, sellerId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<Void> updateVehicle(@RequestBody VehicleRequestDTO vehicleRequestDTO, @RequestParam("seller_id") Long sellerId) {
        vehicleService.addOrUpdateVehicle(vehicleRequestDTO, sellerId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/params")
    public ResponseEntity<Page<AllVehiclesResponseDTO>> getVehicleByParams(@RequestBody ParamsRequestDTO params,
                                                                           @RequestParam(defaultValue = "0") int page,
                                                                           @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<AllVehiclesResponseDTO> result = vehicleService.getAllVehiclesByParams(pageable, params);
        return ResponseEntity.ok(result);
    }

    @GetMapping
    public ResponseEntity<Page<AllVehiclesResponseDTO>> getAllVehicles(@RequestParam(defaultValue = "0") int page,
                                                                       @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<AllVehiclesResponseDTO> result = vehicleService.getAllVehicles(pageable);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
        vehicleService.deleteVehicleById(id);
        return ResponseEntity.noContent().build();
    }
}
