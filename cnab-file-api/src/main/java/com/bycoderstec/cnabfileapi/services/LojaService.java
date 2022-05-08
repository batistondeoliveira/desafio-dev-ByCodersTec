package com.bycoderstec.cnabfileapi.services;

import com.bycoderstec.cnabfileapi.domain.Loja;

public interface LojaService {
	
	public Loja create(Loja obj);
	public Loja findByNome(String nome);
}
