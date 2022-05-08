package com.bycoderstec.cnabfileapi.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bycoderstec.cnabfileapi.services.helpers.enums.TipoTransacaoCnabEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "lancamento")
public class Lancamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Integer tipoTransacao;
	
	private LocalDate data;
	
	private Double valor;
	
	private String cpf;
	
	private String cartao;
	
	private String hora;
	
	@Column(name = "representante_loja")
	private String representanteLoja;
	
	@Column(name = "nome_loja")
	private String nomeLoja;
	
	public TipoTransacaoCnabEnum getTipoTransacao() {
		return TipoTransacaoCnabEnum.toEnum(tipoTransacao);
	}

	public void setTipoTransacao(TipoTransacaoCnabEnum tipoTransacao) {
		this.tipoTransacao = tipoTransacao.getCod();
	}
}
