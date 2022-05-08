package com.bycoderstec.cnabfileapi.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bycoderstec.cnabfileapi.domain.Loja;
import com.bycoderstec.cnabfileapi.repositories.LojaRepository;
import com.bycoderstec.cnabfileapi.services.LojaService;

@Service
public class LojaServiceImpl implements LojaService {
	
	@Autowired
	private LojaRepository repository;
	
	@Override
	public Loja create(Loja obj) {
		return repository.save(obj);
	}

	@Override
	public Loja findByNome(String nome) {
		return repository.findByNome(nome);
	}

}
