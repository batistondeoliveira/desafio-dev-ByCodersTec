package com.bycoderstec.cnabfileapi.services.impl;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.bycoderstec.cnabfileapi.domain.Loja;
import com.bycoderstec.cnabfileapi.repositories.LojaRepository;

@SpringBootTest
class LojaServiceImplTest {

	private static final int ID = 1;
	
	private static final String NOME_LOJA = "ByCodersTec";

	@InjectMocks
    private LojaServiceImpl service;

    @Mock
    private LojaRepository repository;

    private Loja loja;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startLoja();
    }
          
    @Test
    void whenCreateThenReturnSuccess() {    	
        when(repository.save(any())).thenReturn(loja);

        Loja response = service.create(loja);

        assertNotNull(response);               
        assertEquals(Loja.class, response.getClass());        
        assertEquals(ID, response.getId());
        assertEquals(NOME_LOJA, response.getNome());            	   
    }
    
    @Test
    void whenFindByNomeThenReturnAnListOfUsers() {
        when(repository.findByNome(any())).thenReturn(loja);

        Loja response = service.findByNome(NOME_LOJA);

        assertNotNull(response);        
        assertEquals(Loja.class, response.getClass());      
        assertEquals(ID, response.getId());        
        assertEquals(NOME_LOJA, response.getNome());    
    }
    
    private void startLoja() {    	    	
    	loja = new Loja(ID, NOME_LOJA);        
    }
}
