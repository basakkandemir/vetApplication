package com.example.vetApplication.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PetOwnerDTO {

    private Long id;
    private String name;
    private String surname;
    private Integer age;
    private String email;
    private Long phoneNumber;
}
