package com.company.turbo.data.repository;

import com.company.turbo.data.entity.Vehicle;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long>, JpaSpecificationExecutor<Vehicle>{
    Page<Vehicle> findAll(Pageable pageable);
    Page<Vehicle> findAll(Specification<Vehicle> spec, Pageable pageable);

}
