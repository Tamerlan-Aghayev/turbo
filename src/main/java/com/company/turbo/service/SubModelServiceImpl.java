package com.company.turbo.service;

import com.company.turbo.data.dto.common.SubModelDTO;
import com.company.turbo.data.entity.Model;
import com.company.turbo.data.entity.SubModel;
import com.company.turbo.data.repository.ModelRepository;
import com.company.turbo.data.repository.SubModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class SubModelServiceImpl {
    private final SubModelRepository subModelRepository;
    private final ModelRepository modelRepository;

    public List<SubModelDTO> getAllSubModelsByModel(String modelName) {
        Model model=modelRepository.findByName(modelName);
        List<SubModel> subModel = subModelRepository.findSubModelsByModel(model);
        return subModel.stream().map(SubModelDTO::new).collect(Collectors.toList());
    }
    public void addOrUpdateSubModel(SubModelDTO subModelRequestDTO){
        SubModel subModel=new SubModel();
        subModel.setId(subModelRequestDTO.getId());
        subModel.setName(subModelRequestDTO.getName());
        subModelRepository.save(subModel);
    }
    public void deleteById(Long id){
        subModelRepository.deleteById(id);
    }
}
