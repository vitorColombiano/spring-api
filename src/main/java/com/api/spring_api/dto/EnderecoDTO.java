package com.api.spring_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record EnderecoDTO(
    @NotBlank
    String rua,

    String numero,

    String complemento,

    @NotBlank
    String bairro,

    @NotBlank
    String cidade,

    @NotBlank
    String estado,

    @NotNull
    @Pattern(regexp = "\\d{8}")
    String cep
) {}
