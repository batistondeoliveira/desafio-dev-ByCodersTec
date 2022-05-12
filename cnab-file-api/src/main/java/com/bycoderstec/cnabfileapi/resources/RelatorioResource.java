package com.bycoderstec.cnabfileapi.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bycoderstec.cnabfileapi.domain.dto.relatorio.RelatorioDTO;
import com.bycoderstec.cnabfileapi.services.RelatorioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "RelatorioResource")
@RestController
@RequestMapping("/relatorio")
public class RelatorioResource {
	@Autowired
	private RelatorioService relatorioService;
	
	@Operation(summary = "Busca o relatório financeiro")
	@GetMapping
	public ResponseEntity<RelatorioDTO> obterRelatorio() {
		RelatorioDTO obj = relatorioService.gerar();
		
		return ResponseEntity.ok().body(obj);
	}
}
