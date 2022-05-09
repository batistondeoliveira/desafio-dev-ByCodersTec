package com.bycoderstec.cnabfileapi.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.bycoderstec.cnabfileapi.services.impl.helpers.enums.TipoTransacaoCnabEnum;

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
	
	@NotNull
	@Column(name = "tipo_transacao")
	private Integer tipoTransacao;
	
	@NotNull
	private LocalDate data;
	
	@NotNull
	private Double valor;
	
	@NotNull
	private String cpf;
	
	@NotNull
	private String cartao;
	
	@NotNull
	private String hora;
	
	@NotNull
	@ManyToOne(optional = false)
	@JoinColumn(name="representante_loja")
	private Representante representante;
	
	@NotNull	
	@ManyToOne(optional = false)
	@JoinColumn(name="nome_loja")
	private Loja loja;
		
	public TipoTransacaoCnabEnum getTipoTransacao() {
		return TipoTransacaoCnabEnum.toEnum(tipoTransacao);
	}

	public void setTipoTransacao(TipoTransacaoCnabEnum tipoTransacao) {
		this.tipoTransacao = tipoTransacao.getCod();
	}
}
