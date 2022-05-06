package com.bycoderstec.cnabfileapi.services.helpers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.bycoderstec.cnabfileapi.domain.Lancamento;
import com.bycoderstec.cnabfileapi.services.helpers.enums.TipoTransacaoCnabEnum;

public class LayoutCNAB {
	private static String linha;
	
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
	
	public static Lancamento convertToLancamento(String linha) {
		LayoutCNAB.linha = linha;
		
		Lancamento lancamento = new Lancamento();
		
		lancamento.setTipo(LayoutCNAB.getTipo());
		lancamento.setData(LayoutCNAB.getData());
		lancamento.setValor(LayoutCNAB.getValor());
		lancamento.setCpf(LayoutCNAB.getCpf());
		lancamento.setCartao(LayoutCNAB.getCartao());
		lancamento.setHora(LayoutCNAB.getHora());
		lancamento.setRepresentanteLoja(LayoutCNAB.getRepresentanteLoja());
		lancamento.setNomeLoja(LayoutCNAB.getNomeLoja());
		
		return lancamento;		
	}
}
