package com.api.spring_api.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import com.api.spring_api.entities.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
    Page<Medico> findAllByEnabledTrue(org.springframework.data.domain.Pageable paginacao);
}
