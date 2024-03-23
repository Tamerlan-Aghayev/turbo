package com.company.turbo.service;

import com.company.turbo.data.dto.common.FullPersonalDTO;
import com.company.turbo.data.dto.common.FullSalonDTO;
import com.company.turbo.data.dto.common.FullSellerDTO;
import com.company.turbo.data.entity.Personal;
import com.company.turbo.data.entity.Salon;
import com.company.turbo.data.entity.Seller;
import com.company.turbo.data.enums.CityEnum;
import com.company.turbo.data.enums.SellerTypeEnum;
import com.company.turbo.data.repository.SellerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class SellerServiceImpl {
    private final SellerRepository sellerRepository;
    public FullSellerDTO getSellerById(Long id){
        Seller seller=sellerRepository.findById(id).orElseThrow();
        if (seller.getSellerType()== SellerTypeEnum.PERSONAL){
            return new FullPersonalDTO((Personal) seller);

        }
        else if (seller.getSellerType()== SellerTypeEnum.SALON){
            return new FullSalonDTO((Salon) seller);

        }
        else throw new RuntimeException();
    }

    public void addOrUpdatePersonal(FullPersonalDTO fullPersonalDTO){
        Personal personal=new Personal();
        personal.setCity(CityEnum.fromValue(fullPersonalDTO.getCity()));
        personal.setId(fullPersonalDTO.getId());
        personal.setName(fullPersonalDTO.getName());
        personal.setSellerType(SellerTypeEnum.fromValue(fullPersonalDTO.getSellerType()));
        personal.setEmail(fullPersonalDTO.getEmail());
        personal.setPhoneNumber(fullPersonalDTO.getPhoneNumber());
        sellerRepository.save(personal);
    }

    public void addOrUpdateSalon(FullSalonDTO fullSalonDTO){
        Salon salon=new Salon();
        salon.setId(fullSalonDTO.getId());
        salon.setName(fullSalonDTO.getName());
        salon.setSellerType(SellerTypeEnum.fromValue(fullSalonDTO.getSellerType()));
        salon.setEmail(fullSalonDTO.getEmail());
        salon.setPhoneNumber(fullSalonDTO.getPhoneNumber());
        salon.setAnnouncements(fullSalonDTO.getAnnouncements());
        salon.setDescription(fullSalonDTO.getDescription());
        salon.setWorkingHours(fullSalonDTO.getWorkingHours());
        salon.setLocation(fullSalonDTO.getLocation());
        sellerRepository.save(salon);
    }
    public void deleteById(Long id){
        sellerRepository.deleteById(id);
    }
}
