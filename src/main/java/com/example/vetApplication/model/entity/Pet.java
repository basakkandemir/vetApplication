package com.example.vetApplication.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Pet extends BaseEntity{

    @ManyToOne
    private PetOwner petOwner;

    private String name;
    private String species;
    private Integer age;

}
