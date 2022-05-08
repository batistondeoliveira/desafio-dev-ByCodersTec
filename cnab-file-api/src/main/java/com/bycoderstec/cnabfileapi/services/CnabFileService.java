package com.bycoderstec.cnabfileapi.services;

import java.util.List;

import com.bycoderstec.cnabfileapi.domain.Lancamento;
import com.bycoderstec.cnabfileapi.dto.CnabFileDTO;

public interface CnabFileService {

	public List<Lancamento> processaCnabFile(CnabFileDTO dto);
}
