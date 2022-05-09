package com.bycoderstec.cnabfileapi.domain.dto.relatorio;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
public class RelatorioDTO {

	List<LojaRelatorioDTO> loja;
}
