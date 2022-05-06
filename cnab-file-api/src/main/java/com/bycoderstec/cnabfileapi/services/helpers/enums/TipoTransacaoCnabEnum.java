package com.bycoderstec.cnabfileapi.services.helpers.enums;

public enum TipoTransacaoCnabEnum {

	DEBITO(1, "DÉBITO", 1),
	BOLETO(2, "BOLETO", -1),
	FINANCIAMENTO(3, "FINANCIAMENTO", -1),
	CREDITO(4, "CRÉDITO", 1),
	RECEBIMENTO_EMPRESTIMO(5, "RECEBIMENTO EMPRÉSTIMO", 1),
	VENDAS(6, "VENDAS", 1),
	RECEBIMENTO_TED(7, "RECEBIMENTO TED", 1),
	RECEBIMENTO_DOC(8, "RECEBIMENTO DOC", 1),
	ALUGUEL(9, "ALUGUEL", -1);
	
	private int cod;
	private String descricao;
	private int multiplicador;
	
	private TipoTransacaoCnabEnum(int cod, String descricao, int multiplicador) {
		this.cod = cod;
		this.descricao = descricao;
		this.multiplicador = multiplicador;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
		
	public int getMultiplicador() {
		return multiplicador;
	}

	public static TipoTransacaoCnabEnum toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		
		for (TipoTransacaoCnabEnum x: TipoTransacaoCnabEnum.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
}
