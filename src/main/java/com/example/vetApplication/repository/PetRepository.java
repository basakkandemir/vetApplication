package com.example.vetApplication.repository;

import com.example.vetApplication.model.entity.Pet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository
        extends CrudRepository<Pet,Long> {
}
