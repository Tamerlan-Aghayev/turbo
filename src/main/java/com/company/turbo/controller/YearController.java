package com.company.turbo.controller;

import com.company.turbo.data.dto.common.YearDTO;
import com.company.turbo.service.YearServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/years")
@RequiredArgsConstructor
public class YearController {

    private final YearServiceImpl yearService;

    @GetMapping
    public ResponseEntity<List<YearDTO>> getAllYears() {
        List<YearDTO> years = yearService.getAllYears();
        return ResponseEntity.ok(years);
    }

    @PostMapping
    public ResponseEntity<Void> addYear(@RequestBody YearDTO yearDTO) {
        yearService.addOrUpdateYear(yearDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<Void>UpdateYear(@RequestBody YearDTO yearDTO) {
        yearService.addOrUpdateYear(yearDTO);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteYear(@PathVariable Long id) {
        yearService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
