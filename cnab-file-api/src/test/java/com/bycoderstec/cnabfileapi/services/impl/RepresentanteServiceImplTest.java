package com.bycoderstec.cnabfileapi.services.impl;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.bycoderstec.cnabfileapi.domain.Loja;
import com.bycoderstec.cnabfileapi.domain.Representante;
import com.bycoderstec.cnabfileapi.repositories.RepresentanteRepository;
import com.bycoderstec.cnabfileapi.services.impl.exceptions.ObjectNotFoundException;

@SpringBootTest
class RepresentanteServiceImplTest {

	private static final int ID = 1;
	
	private static final String REPRESENTANTE_LOJA = "Coders";
	
	private static final int ID_LOJA = 1;
	
	private static final String NOME_LOJA = "ByCodersTec";
	
	private static final String OBJETO_NAO_ENCONTRADO = "Objeto não encontrado";	

	@InjectMocks
    private RepresentanteServiceImpl service;

    @Mock
    private RepresentanteRepository repository;

    private Loja loja;
    
    private Representante representante;
    
    private Optional<Representante> optionalRepresentante;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startRepresentante();
    }
          
    @Test
    void whenCreateThenReturnSuccess() {    	
        when(repository.save(any())).thenReturn(representante);

        Representante response = service.create(representante);

        assertNotNull(response);               
        assertEquals(Representante.class, response.getClass());        
        assertEquals(ID, response.getId());
        assertEquals(REPRESENTANTE_LOJA, response.getNome());            	   
    }
    
    @Test
    void whenFindByNomeThenReturnAnListOfR() {
        when(repository.findByNomeAndLoja(anyString(), any())).thenReturn(optionalRepresentante);

        Representante response = service.findByNomeAndLoja(representante.getNome(), representante.getLoja());

        assertNotNull(response);        
        assertEquals(Representante.class, response.getClass());      
        assertEquals(ID, response.getId());        
        assertEquals(REPRESENTANTE_LOJA, response.getNome());
        assertEquals(loja, response.getLoja());  
    }
    
    @Test
    void whenFindByIdThenReturnAnObjectNotFoundException() {    	
        when(repository.findByNomeAndLoja(anyString(), any()))
                .thenThrow(new ObjectNotFoundException(OBJETO_NAO_ENCONTRADO));

        try{
            service.findByNomeAndLoja(NOME_LOJA, loja);
        } catch (Exception ex) {
            assertEquals(ObjectNotFoundException.class, ex.getClass());
            assertEquals(OBJETO_NAO_ENCONTRADO, ex.getMessage());
        }
    }    
    
    private void startRepresentante() {    	    	
    	loja = new Loja(ID_LOJA, NOME_LOJA);
    	
    	representante = new Representante(ID, REPRESENTANTE_LOJA, loja);        
    	optionalRepresentante = Optional.of(new Representante(ID, REPRESENTANTE_LOJA, loja));
    }
}
