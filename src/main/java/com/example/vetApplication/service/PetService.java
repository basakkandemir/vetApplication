package com.example.vetApplication.service;

import com.example.vetApplication.model.dto.PetDTO;

import java.util.List;

public interface PetService {

    void addPet(PetDTO petDTO);
    void deletePet(Long id);
    void updatePet(PetDTO petDTO);
    public List<PetDTO> findAll();
}
