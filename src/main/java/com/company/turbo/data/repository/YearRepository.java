package com.company.turbo.data.repository;

import com.company.turbo.data.entity.Year;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface YearRepository extends JpaRepository<Year, Long> {
    Year findByYear(Integer year);
}
