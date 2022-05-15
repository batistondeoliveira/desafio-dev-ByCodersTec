package com.bycoderstec.cnabfileapi.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.bycoderstec.cnabfileapi.domain.dto.LancamentoDTO;

public interface CnabFileService {

	public List<LancamentoDTO> processaCnabFile(MultipartFile file);
}
