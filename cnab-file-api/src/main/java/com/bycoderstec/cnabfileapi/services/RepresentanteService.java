package com.bycoderstec.cnabfileapi.services;

import com.bycoderstec.cnabfileapi.domain.Loja;
import com.bycoderstec.cnabfileapi.domain.Representante;

public interface RepresentanteService {
	
	public Representante create(Representante obj);
	public Representante findByNomeAndLoja(String nome, Loja loja);
	public Representante findByNomeAndLojaOrCreate(String nome, Loja loja);
}
