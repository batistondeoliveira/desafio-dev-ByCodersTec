package com.bycoderstec.cnabfileapi.services.impl;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

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
import com.bycoderstec.cnabfileapi.domain.dto.LancamentoDTO;
import com.bycoderstec.cnabfileapi.repositories.LancamentoRepository;
import com.bycoderstec.cnabfileapi.services.LojaService;
import com.bycoderstec.cnabfileapi.services.RepresentanteService;
import com.bycoderstec.cnabfileapi.services.impl.helpers.enums.TipoTransacaoCnabEnum;

@SpringBootTest
class LancamentoServiceImplTest {

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
    private LancamentoServiceImpl service;

    @Mock
    private LancamentoRepository repository;
    
    @Mock
    private ModelMapper mapper;    
    
    @Mock
    private LojaService lojaService;
    
    @Mock
    private RepresentanteService representanteService;
    
    private Lancamento lancamento;
    
    private LancamentoDTO dto;
        
    private Loja loja;
        
    private Representante representante;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startLancamento();
    }
          
    @Test
    void whenCreateThenReturnSuccess() {    	    	
    	when(lojaService.findByNomeOrCreate(anyString())).thenReturn(loja);    			
    	when(representanteService.findByNomeAndLojaOrCreate(anyString(), any())).thenReturn(representante);
    	when(mapper.map(any(), any())).thenReturn(lancamento);
        when(repository.saveAll(anyCollection())).thenReturn(List.of(lancamento));

        List<Lancamento> response = service.createAll(List.of(dto));

        assertNotNull(response);               
        assertEquals(response.size(), response.size());
        assertEquals(ID, response.get(INDEX).getId());
        assertEquals(TIPO_TRANSACAO, response.get(INDEX).getTipoTransacao().getCod());
        assertEquals(DATA, response.get(INDEX).getData());
        assertEquals(VALOR, response.get(INDEX).getValor());
        assertEquals(CPF, response.get(INDEX).getCpf());
        assertEquals(CARTAO, response.get(INDEX).getCartao());
        assertEquals(HORA, response.get(INDEX).getHora());
        assertEquals(representante, response.get(INDEX).getRepresentante());
        assertEquals(loja, response.get(INDEX).getLoja());            	   
    }
    
    @Test
    void whenFindAllThenReturnAnListOfLancamento() {
        when(repository.findAll()).thenReturn(List.of(lancamento));

        List<Lancamento> response = service.findAll();

        assertNotNull(response);
        assertEquals(1, response.size());
        assertEquals(Lancamento.class, response.get(INDEX).getClass());
      
        assertEquals(ID, response.get(INDEX).getId());
        assertEquals(TIPO_TRANSACAO, response.get(INDEX).getTipoTransacao().getCod());
        assertEquals(DATA, response.get(INDEX).getData());
        assertEquals(VALOR, response.get(INDEX).getValor());
        assertEquals(CPF, response.get(INDEX).getCpf());
        assertEquals(CARTAO, response.get(INDEX).getCartao());
        assertEquals(HORA, response.get(INDEX).getHora());
        assertEquals(representante, response.get(INDEX).getRepresentante());
        assertEquals(loja, response.get(INDEX).getLoja());    
    }
    
    @Test
    void whenFindByLojaThenReturnAnListOfLancamento() {
        when(repository.findByLoja(any())).thenReturn(List.of(lancamento));

        List<Lancamento> response = service.findByLoja(loja);

        assertNotNull(response);
        assertEquals(1, response.size());
        assertEquals(Lancamento.class, response.get(INDEX).getClass());
      
        assertEquals(ID, response.get(INDEX).getId());
        assertEquals(TIPO_TRANSACAO, response.get(INDEX).getTipoTransacao().getCod());
        assertEquals(DATA, response.get(INDEX).getData());
        assertEquals(VALOR, response.get(INDEX).getValor());
        assertEquals(CPF, response.get(INDEX).getCpf());
        assertEquals(CARTAO, response.get(INDEX).getCartao());
        assertEquals(HORA, response.get(INDEX).getHora());
        assertEquals(representante, response.get(INDEX).getRepresentante());
        assertEquals(loja, response.get(INDEX).getLoja());    
    }
    
    private void startLancamento() {
    	loja = new Loja(ID_LOJA, NOME_LOJA);
    	representante = new Representante(ID_REPRESENTANTE, REPRESENTANTE_LOJA, loja);
        lancamento = new Lancamento(ID, TIPO_TRANSACAO, DATA, VALOR, CPF, CARTAO, HORA, representante, loja);        
        dto = new LancamentoDTO(ID, TIPO_TRANSACAO, DATA, VALOR, CPF, CARTAO, HORA, representante.getNome(), loja.getNome());
    }
}
