package com.bycoderstec.cnabfileapi.services.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import java.io.FileInputStream;
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

	private static final String CNAB_FILE_NAME = "src/main/resources/test/CNAB.txt";
	
	private static final String CNAB_FILE_NAME_WITH_BYTES_ZERO = "src/main/resources/test/CNAB_0_BYTES.txt";
	
	@InjectMocks
	private CnabFileServiceImpl service;
		
	private CnabFileDTO dto;
	private CnabFileDTO dtoBytesZero;
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		dto = this.loadFile(CNAB_FILE_NAME);
		dtoBytesZero = this.loadFile(CNAB_FILE_NAME_WITH_BYTES_ZERO);
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
		
	private CnabFileDTO loadFile(String cnabFileName) {		
		try {			
		    try (InputStream inputStream = new FileInputStream(cnabFileName)) {
				MultipartFile conteudo = new MockMultipartFile(cnabFileName, inputStream.readAllBytes());
				
				return new CnabFileDTO(cnabFileName, conteudo, BYCODERSTEC);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}	
}
