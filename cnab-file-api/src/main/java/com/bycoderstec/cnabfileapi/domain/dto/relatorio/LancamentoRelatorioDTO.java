package com.bycoderstec.cnabfileapi.domain.dto.relatorio;

import java.time.LocalDate;

import com.bycoderstec.cnabfileapi.services.impl.helpers.enums.TipoTransacaoCnabEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
public class LancamentoRelatorioDTO {

	private Integer id;	
	private Integer tipoTransacao;
	private LocalDate data;	
	private Double valor;	
	private String cpf;	
	private String cartao;	
	private String hora;
	private String representanteLoja;	
	
	public String getTipoTransacao() {
		return TipoTransacaoCnabEnum.toEnum(tipoTransacao).getDescricao();
	}

	public void setTipoTransacao(TipoTransacaoCnabEnum tipoTransacao) {
		this.tipoTransacao = tipoTransacao.getCod();
	}
}
