package com.company.turbo.data.repository;

import com.company.turbo.data.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository extends JpaRepository<Model, Long> {
    Model findByName(String name);
}
