package com.company.turbo.service;

import com.company.turbo.data.dto.common.YearDTO;
import com.company.turbo.data.entity.Year;
import com.company.turbo.data.repository.YearRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class YearServiceImpl {
    private final YearRepository yearRepository;

    public List<YearDTO> getAllYears(){
        return yearRepository.findAll().stream().map(YearDTO::new).collect(Collectors.toList());
    }
    public void addOrUpdateYear(YearDTO yearDTO){
        Year year=new Year();
        year.setYear(yearDTO.getYear());
        year.setId(year.getId());
        yearRepository.save(year);
    }
    public void deleteById(Long id){
        yearRepository.deleteById(id);
    }
}
