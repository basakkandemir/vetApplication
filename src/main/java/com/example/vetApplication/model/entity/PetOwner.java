package com.example.vetApplication.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
public class PetOwner extends BaseEntity{

    @OneToMany(mappedBy = "petOwner")
    private List<Pet> pets;

    private String name;
    private String surname;
    private Integer age;
    private String email;
    private Long phoneNumber;


}
