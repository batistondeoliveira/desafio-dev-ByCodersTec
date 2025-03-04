package com.bycoderstec.cnabfileapi.services.impl.helpers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.bycoderstec.cnabfileapi.domain.dto.LancamentoDTO;
import com.bycoderstec.cnabfileapi.services.impl.helpers.enums.TipoTransacaoCnabEnum;

public final class LayoutCNAB {
	private static String linha;
	
	private LayoutCNAB() {
		throw new UnsupportedOperationException("Essa classe não pode ser instanciada");
	}
	
	private static Integer getTipo() {		
		return Integer.parseInt(LayoutCNAB.linha.substring(0, 1));
	}
	
	private static LocalDate getData() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");	
		String pattern = "(\\d{4})(\\d{2})(\\d{2})";		
		String data = LayoutCNAB.linha.substring(1, 9);
		data = data.replaceAll(pattern, "$3/$2/$1");
		
		return LocalDate.parse(data, formatter);
	}
	
	private static Double getValor() {				
		String valorStr = LayoutCNAB.linha.substring(9, 19);
		Double valor = Double.parseDouble(valorStr);		
		
		return TipoTransacaoCnabEnum.toEnum(LayoutCNAB.getTipo())
				.getMultiplicador() * (valor / 100);
	}
	
	private static String getCpf() {
		return LayoutCNAB.linha.substring(19, 30);
	}
	
	private static String getCartao() {
		return LayoutCNAB.linha.substring(30, 42);
	}
	
	private static String getHora() {
		String pattern = "(\\d{2})(\\d{2})(\\d{2})";		
		String hora = LayoutCNAB.linha.substring(42, 48);		
		
		return hora.replaceAll(pattern, "$1:$2:$3");
	}
	
	private static String getRepresentanteLoja() {
		return LayoutCNAB.linha.substring(48, 62).trim();
	}
	
	private static String getNomeLoja() {
		return LayoutCNAB.linha.substring(62, 80).trim();
	}
	
	public static LancamentoDTO convertToLancamento(String linha) {
		LayoutCNAB.linha = linha;
		
		LancamentoDTO dto = new LancamentoDTO();
		
		dto.setTipoTransacao(TipoTransacaoCnabEnum.toEnum(LayoutCNAB.getTipo()));
		dto.setData(LayoutCNAB.getData());
		dto.setValor(LayoutCNAB.getValor());
		dto.setCpf(LayoutCNAB.getCpf());
		dto.setCartao(LayoutCNAB.getCartao());
		dto.setHora(LayoutCNAB.getHora());
		dto.setRepresentanteLoja(LayoutCNAB.getRepresentanteLoja());
		dto.setNomeLoja(LayoutCNAB.getNomeLoja());
		
		return dto;		
	}
}
