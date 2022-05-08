package com.bycoderstec.cnabfileapi.services.impl.helpers.enums;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TipoTransacaoCnabEnumTest {

	private static final int NEGATIVO = -1;
	private static final int POSITIVO = 1;

	@Test
	public void whenTipoTransacaoIsDebitoThenReturnMultiplicadorPositivo() {
		Assertions.assertEquals(POSITIVO, TipoTransacaoCnabEnum.DEBITO.getMultiplicador());
	}
	
	@Test
	public void whenTipoTransacaoIsBoletoThenReturnMultiplicadorNegativo() {
		Assertions.assertEquals(NEGATIVO, TipoTransacaoCnabEnum.BOLETO.getMultiplicador());
	}
	
	@Test
	public void whenTipoTransacaoIsFinanceiroThenReturnMultiplicadorNegativo() {
		Assertions.assertEquals(NEGATIVO, TipoTransacaoCnabEnum.FINANCIAMENTO.getMultiplicador());
	}
	
	@Test
	public void whenTipoTransacaoIsCreditoThenReturnMultiplicadorPositivo() {
		Assertions.assertEquals(POSITIVO, TipoTransacaoCnabEnum.CREDITO.getMultiplicador());
	}
	
	@Test
	public void whenTipoTransacaoIsVendasThenReturnMultiplicadorPositivo() {
		Assertions.assertEquals(POSITIVO, TipoTransacaoCnabEnum.VENDAS.getMultiplicador());
	}
	
	@Test
	public void whenTipoTransacaoIsRecebimentoTEDThenReturnMultiplicadorPositivo() {
		Assertions.assertEquals(POSITIVO, TipoTransacaoCnabEnum.RECEBIMENTO_TED.getMultiplicador());
	}
	
	@Test
	public void whenTipoTransacaoIsRecebimentoDOCThenReturnMultiplicadorPositivo() {
		Assertions.assertEquals(POSITIVO, TipoTransacaoCnabEnum.RECEBIMENTO_DOC.getMultiplicador());
	}
	
	@Test
	public void whenTipoTransacaoIsAluguelThenReturnMultiplicadorNegativo() {
		Assertions.assertEquals(NEGATIVO, TipoTransacaoCnabEnum.ALUGUEL.getMultiplicador());
	}	
}
