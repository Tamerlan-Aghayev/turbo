package com.company.turbo.controller;

import com.company.turbo.data.dto.common.ModelDTO;
import com.company.turbo.service.ModelServiceImpl;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/model")
public class ModelController {
    private final ModelServiceImpl modelService;

    @GetMapping
    public ResponseEntity<List<ModelDTO>> getAllModels() {
        List<ModelDTO> models = modelService.getAllModels();
        return ResponseEntity.ok(models);
    }

    @GetMapping("/{name}")
    public ResponseEntity<ModelDTO> getModelByName(@PathVariable String name) {
        ModelDTO modelDTO = modelService.getModelByName(name);
        return ResponseEntity.ok(modelDTO);
    }

    @PostMapping
    public ResponseEntity<Void> addModel(@RequestBody ModelDTO modelDTO) {
        modelService.addOrUpdateModel(modelDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PutMapping
    public ResponseEntity<Void> UpdateModel(@RequestBody ModelDTO modelDTO) {
        modelService.addOrUpdateModel(modelDTO);
        return ResponseEntity.status(HttpStatus.OK).build();
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteModel(@PathVariable Long id) {
        modelService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
