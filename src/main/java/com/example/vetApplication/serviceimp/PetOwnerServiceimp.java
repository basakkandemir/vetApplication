package com.example.vetApplication.serviceimp;

import com.example.vetApplication.model.dto.PetOwnerDTO;
import com.example.vetApplication.model.entity.PetOwner;
import com.example.vetApplication.repository.PetOwnerRepository;
import com.example.vetApplication.service.PetOwnerService;
import com.example.vetApplication.util.ModelMapperHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PetOwnerServiceimp implements PetOwnerService {

    @Autowired
    private PetOwnerRepository petOwnerRepository;

    @Autowired
    private ModelMapperHelper modelMapperHelper;

    @Override
    @Transactional
    public void addOwner(PetOwnerDTO petOwnerDTO) {
        PetOwner petOwner = this.modelMapperHelper
                .convertToModel(petOwnerDTO,PetOwner.class);
        this.petOwnerRepository.save(petOwner);
    }

    @Override
    @Transactional
    public void deleteOwner(Long id) {
        this.petOwnerRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void updateOwner(PetOwnerDTO petOwnerDTO) {
        Optional<PetOwner> petOwnerOptional =
                this.petOwnerRepository
                        .findById(petOwnerDTO.getId());
        if(petOwnerOptional.isPresent()){
            PetOwner petOwner = petOwnerOptional.get();
            petOwner.setId(petOwnerDTO.getId());
            petOwner.setName(petOwnerDTO.getName());
            petOwner.setSurname(petOwnerDTO.getSurname());
            petOwner.setAge(petOwnerDTO.getAge());
            petOwner.setEmail(petOwnerDTO.getEmail());
            petOwner.setPhoneNumber(petOwnerDTO.getPhoneNumber());
            this.petOwnerRepository.save(petOwner);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<PetOwnerDTO> findAll() {
        return modelMapperHelper.mapAll
                ((List<PetOwner>)this.petOwnerRepository.findAll(), PetOwnerDTO.class);
    }
}
