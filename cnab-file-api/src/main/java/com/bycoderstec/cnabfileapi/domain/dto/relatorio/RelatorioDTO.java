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

	private List<LojaRelatorioDTO> loja;	
	private Double saldoEmConta;
	
	public RelatorioDTO(List<LojaRelatorioDTO> loja) {	
		this.setLoja(loja);		
	}	
	
	public void setLoja(List<LojaRelatorioDTO> loja) {
		this.loja = loja;
		
		if (loja != null) {
			this.saldoEmConta = loja.stream().mapToDouble(LojaRelatorioDTO::getSaldoPorLoja).sum();
		}
	}
}
