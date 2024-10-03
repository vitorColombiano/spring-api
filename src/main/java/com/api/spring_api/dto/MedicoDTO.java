package com.api.spring_api.dto;

import com.api.spring_api.enums.Especialidade;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record MedicoDTO(
    @NotBlank
    String nome,

    @NotBlank
    @Pattern(regexp = "\\d{4,6}")
    String crm,

    @NotBlank
    @Email
    String email,

    @NotBlank
    @Pattern(regexp = "\\d{11}")
    String telefone,

    @NotNull
    Especialidade especialidade,

    @NotNull
    @Valid
    EnderecoDTO endereco
) {}
