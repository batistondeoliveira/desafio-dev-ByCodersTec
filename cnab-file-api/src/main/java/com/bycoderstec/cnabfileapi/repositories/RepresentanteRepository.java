package com.bycoderstec.cnabfileapi.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bycoderstec.cnabfileapi.domain.Loja;
import com.bycoderstec.cnabfileapi.domain.Representante;

@Repository
public interface RepresentanteRepository extends JpaRepository<Representante, Integer> {

	public Optional<Representante> findByNomeAndLoja(String nome, Loja loja);
}
