package com.bycoderstec.cnabfileapi.domain.enums;

public enum StatusCnabFile {
	
	PENDING(1, "PENDENTE"),
	PROCESSED(2, "PROCESSADO"),
	ERROR(9, "ERROR");
	
	private int cod;
	private String descricao;
	
	private StatusCnabFile(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static StatusCnabFile toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		
		for (StatusCnabFile x: StatusCnabFile.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
}
