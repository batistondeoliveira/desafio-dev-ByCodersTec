package com.bycoderstec.cnabfileapi.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "lancamento")
public class Lancamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Integer tipo;
	
	private LocalDate data;
	
	private Double valor;
	
	private String cpf;
	
	private String cartao;
	
	private String hora;
	
	@Column(name = "representante_loja")
	private String representanteLoja;
	
	@Column(name = "nome_loja")
	private String nomeLoja;
}
