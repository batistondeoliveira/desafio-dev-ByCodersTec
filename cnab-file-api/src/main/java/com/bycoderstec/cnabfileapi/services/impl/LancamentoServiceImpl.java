package com.bycoderstec.cnabfileapi.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bycoderstec.cnabfileapi.domain.Lancamento;
import com.bycoderstec.cnabfileapi.domain.Loja;
import com.bycoderstec.cnabfileapi.domain.Representante;
import com.bycoderstec.cnabfileapi.domain.dto.LancamentoDTO;
import com.bycoderstec.cnabfileapi.repositories.LancamentoRepository;
import com.bycoderstec.cnabfileapi.services.LancamentoService;
import com.bycoderstec.cnabfileapi.services.LojaService;
import com.bycoderstec.cnabfileapi.services.RepresentanteService;

@Service
public class LancamentoServiceImpl implements LancamentoService {
	
	@Autowired
	private LancamentoRepository repository;
	
	@Autowired
    private ModelMapper mapper;
	
	@Autowired
	private LojaService lojaService;
	
	@Autowired
	private RepresentanteService representanteService;	
	
	private Lancamento fromDTO(LancamentoDTO dto) {	
		Loja loja = lojaService.findByNomeOrCreate(dto.getNomeLoja());
		
		Representante representante = representanteService.findByNomeAndLojaOrCreate(dto.getRepresentanteLoja(), loja);
		
		Lancamento lancamento = mapper.map(dto, Lancamento.class);
		lancamento.setRepresentante(representante);
		lancamento.setLoja(loja);
		
		return lancamento;
	}
	
	@Transactional
	@Override
	public List<Lancamento> createAll(List<LancamentoDTO> lista) {
		List<Lancamento> listaLancamento = lista.stream().map(dto -> fromDTO(dto))
			.collect(Collectors.toList());
				
		return repository.saveAll(listaLancamento);
	}

	@Override
	public List<Lancamento> findAll() {	
		return repository.findAll();
	}

	@Override
	public List<Lancamento> findByLoja(Loja loja) {
		return repository.findByLoja(loja);
	}	
}
