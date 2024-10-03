package com.api.spring_api.entities;

import com.api.spring_api.dto.MedicoDTO;
import com.api.spring_api.dto.MedicoUpdateDTO;
import com.api.spring_api.enums.Especialidade;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "medicos")
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String crm;
    private String email;
    private String telefone;
    private boolean enabled;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    public Medico(MedicoDTO medico) {
        this.enabled = true;
        this.nome = medico.nome();
        this.crm = medico.crm();
        this.email = medico.email();
        this.telefone = medico.telefone();
        this.especialidade = medico.especialidade();
        this.endereco = new Endereco(medico.endereco());
    }

    public void updateInformations(MedicoUpdateDTO dados){
        if (dados.nome() != null){
            this.nome = dados.nome();
        }
        if (dados.telefone() != null){
            this.telefone = dados.telefone();
        }
        if (dados.email() != null){
            this.email = dados.email();
        }
        if (dados.endereco() != null){
            this.endereco.updateInformations(dados.endereco());
        }
    }

    public void excluir(){
        this.enabled = false;
    }
}
