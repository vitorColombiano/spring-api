package com.api.spring_api.dto;

import com.api.spring_api.entities.Endereco;
import com.api.spring_api.entities.Medico;
import com.api.spring_api.enums.Especialidade;

public record MedicoListDTO(
    Long id,
    String nome,
    String crm,
    String email,
    Especialidade especialidade,
    Endereco endereco
) {

    public MedicoListDTO(Medico medico) {
        this(medico.getId(),medico.getNome(), medico.getCrm(), medico.getEmail(), medico.getEspecialidade(), medico.getEndereco());
    }
}
