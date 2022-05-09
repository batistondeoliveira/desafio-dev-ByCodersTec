package com.bycoderstec.cnabfileapi.services.impl;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.bycoderstec.cnabfileapi.domain.Loja;
import com.bycoderstec.cnabfileapi.repositories.LojaRepository;
import com.bycoderstec.cnabfileapi.services.impl.exceptions.ObjectNotFoundException;

@SpringBootTest
class LojaServiceImplTest {

	private static final int ID = 1;
	
	private static final String NOME_LOJA = "ByCodersTec";
	
	private static final Integer INDEX = 0;

	@InjectMocks
    private LojaServiceImpl service;

    @Mock
    private LojaRepository repository;

    private Loja loja;
    
    private Optional<Loja> optionalLoja;

    private static final String OBJETO_NAO_ENCONTRADO = "Objeto não encontrado";

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
    void whenFindByNomeThenReturnAnListOfLoja() {
        when(repository.findByNome(any())).thenReturn(optionalLoja);

        Loja response = service.findByNome(NOME_LOJA);

        assertNotNull(response);        
        assertEquals(Loja.class, response.getClass());      
        assertEquals(ID, response.getId());        
        assertEquals(NOME_LOJA, response.getNome());    
    }
    
    @Test
    void whenFindByIdThenReturnAnObjectNotFoundException() {    	
        when(repository.findByNome(anyString()))
                .thenThrow(new ObjectNotFoundException(OBJETO_NAO_ENCONTRADO));

        try{
            service.findByNome(NOME_LOJA);
        } catch (Exception ex) {
            assertEquals(ObjectNotFoundException.class, ex.getClass());
            assertEquals(OBJETO_NAO_ENCONTRADO, ex.getMessage());
        }
    }
    
    @Test
    void whenFindAllThenReturnList() {
    	when(repository.findAll()).thenReturn(List.of(loja));

        List<Loja> response = service.findAll();

        assertNotNull(response);
        assertEquals(1, response.size());
        assertEquals(ID, response.get(INDEX).getId());
        assertEquals(NOME_LOJA, response.get(INDEX).getNome());
    }
    
    @Test
    void whenFindByNomeOrCreateSuccess() {
    	when(repository.save(any())).thenReturn(loja);

        Loja response = service.findByNomeOrCreate(loja.getNome());

        assertNotNull(response);               
        assertEquals(Loja.class, response.getClass());        
        assertEquals(ID, response.getId());
        assertEquals(NOME_LOJA, response.getNome());
    }
    
    private void startLoja() {    	    	
    	loja = new Loja(ID, NOME_LOJA);
    	optionalLoja = Optional.of(new Loja(ID, NOME_LOJA));
    }
}
