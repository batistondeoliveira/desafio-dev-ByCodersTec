package com.bycoderstec.cnabfileapi.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bycoderstec.cnabfileapi.domain.Lancamento;
import com.bycoderstec.cnabfileapi.repositories.LancamentoRepository;
import com.bycoderstec.cnabfileapi.services.LancamentoService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LancamentoServiceImpl implements LancamentoService {
	
	private LancamentoRepository repository;

	@Override
	public List<Lancamento> createAll(List<Lancamento> lista) {
		return repository.saveAll(lista);
	}

	@Override
	public List<Lancamento> findAll() {	
		return repository.findAll();
	}
}
