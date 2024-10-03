package com.api.spring_api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.spring_api.dto.MedicoDTO;
import com.api.spring_api.dto.MedicoListDTO;
import com.api.spring_api.dto.MedicoUpdateDTO;
import com.api.spring_api.entities.Medico;
import com.api.spring_api.repositories.MedicoRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<Medico> CadastrarMedico(@RequestBody @Valid MedicoDTO medico) {
        Medico medicoSalvo =  repository.save(new Medico(medico));
        return ResponseEntity.ok(medicoSalvo);
    }

    @GetMapping
    public Page<MedicoListDTO> ListarMedicos(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return repository.findAllByEnabledTrue(paginacao).map(MedicoListDTO::new);
    }

    @PutMapping
    @Transactional
    public void updateMedico(@RequestBody @Valid MedicoUpdateDTO dados){
        var medico = repository.getReferenceById(dados.id());
        medico.updateInformations(dados);
    }

    @PutMapping("delete/{id}")
    @Transactional
    public void deleteMedico(@PathVariable Long id){
        var medico = repository.getReferenceById(id);
        medico.excluir();
    }
}
