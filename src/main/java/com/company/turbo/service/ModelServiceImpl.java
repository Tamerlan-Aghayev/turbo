package com.company.turbo.service;

import com.company.turbo.data.dto.common.ModelDTO;
import com.company.turbo.data.entity.Model;
import com.company.turbo.data.repository.ModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ModelServiceImpl {

    private final ModelRepository modelRepository;

    public List<ModelDTO> getAllModels() {
        List<Model> models = modelRepository.findAll();
        return models.stream().map(ModelDTO::new).collect(Collectors.toList());
    }
    public ModelDTO getModelByName(String name){
        return new ModelDTO((modelRepository.findByName(name)));
    }
    public void addOrUpdateModel(ModelDTO modelDTO){
        Model model=new Model();
        model.setId(modelDTO.getId());
        model.setName(modelDTO.getName());
        modelRepository.save(model);
    }
    public void deleteById(Long id){
       modelRepository.deleteById(id);
    }
}
