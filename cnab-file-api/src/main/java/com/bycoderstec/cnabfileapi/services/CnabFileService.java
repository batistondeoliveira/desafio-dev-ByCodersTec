package com.bycoderstec.cnabfileapi.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bycoderstec.cnabfileapi.domain.Lancamento;
import com.bycoderstec.cnabfileapi.dto.CnabFileDTO;
import com.bycoderstec.cnabfileapi.services.exceptions.FileException;
import com.bycoderstec.cnabfileapi.services.helpers.LayoutCNAB;

import lombok.extern.slf4j.Slf4j;
 
@Slf4j
@Service
public class CnabFileService {
	
	private List<Lancamento> fromMultipartFile(MultipartFile file) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
		String linha = "";
		List<Lancamento> lista = new ArrayList<Lancamento>();
		
		while((linha = reader.readLine()) != null) {
			lista.add(LayoutCNAB.convertToLancamento(linha));
		}	
		
		return lista;
	}
	
	public List<Lancamento> processaCnabFile(CnabFileDTO dto) {
		
		try {
			if (dto.getConteudo() == null || dto.getConteudo().getBytes().length == 0) {
				throw new FileException("O arquivo cnab está vazio.");
			}
			
			return this.fromMultipartFile(dto.getConteudo());		
		} catch (IOException e) {
			log.error("Erro ao ler arquivo CNAB. Mensagem");	
			e.printStackTrace();
			throw new FileException("Erro ao ler arquivo CNAB");			
		}
	}
}
