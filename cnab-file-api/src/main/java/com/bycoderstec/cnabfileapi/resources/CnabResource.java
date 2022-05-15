package com.bycoderstec.cnabfileapi.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bycoderstec.cnabfileapi.domain.dto.LancamentoDTO;
import com.bycoderstec.cnabfileapi.services.CnabFileService;
import com.bycoderstec.cnabfileapi.services.LancamentoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "CnabResource")
@RestController
@RequestMapping("/cnab")
public class CnabResource {

	@Autowired
	private CnabFileService cnabFileService;
	
	@Autowired
	private LancamentoService lancamentoService;	
	
	@Operation(summary = "Processa o arquivo CNAB e devolve o relatório")
	@PostMapping
	public ResponseEntity<Void> receiveCnabFile(MultipartFile file) {
		List<LancamentoDTO> listaLancamentoDTO = cnabFileService.processaCnabFile(file);
		lancamentoService.createAll(listaLancamentoDTO);		
		
		return ResponseEntity.noContent().build();
	}
}
