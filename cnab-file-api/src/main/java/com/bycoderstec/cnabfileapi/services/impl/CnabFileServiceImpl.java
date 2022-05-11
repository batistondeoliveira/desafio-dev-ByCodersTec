package com.bycoderstec.cnabfileapi.services.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bycoderstec.cnabfileapi.domain.dto.CnabFileDTO;
import com.bycoderstec.cnabfileapi.domain.dto.LancamentoDTO;
import com.bycoderstec.cnabfileapi.services.CnabFileService;
import com.bycoderstec.cnabfileapi.services.impl.exceptions.FileException;
import com.bycoderstec.cnabfileapi.services.impl.helpers.LayoutCNAB;

import lombok.extern.slf4j.Slf4j;
 
@Slf4j
@Service
public class CnabFileServiceImpl implements CnabFileService {
	
	private List<LancamentoDTO> fromMultipartFile(MultipartFile file) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
		String linha = "";
		List<LancamentoDTO> lista = new ArrayList<>();
		
		while((linha = reader.readLine()) != null) {
			lista.add(LayoutCNAB.convertToLancamento(linha));
		}	
		
		return lista;
	}
	
	@Override
	public List<LancamentoDTO> processaCnabFile(CnabFileDTO dto) {
		
		try {
			if (dto.getConteudo() == null || dto.getConteudo().getBytes().length == 0) {
				throw new FileException("O arquivo cnab está vazio.");
			}
			
			return this.fromMultipartFile(dto.getConteudo());		
		} catch (IOException e) {
			log.error("Erro ao ler arquivo CNAB. Mensagem");			
			throw new FileException("Erro ao ler arquivo CNAB");			
		}
	}
}
