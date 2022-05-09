package com.bycoderstec.cnabfileapi.services;

import java.util.List;

import com.bycoderstec.cnabfileapi.domain.Loja;

public interface LojaService {
	
	public Loja create(Loja obj);
	public Loja findByNome(String nome);
	public Loja findByNomeOrCreate(String nome);
	public List<Loja> findAll();
}
