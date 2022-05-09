package com.bycoderstec.cnabfileapi.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bycoderstec.cnabfileapi.domain.Loja;
import com.bycoderstec.cnabfileapi.repositories.LojaRepository;
import com.bycoderstec.cnabfileapi.services.LojaService;
import com.bycoderstec.cnabfileapi.services.impl.exceptions.ObjectNotFoundException;

@Service
public class LojaServiceImpl implements LojaService {
	
	@Autowired
	private LojaRepository repository;
	
	@Override
	public Loja create(Loja obj) {
		return repository.save(obj);
	}

	@Override
	public Loja findByNome(String nome) {
		Optional<Loja> obj = repository.findByNome(nome); 
		
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));        	
	}

	@Override
	public Loja findByNomeOrCreate(String nome) {
		Loja loja = null;
		
		try {
		    loja = findByNome(nome);
		} catch(ObjectNotFoundException ex) {			
			loja = create(new Loja(null, nome));
		}
		
		return loja;
	}
	
	@Override
	public List<Loja> findAll() {
		return repository.findAll();
	}
}
