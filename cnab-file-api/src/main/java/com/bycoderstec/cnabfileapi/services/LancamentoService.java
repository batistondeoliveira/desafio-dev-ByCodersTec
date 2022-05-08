package com.bycoderstec.cnabfileapi.services;

import java.util.List;

import com.bycoderstec.cnabfileapi.domain.Lancamento;
import com.bycoderstec.cnabfileapi.domain.dto.LancamentoDTO;

public interface LancamentoService {
		
	public List<Lancamento> createAll(List<LancamentoDTO> lista);
	public List<Lancamento> findAll();
}
