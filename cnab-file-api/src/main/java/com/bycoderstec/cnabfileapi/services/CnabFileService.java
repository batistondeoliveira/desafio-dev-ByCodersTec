package com.bycoderstec.cnabfileapi.services;

import java.util.List;

import com.bycoderstec.cnabfileapi.domain.dto.CnabFileDTO;
import com.bycoderstec.cnabfileapi.domain.dto.LancamentoDTO;

public interface CnabFileService {

	public List<LancamentoDTO> processaCnabFile(CnabFileDTO dto);
}
