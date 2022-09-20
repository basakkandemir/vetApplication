package com.example.vetApplication.controller;

import com.example.vetApplication.model.dto.PetOwnerDTO;
import com.example.vetApplication.service.PetOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/petOwner")
public class PetOwnerController {

    @Autowired
    private PetOwnerService petOwnerService;

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody PetOwnerDTO petOwnerDTO){
        this.petOwnerService.addOwner(petOwnerDTO);
        return new ResponseEntity<>
                ("Ekleme Başarılı", HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        this.petOwnerService.deleteOwner(id);
        return new ResponseEntity<>
                ("Silme Başarılı", HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity update(@RequestBody PetOwnerDTO petOwnerDTO){
        this.petOwnerService.updateOwner(petOwnerDTO);
        return new ResponseEntity<>
                ("Güncelleme Başarılı", HttpStatus.ACCEPTED);
    }

    @GetMapping("/getList")
    public List<PetOwnerDTO> getList(){
        return this.petOwnerService.findAll();
    }

}
