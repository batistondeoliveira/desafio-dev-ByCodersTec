package com.bycoderstec.cnabfileapi.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bycoderstec.cnabfileapi.domain.Lancamento;
import com.bycoderstec.cnabfileapi.domain.dto.LancamentoDTO;
import com.bycoderstec.cnabfileapi.repositories.LancamentoRepository;
import com.bycoderstec.cnabfileapi.services.LancamentoService;

@Service
public class LancamentoServiceImpl implements LancamentoService {
	
	@Autowired
	private LancamentoRepository repository;
	
	@Autowired
    private ModelMapper mapper;

	@Override
	public List<Lancamento> createAll(List<LancamentoDTO> lista) {	
		return repository.saveAll(lista
			.stream().map(dto -> mapper.map(dto, Lancamento.class))
			.collect(Collectors.toList())
		);
	}

	@Override
	public List<Lancamento> findAll() {	
		return repository.findAll();
	}
}
