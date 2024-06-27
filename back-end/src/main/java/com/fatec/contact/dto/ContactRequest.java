package com.fatec.contact.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ContactRequest(

    @NotNull(message = "Campo requerido!")
    String name,

    @NotBlank(message = "Cmapo requerido!")
    String email,
    String sex,
    String choose,
    String phone,
    String speci
    
    ) {
    
}
