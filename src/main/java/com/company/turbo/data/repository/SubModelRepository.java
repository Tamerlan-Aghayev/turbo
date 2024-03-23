package com.company.turbo.data.repository;

import com.company.turbo.data.entity.Model;
import com.company.turbo.data.entity.SubModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubModelRepository extends JpaRepository<SubModel, Long> {
    SubModel findByName(String name);
    List<SubModel> findSubModelsByModel(Model model);
}
