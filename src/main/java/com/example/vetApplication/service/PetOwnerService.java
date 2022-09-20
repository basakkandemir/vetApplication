package com.example.vetApplication.service;

import com.example.vetApplication.model.dto.PetOwnerDTO;

import java.util.List;

public interface PetOwnerService {

    void addOwner(PetOwnerDTO petOwnerDTO);
    void deleteOwner(Long id);
    void updateOwner(PetOwnerDTO petOwnerDTO);
    public List<PetOwnerDTO> findAll();
}
