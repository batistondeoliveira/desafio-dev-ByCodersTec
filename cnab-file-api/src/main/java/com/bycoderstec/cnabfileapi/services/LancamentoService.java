package com.bycoderstec.cnabfileapi.services;

import java.util.List;

import com.bycoderstec.cnabfileapi.domain.Lancamento;

public interface LancamentoService {
	
	public Lancamento create(Lancamento obj);
	public List<Lancamento> findAll();
}
