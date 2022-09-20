package com.example.vetApplication.controller;

import com.example.vetApplication.model.dto.PetDTO;
import com.example.vetApplication.model.entity.Pet;
import com.example.vetApplication.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pet")
public class PetController {

    @Autowired
    private PetService petService;

    @PostMapping("/add")
    public ResponseEntity addPet(@RequestBody PetDTO petDTO){
        this.petService.addPet(petDTO);
        return new ResponseEntity<>
                ("Ekleme Başarılı", HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePet(@PathVariable(name="id") Long id){
        this.petService.deletePet(id);
        return new ResponseEntity<>
                ("Silme Başarılı", HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity updatePet(@RequestBody PetDTO petDTO){
        this.petService.updatePet(petDTO);
        return new ResponseEntity<>
                ("Güncelleme Başarılı", HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public List<PetDTO> getList(){
        return this.petService.findAll();
    }






}
