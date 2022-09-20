package com.example.vetApplication.repository;

import com.example.vetApplication.model.entity.PetOwner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetOwnerRepository
        extends CrudRepository<PetOwner, Long> {
}
