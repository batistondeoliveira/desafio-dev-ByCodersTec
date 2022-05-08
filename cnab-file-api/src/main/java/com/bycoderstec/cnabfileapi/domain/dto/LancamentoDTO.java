package com.bycoderstec.cnabfileapi.domain.dto;

import java.time.LocalDate;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.bycoderstec.cnabfileapi.services.impl.helpers.enums.TipoTransacaoCnabEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
public class LancamentoDTO {

	private Integer id;
	
	@NotNull(message="Preenchimento obrigatório")
	@Min(value=1)
	@Max(value=9)
	private Integer tipoTransacao;
	
	@NotNull(message="Preenchimento obrigatório")
	private LocalDate data;
	
	@NotNull(message="Preenchimento obrigatório")
	private Double valor;
	
	@NotNull(message="Preenchimento obrigatório")
	private String cpf;
	
	@NotNull(message="Preenchimento obrigatório")
	private String cartao;
	
	@NotNull(message="Preenchimento obrigatório")
	private String hora;
	
	@NotNull(message="Preenchimento obrigatório")	
	private String representanteLoja;
	
	@NotNull(message="Preenchimento obrigatório")	
	private String nomeLoja;
	
	public TipoTransacaoCnabEnum getTipoTransacao() {
		return TipoTransacaoCnabEnum.toEnum(tipoTransacao);
	}

	public void setTipoTransacao(TipoTransacaoCnabEnum tipoTransacao) {
		this.tipoTransacao = tipoTransacao.getCod();
	}
}
