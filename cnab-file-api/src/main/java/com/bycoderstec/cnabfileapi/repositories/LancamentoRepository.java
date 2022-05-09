package com.bycoderstec.cnabfileapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bycoderstec.cnabfileapi.domain.Lancamento;
import com.bycoderstec.cnabfileapi.domain.Loja;

@Repository
public interface LancamentoRepository extends JpaRepository<Lancamento, Integer> {

	public List<Lancamento> findByLoja(Loja loja);
}
