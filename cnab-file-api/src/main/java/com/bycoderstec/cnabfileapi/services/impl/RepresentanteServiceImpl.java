package com.bycoderstec.cnabfileapi.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bycoderstec.cnabfileapi.domain.Loja;
import com.bycoderstec.cnabfileapi.domain.Representante;
import com.bycoderstec.cnabfileapi.repositories.RepresentanteRepository;
import com.bycoderstec.cnabfileapi.services.RepresentanteService;
import com.bycoderstec.cnabfileapi.services.impl.exceptions.ObjectNotFoundException;

@Service
public class RepresentanteServiceImpl implements RepresentanteService {
	
	@Autowired
	private RepresentanteRepository repository;
	
	@Override
	public Representante create(Representante obj) {
		return repository.save(obj);
	}

	@Override
	public Representante findByNomeAndLoja(String nome, Loja loja) {
		Optional<Representante> obj = repository.findByNomeAndLoja(nome, loja); 
				
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	@Override
	public Representante findByNomeAndLojaOrCreate(String nome, Loja loja) {
		Representante representante = null;
		
		try {
			representante = findByNomeAndLoja(nome, loja);
		} catch(ObjectNotFoundException ex) {			
			representante = create(new Representante(null, nome, loja));
		}
		
		return representante;
	}
}
