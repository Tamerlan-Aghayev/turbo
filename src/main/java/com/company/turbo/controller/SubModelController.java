package com.company.turbo.controller;

import com.company.turbo.data.dto.common.SubModelDTO;
import com.company.turbo.service.SubModelServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/subModel")
public class SubModelController {

    private final SubModelServiceImpl subModelService;

    @GetMapping("/{modelName}")
    public ResponseEntity<List<SubModelDTO>> getAllSubModelsByModel(@PathVariable String modelName) {
        List<SubModelDTO> subModels = subModelService.getAllSubModelsByModel(modelName);
        return ResponseEntity.ok(subModels);
    }

    @PostMapping

    public ResponseEntity<Void> addSubModel(@RequestBody SubModelDTO subModelDTO) {
        subModelService.addOrUpdateSubModel(subModelDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PutMapping
    public ResponseEntity<Void> updateSubModel(@RequestBody SubModelDTO subModelDTO) {
        subModelService.addOrUpdateSubModel(subModelDTO);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubModel(@PathVariable Long id) {
        subModelService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}