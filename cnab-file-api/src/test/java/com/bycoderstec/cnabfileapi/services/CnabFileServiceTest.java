package com.bycoderstec.cnabfileapi.services;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import com.bycoderstec.cnabfileapi.domain.Lancamento;
import com.bycoderstec.cnabfileapi.dto.CnabFileDTO;
import com.bycoderstec.cnabfileapi.services.exceptions.FileException;

import lombok.RequiredArgsConstructor;

@SpringBootTest
@RequiredArgsConstructor
public class CnabFileServiceTest {
	
	private static final String BYCODERSTEC = "bycoderstec";

	private static final String CNAB_FILE_NAME = "CNAB.txt";
	
	private static final String CNAB_FILE_NAME_WITH_BYTES_ZERO = "CNAB_0_BYTES.txt";
	
	@InjectMocks
	private CnabFileService service;
		
	private CnabFileDTO dto;
	private CnabFileDTO dtoBytesZero;
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		this.loadFile();
		this.loadByteZero();
	}
	
	@Test
	public void whenProcessaCnabFileThenReturnLancamentoList() {
		List<Lancamento> lancamento = service.processaCnabFile(dto);
		
		Assertions.assertEquals(21, lancamento.size());
	}
	
	@Test
	public void whenProcessaCnabFileAndConteudoNullThenThronFileException() {
		dto.setConteudo(null);		
		
		Assertions.assertThrowsExactly(FileException.class, () -> { 
			service.processaCnabFile(dto); 
		});
	}
	
	@Test
	public void whenProcessaCnabFileAndConteudoBytesIsZeroThenThronFileException() {		
		Assertions.assertThrowsExactly(FileException.class, () -> { 
			service.processaCnabFile(dtoBytesZero);
		});
	}
	
	@SuppressWarnings("rawtypes")	
	public void loadFile() {		
		try {
			Class clazz = CnabFileServiceTest.class;
		    InputStream inputStream = clazz.getResourceAsStream(CNAB_FILE_NAME);
		    
			MultipartFile conteudo = new MockMultipartFile(CNAB_FILE_NAME, inputStream.readAllBytes());
			
			dto = new CnabFileDTO(CNAB_FILE_NAME, conteudo, BYCODERSTEC);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("rawtypes")
	public void loadByteZero() {
		try {
			Class clazz = CnabFileServiceTest.class;
		    InputStream inputStream = clazz.getResourceAsStream(CNAB_FILE_NAME_WITH_BYTES_ZERO);
		    
			MultipartFile conteudo = new MockMultipartFile(CNAB_FILE_NAME_WITH_BYTES_ZERO, inputStream.readAllBytes());
			
			dtoBytesZero = new CnabFileDTO(CNAB_FILE_NAME_WITH_BYTES_ZERO, conteudo, BYCODERSTEC);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
