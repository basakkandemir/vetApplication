package com.example.vetApplication.serviceimp;

import com.example.vetApplication.model.dto.PetDTO;
import com.example.vetApplication.model.entity.Pet;
import com.example.vetApplication.repository.PetRepository;
import com.example.vetApplication.service.PetService;
import com.example.vetApplication.util.ModelMapperHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PetServiceimp implements PetService {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private ModelMapperHelper modelMapperHelper;

    @Override
    @Transactional
    public void addPet(PetDTO petDTO) {
        Pet pet = new Pet();
        pet.setName(petDTO.getName());
        pet.setAge(petDTO.getAge());
        pet.setSpecies(petDTO.getSpecies());
        pet.setId(petDTO.getId());
        petRepository.save(pet);
    }

    @Override
    @Transactional
    public void deletePet(Long id) {
        this.petRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void updatePet(PetDTO petDTO) {
        Optional<Pet> petOptional = this.petRepository
                .findById(petDTO.getId());
        if(petOptional.isPresent()){
            Pet pet = petOptional.get();
            pet.setName(petDTO.getName());
            pet.setId(petDTO.getId());
            pet.setAge(petDTO.getAge());
            this.petRepository.save(pet);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<PetDTO> findAll() {
        return modelMapperHelper.mapAll
                ((List<Pet>)this.petRepository.findAll(), PetDTO.class);
    }


}
