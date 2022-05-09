package com.bycoderstec.cnabfileapi.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bycoderstec.cnabfileapi.domain.dto.CnabFileDTO;
import com.bycoderstec.cnabfileapi.domain.dto.LancamentoDTO;
import com.bycoderstec.cnabfileapi.domain.dto.relatorio.RelatorioDTO;
import com.bycoderstec.cnabfileapi.services.CnabFileService;
import com.bycoderstec.cnabfileapi.services.LancamentoService;
import com.bycoderstec.cnabfileapi.services.RelatorioService;

@RestController
@RequestMapping("/cnab")
public class CnabResource {

	@Autowired
	private CnabFileService cnabFileService;
	
	@Autowired
	private LancamentoService lancamentoService;
	
	@Autowired
	private RelatorioService relatorioService;
	
	@PostMapping
	public ResponseEntity<RelatorioDTO> receiveCnabFile(CnabFileDTO dtoObj) {
		List<LancamentoDTO> listaLancamentoDTO = cnabFileService.processaCnabFile(dtoObj);
		lancamentoService.createAll(listaLancamentoDTO);
		RelatorioDTO obj = relatorioService.gerar();
		
		return ResponseEntity.ok().body(obj);
	}
}
