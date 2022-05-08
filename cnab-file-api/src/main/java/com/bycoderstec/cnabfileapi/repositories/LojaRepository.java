package com.bycoderstec.cnabfileapi.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bycoderstec.cnabfileapi.domain.Loja;

@Repository
public interface LojaRepository extends JpaRepository<Loja, Integer> {

	public Optional<Loja> findByNome(String nome);
}
