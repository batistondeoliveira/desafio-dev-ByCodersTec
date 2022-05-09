package com.bycoderstec.cnabfileapi.services.impl;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import com.bycoderstec.cnabfileapi.domain.Lancamento;
import com.bycoderstec.cnabfileapi.domain.Loja;
import com.bycoderstec.cnabfileapi.domain.Representante;
import com.bycoderstec.cnabfileapi.domain.dto.relatorio.LancamentoRelatorioDTO;
import com.bycoderstec.cnabfileapi.domain.dto.relatorio.LojaRelatorioDTO;
import com.bycoderstec.cnabfileapi.domain.dto.relatorio.RelatorioDTO;
import com.bycoderstec.cnabfileapi.services.LancamentoService;
import com.bycoderstec.cnabfileapi.services.LojaService;
import com.bycoderstec.cnabfileapi.services.RepresentanteService;
import com.bycoderstec.cnabfileapi.services.impl.helpers.enums.TipoTransacaoCnabEnum;

@SpringBootTest
public class RelatorioServiceImplTest {

	private static final int ID = 1;

	private static final int TIPO_TRANSACAO = TipoTransacaoCnabEnum.DEBITO.getCod();

	private static final LocalDate DATA = LocalDate.now();

	private static final double VALOR = 100.0;

	private static final String CPF = "93412773026";

	private static final String CARTAO = "5143********5523";

	private static final String HORA = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));

	private static final Integer ID_REPRESENTANTE = 1;
	
	private static final String REPRESENTANTE_LOJA = "Coders";
	
	private static final Integer ID_LOJA = 1;
	
	private static final String NOME_LOJA = "ByCodersTec";
	
	private static final Integer INDEX = 0;
	
	@InjectMocks
    private RelatorioServiceImpl service;
	
	@Mock
	private LojaService lojaService;
	
	@Mock
	private RepresentanteService representanteService;
	
	@Mock
	private LancamentoService lancamentoService;
	
	@Mock
    private ModelMapper mapper;  
	
	private Lancamento lancamento;    
        
    private Loja loja;
        
    private Representante representante;
    
    private LojaRelatorioDTO lojaRelatorioDTO;
    
    private LancamentoRelatorioDTO lancamentoRelatorioDTO;
    
    private RelatorioDTO relatorioDTO;
    
	@BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startRelatorio();
    }
	
	@Test
	void whenGerarThenReturnRelatorioDTO() {
		when(lojaService.findAll()).thenReturn(List.of(loja));
		when(lancamentoService.findByLoja(any())).thenReturn(List.of(lancamento));
		when(representanteService.findById(anyInt())).thenReturn(representante);
		when(mapper.map(loja, LojaRelatorioDTO.class)).thenReturn(lojaRelatorioDTO);
		when(mapper.map(lancamento, LancamentoRelatorioDTO.class)).thenReturn(lancamentoRelatorioDTO);
		when(mapper.map(relatorioDTO, RelatorioDTO.class)).thenReturn(relatorioDTO);
		
		RelatorioDTO response = service.gerar();
		assertNotNull(response);
		assertEquals(RelatorioDTO.class, response.getClass());				
		assertEquals(NOME_LOJA, response.getLoja().get(INDEX).getNome());
		assertEquals(1, response.getLoja().get(INDEX).getLancamento().size());
		assertEquals(VALOR, response.getLoja().get(INDEX).getSaldoEmConta());
	}
	
	private void startRelatorio() {
		loja = new Loja(ID_LOJA, NOME_LOJA);		
    	representante = new Representante(ID_REPRESENTANTE, REPRESENTANTE_LOJA, loja);
        lancamento = new Lancamento(ID, TIPO_TRANSACAO, DATA, VALOR, CPF, CARTAO, HORA, representante, loja);
        lancamentoRelatorioDTO = new LancamentoRelatorioDTO(ID, TIPO_TRANSACAO, DATA, VALOR, CPF, CARTAO, HORA, representante.getNome());
        lojaRelatorioDTO = new LojaRelatorioDTO(NOME_LOJA, List.of(lancamentoRelatorioDTO), VALOR);
        relatorioDTO = new RelatorioDTO(List.of(lojaRelatorioDTO));        
	}
}
