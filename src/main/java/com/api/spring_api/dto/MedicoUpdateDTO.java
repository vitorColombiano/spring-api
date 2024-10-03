package com.api.spring_api.dto;

import jakarta.validation.constraints.NotNull;

public record MedicoUpdateDTO(
    @NotNull
    Long id,
    String nome,
    String email,
    String telefone,
    EnderecoDTO endereco
) {
}
