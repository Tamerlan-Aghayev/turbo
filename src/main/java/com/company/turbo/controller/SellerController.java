package com.company.turbo.controller;
import com.company.turbo.data.dto.common.FullPersonalDTO;
import com.company.turbo.data.dto.common.FullSalonDTO;
import com.company.turbo.data.dto.common.FullSellerDTO;
import com.company.turbo.service.SellerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/sellers")
@RequiredArgsConstructor
public class SellerController {

    private final SellerServiceImpl sellerService;

    @GetMapping("/{id}")
    public ResponseEntity<FullSellerDTO> getSellerById(@PathVariable Long id) {
        FullSellerDTO sellerDTO = sellerService.getSellerById(id);
        return ResponseEntity.ok(sellerDTO);
    }

    @PostMapping("/personal")
    public ResponseEntity<Void> addPersonal(@RequestBody FullPersonalDTO fullPersonalDTO) {
        sellerService.addOrUpdatePersonal(fullPersonalDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PutMapping("/personal")
    public ResponseEntity<Void> updatePersonal(@RequestBody FullPersonalDTO fullPersonalDTO) {
        sellerService.addOrUpdatePersonal(fullPersonalDTO);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/salon")
    public ResponseEntity<Void> addSalon(@RequestBody FullSalonDTO fullSalonDTO) {
        sellerService.addOrUpdateSalon(fullSalonDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/salon")
    public ResponseEntity<Void>updateSalon(@RequestBody FullSalonDTO fullSalonDTO) {
        sellerService.addOrUpdateSalon(fullSalonDTO);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSeller(@PathVariable Long id) {
        sellerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
