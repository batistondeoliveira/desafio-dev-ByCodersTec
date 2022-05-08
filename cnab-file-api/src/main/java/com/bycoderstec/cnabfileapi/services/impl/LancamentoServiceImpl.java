package com.bycoderstec.cnabfileapi.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bycoderstec.cnabfileapi.domain.Lancamento;
import com.bycoderstec.cnabfileapi.repositories.LancamentoRepository;
import com.bycoderstec.cnabfileapi.services.LancamentoService;

@Service
public class LancamentoServiceImpl implements LancamentoService {

	private LancamentoRepository repository;

	@Override
	public Lancamento create(Lancamento obj) {
		return repository.save(obj);
	}

	@Override
	public List<Lancamento> findAll() {	
		return repository.findAll();
	}
}
