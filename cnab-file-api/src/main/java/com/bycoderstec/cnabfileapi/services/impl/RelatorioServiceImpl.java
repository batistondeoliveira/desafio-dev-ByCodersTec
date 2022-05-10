package com.bycoderstec.cnabfileapi.services.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bycoderstec.cnabfileapi.domain.Lancamento;
import com.bycoderstec.cnabfileapi.domain.Loja;
import com.bycoderstec.cnabfileapi.domain.Representante;
import com.bycoderstec.cnabfileapi.domain.dto.relatorio.LancamentoRelatorioDTO;
import com.bycoderstec.cnabfileapi.domain.dto.relatorio.LojaRelatorioDTO;
import com.bycoderstec.cnabfileapi.domain.dto.relatorio.RelatorioDTO;
import com.bycoderstec.cnabfileapi.services.LancamentoService;
import com.bycoderstec.cnabfileapi.services.LojaService;
import com.bycoderstec.cnabfileapi.services.RelatorioService;
import com.bycoderstec.cnabfileapi.services.RepresentanteService;

@Service
public class RelatorioServiceImpl implements RelatorioService {

	@Autowired
	private RepresentanteService representanteService;
	
	@Autowired
	private LancamentoService lancamentoService;
	
	@Autowired
	private LojaService lojaService;
	
	@Autowired
    private ModelMapper mapper;
	
	private LancamentoRelatorioDTO fromLancamento(Lancamento lancamento) {
		LancamentoRelatorioDTO lancamentoRelatorioDTO = mapper.map(lancamento, LancamentoRelatorioDTO.class);
		Representante representante = representanteService.findById(lancamento.getRepresentante().getId());
		
		lancamentoRelatorioDTO.setRepresentanteLoja(representante.getNome());
		
		return lancamentoRelatorioDTO;
	}
		
	private LojaRelatorioDTO prepareRelatorio(Loja loja) {	
		LojaRelatorioDTO lojaRelatorioDTO = mapper.map(loja, LojaRelatorioDTO.class);		
						
		List<LancamentoRelatorioDTO> lancamentoRelatorioDTO = lancamentoService.findByLoja(loja).stream()
				.map(this::fromLancamento)				
				.toList();		
		
		lojaRelatorioDTO.setLancamento(lancamentoRelatorioDTO);
		
		Double saldoPorLoja = lancamentoRelatorioDTO.stream().mapToDouble(LancamentoRelatorioDTO::getValor).sum();
		
		lojaRelatorioDTO.setSaldoPorLoja(saldoPorLoja);
		
		return lojaRelatorioDTO;
	}
	
	@Override
	public RelatorioDTO gerar() {
		List<Loja> lista = lojaService.findAll();		
				
		return new RelatorioDTO(lista.stream()
			.map(this::prepareRelatorio)
			.toList()
		);
	}
}
