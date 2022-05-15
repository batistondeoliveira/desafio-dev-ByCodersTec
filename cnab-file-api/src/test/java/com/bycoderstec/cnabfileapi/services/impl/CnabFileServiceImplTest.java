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

import com.bycoderstec.cnabfileapi.domain.dto.LancamentoDTO;
import com.bycoderstec.cnabfileapi.services.impl.exceptions.FileException;

import lombok.RequiredArgsConstructor;

@SpringBootTest
@RequiredArgsConstructor
class CnabFileServiceImplTest {	

	private static final String CNAB_FILE_NAME = "src/main/resources/test/CNAB.txt";
	
	private static final String CNAB_FILE_NAME_WITH_BYTES_ZERO = "src/main/resources/test/CNAB_0_BYTES.txt";
	
	@InjectMocks
	private CnabFileServiceImpl service;
		
	private MultipartFile file;
	private MultipartFile fileBytesZero;
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		file = this.loadFile(CNAB_FILE_NAME);
		fileBytesZero = this.loadFile(CNAB_FILE_NAME_WITH_BYTES_ZERO);
	}
	
	@Test
	void whenProcessaCnabFileThenReturnLancamentoList() {
		List<LancamentoDTO> lancamento = service.processaCnabFile(file);
		
		assertEquals(21, lancamento.size());
	}
	
	@Test
	void whenProcessaCnabFileAndConteudoNullThenThronFileException() {					
		assertThrowsExactly(FileException.class, () -> { 
			service.processaCnabFile(null); 
		});
	}
	
	@Test
	void whenProcessaCnabFileAndConteudoBytesIsZeroThenThronFileException() {		
		assertThrowsExactly(FileException.class, () -> { 
			service.processaCnabFile(fileBytesZero);
		});
	}
		
	private MultipartFile loadFile(String cnabFileName) {		
		try {			
		    try (InputStream inputStream = new FileInputStream(cnabFileName)) {
				return new MockMultipartFile(cnabFileName, inputStream.readAllBytes());							
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}	
}
