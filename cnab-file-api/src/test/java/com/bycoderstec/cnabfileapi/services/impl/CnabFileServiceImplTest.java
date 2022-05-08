package com.bycoderstec.cnabfileapi.services.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import com.bycoderstec.cnabfileapi.domain.dto.CnabFileDTO;
import com.bycoderstec.cnabfileapi.domain.dto.LancamentoDTO;
import com.bycoderstec.cnabfileapi.services.impl.exceptions.FileException;

import lombok.RequiredArgsConstructor;

@SpringBootTest
@RequiredArgsConstructor
class CnabFileServiceImplTest {
	
	private static final String BYCODERSTEC = "bycoderstec";

	private static final String CNAB_FILE_NAME = "CNAB.txt";
	
	private static final String CNAB_FILE_NAME_WITH_BYTES_ZERO = "CNAB_0_BYTES.txt";
	
	@InjectMocks
	private CnabFileServiceImpl service;
		
	private CnabFileDTO dto;
	private CnabFileDTO dtoBytesZero;
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		this.loadFile();
		this.loadByteZero();
	}
	
	@Test
	void whenProcessaCnabFileThenReturnLancamentoList() {
		List<LancamentoDTO> lancamento = service.processaCnabFile(dto);
		
		assertEquals(21, lancamento.size());
	}
	
	@Test
	void whenProcessaCnabFileAndConteudoNullThenThronFileException() {
		dto.setConteudo(null);		
		
		assertThrowsExactly(FileException.class, () -> { 
			service.processaCnabFile(dto); 
		});
	}
	
	@Test
	void whenProcessaCnabFileAndConteudoBytesIsZeroThenThronFileException() {		
		assertThrowsExactly(FileException.class, () -> { 
			service.processaCnabFile(dtoBytesZero);
		});
	}
		
	private void loadFile() {		
		try {			
		    InputStream inputStream = CnabFileServiceImplTest.class.getResourceAsStream(CNAB_FILE_NAME);
		    
			MultipartFile conteudo = new MockMultipartFile(CNAB_FILE_NAME, inputStream.readAllBytes());
			
			dto = new CnabFileDTO(CNAB_FILE_NAME, conteudo, BYCODERSTEC);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
	private void loadByteZero() {
		try {			
		    InputStream inputStream = CnabFileServiceImplTest.class.getResourceAsStream(CNAB_FILE_NAME_WITH_BYTES_ZERO);
		    
			MultipartFile conteudo = new MockMultipartFile(CNAB_FILE_NAME_WITH_BYTES_ZERO, inputStream.readAllBytes());
			
			dtoBytesZero = new CnabFileDTO(CNAB_FILE_NAME_WITH_BYTES_ZERO, conteudo, BYCODERSTEC);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
