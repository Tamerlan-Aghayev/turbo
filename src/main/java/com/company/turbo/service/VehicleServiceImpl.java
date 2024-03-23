package com.company.turbo.service;

import com.company.turbo.data.dto.request.ParamsRequestDTO;
import com.company.turbo.data.dto.request.VehicleRequestDTO;
import com.company.turbo.data.dto.response.AllVehiclesResponseDTO;
import com.company.turbo.data.dto.response.SingleVehicleResponseDTO;
import com.company.turbo.data.entity.Seller;
import com.company.turbo.data.entity.Vehicle;
import com.company.turbo.data.enums.*;
import com.company.turbo.data.repository.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class VehicleServiceImpl {
    private final VehicleRepository vehicleRepository;
    private final ModelRepository modelRepository;
    private final SubModelRepository subModelRepository;
    private final YearRepository yearRepository;
    private final SellerRepository sellerRepository;


    public Page<AllVehiclesResponseDTO> getAllVehicles(Pageable pageable) {
        Page<Vehicle> vehicles = vehicleRepository.findAll(pageable);
        return vehicles.map(AllVehiclesResponseDTO::new);
    }

    public SingleVehicleResponseDTO getVehicleById(Long id) {
        Vehicle vehicle = vehicleRepository.findById(id).orElseThrow();
        vehicle.setView(vehicle.getView()+1L);
        vehicleRepository.save(vehicle);
        return new SingleVehicleResponseDTO(vehicle);
    }

    public Page<AllVehiclesResponseDTO> getAllVehiclesByParams(Pageable pageable, ParamsRequestDTO params) {
        Specification<Vehicle> spec = (root, query, cb)-> {

            List<Predicate> predicates = new ArrayList<>();
            if (params.getModel() != null && !params.getModel().isEmpty()) {
                predicates.add(cb.equal(root.get("model"), modelRepository.findByName(params.getModel())));
            }
            if (params.getSubModel() != null && !params.getSubModel().isEmpty()) {
                predicates.add(cb.equal(root.get("subModel"), subModelRepository.findByName(params.getSubModel())));
            }
            if (params.getBodyType() != null && !params.getBodyType().isEmpty()) {
                predicates.add(cb.equal(root.get("bodyType"), BodyTypeEnum.fromValue(params.getBodyType())));
            }
            if (params.getDistance() != null) {
                predicates.add(cb.lessThanOrEqualTo(root.get("distance"), params.getDistance()));
            }
            if (params.getColor() != null && !params.getColor().isEmpty()) {
                predicates.add(cb.equal(root.get("color"), ColorEnum.fromValue(params.getColor())));
            }
            if (params.getMaxCost() != null) {
                predicates.add(cb.lessThanOrEqualTo(root.get("cost"), params.getMaxCost()));
            }
            if (params.getMinCost() != null) {
                predicates.add(cb.greaterThanOrEqualTo(root.get("cost"), params.getMinCost()));
            }
            if (params.getYear() != null) {
                predicates.add(cb.equal(root.get("year"), yearRepository.findByYear(params.getYear())));
            }
            if (params.getEngineSize() != null) {
                predicates.add(cb.equal(root.get("engineSize"), EngineSizeEnum.fromVolume(params.getEngineSize())));
            }
            if (params.getHorsePower() != null) {
                predicates.add(cb.equal(root.get("horsePower"), params.getHorsePower()));
            }
            if (params.getSellerType() != null && !params.getSellerType().isEmpty()) {
                predicates.add(cb.equal(root.get("sellerType"), SellerTypeEnum.fromValue(params.getSellerType())));
            }
            if (params.getDistanceUnit() != null && !params.getDistanceUnit().isEmpty()) {
                predicates.add(cb.equal(root.get("distanceUnit"), DistanceUnitEnum.fromValue(params.getDistanceUnit())));
            }
            if (params.getCurrency() != null && !params.getCurrency().isEmpty()) {
                predicates.add(cb.equal(root.get("currency"), CurrencyEnum.fromValue(params.getCurrency())));
            }
            if (params.getAccident() != null && params.getAccident()) {
                predicates.add(cb.equal(root.get("accident"), params.getAccident()));
            }
            if (params.getColored() != null && params.getColored()) {
                predicates.add(cb.equal(root.get("colored"), params.getColored()));
            }
            if (params.getWrecked() != null && params.getWrecked()) {
                predicates.add(cb.equal(root.get("wrecked"), params.getWrecked()));
            }
            if (params.getPlace() != null && !params.getPlace().isEmpty()) {
                predicates.add(cb.equal(root.get("place"), PlaceEnum.fromValue(params.getPlace())));
            }
            if (params.getFuelType() != null && !params.getFuelType().isEmpty()) {
                predicates.add(cb.equal(root.get("fuelType"), FuelTypeEnum.fromValue(params.getFuelType())));
            }
            if (params.getLeatherInterior() != null && params.getLeatherInterior()) {
                predicates.add(cb.equal(root.get("leatherInterior"), params.getLeatherInterior()));
            }
            if (params.getABS() != null && params.getABS()) {
                predicates.add(cb.equal(root.get("ABS"), params.getABS()));
            }
            if (params.getParkingRadar() != null && params.getParkingRadar()) {
                predicates.add(cb.equal(root.get("parkingRadar"), params.getParkingRadar()));
            }
            if (params.getVentilation() != null && params.getVentilation()) {
                predicates.add(cb.equal(root.get("ventilation"), params.getVentilation()));
            }
            if (params.getCurtain() != null && params.getCurtain()) {
                predicates.add(cb.equal(root.get("curtain"), params.getCurtain()));
            }
            return cb.and(predicates.toArray(new Predicate[0]));
        };

        Page<Vehicle> vehicles = vehicleRepository.findAll(spec, pageable);
        return vehicles.map(AllVehiclesResponseDTO::new);
    }

    public void addOrUpdateVehicle(VehicleRequestDTO vehicleRequestDTO, Long sellerId){
        Vehicle vehicle=new Vehicle();
        vehicle.setId(vehicleRequestDTO.getId());
        vehicle.setABS(vehicleRequestDTO.getABS());
        vehicle.setCost(vehicleRequestDTO.getCost());
        vehicle.setAccident(vehicleRequestDTO.getAccident());
        vehicle.setColor(ColorEnum.fromValue(vehicleRequestDTO.getColor()));
        vehicle.setCurtain(vehicleRequestDTO.getCurtain());
        vehicle.setCurrency(CurrencyEnum.fromValue(vehicleRequestDTO.getCurrency()));
        vehicle.setCost(vehicleRequestDTO.getCost());
        vehicle.setYear(yearRepository.findByYear(vehicleRequestDTO.getYear()));
        vehicle.setBodyType(BodyTypeEnum.fromValue(vehicleRequestDTO.getBodyType()));
        vehicle.setColored(vehicleRequestDTO.getColored());
        vehicle.setDescription(vehicle.getDescription());
        vehicle.setDistance(vehicleRequestDTO.getDistance());
        vehicle.setDistanceUnit(DistanceUnitEnum.fromValue(vehicleRequestDTO.getDistanceUnit()));
        vehicle.setEngineSize(EngineSizeEnum.fromVolume(vehicleRequestDTO.getEngineSize()));
        vehicle.setFuelType(FuelTypeEnum.fromValue(vehicleRequestDTO.getFuelType()));
        vehicle.setWrecked(vehicleRequestDTO.getWrecked());
        vehicle.setVinCode(vehicleRequestDTO.getVinCode());
        vehicle.setVentilation(vehicleRequestDTO.getVentilation());

        Seller seller=sellerRepository.findById(sellerId).orElseThrow();

        vehicle.setSellerType(seller.getSellerType());
        vehicle.setSeller(seller);
        vehicle.setModel(modelRepository.findByName(vehicleRequestDTO.getModel()));
        vehicle.setSubModel(subModelRepository.findByName(vehicleRequestDTO.getSubModel()));
        vehicle.setHorsePower(vehicle.getHorsePower());
        vehicle.setPlace(PlaceEnum.fromValue(vehicleRequestDTO.getPlace()));
        vehicle.setImage(vehicleRequestDTO.getImage());
        vehicle.setParkingRadar(vehicleRequestDTO.getParkingRadar());
        vehicle.setLeatherInterior(vehicleRequestDTO.getLeatherInterior());
        vehicle.setPublishTime(LocalDate.now());
        vehicle.setView(0L);
        vehicleRepository.save(vehicle);

    }
    public void deleteVehicleById(Long id){
        vehicleRepository.deleteById(id);
    }

}
