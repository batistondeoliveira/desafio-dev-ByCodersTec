package com.bycoderstec.cnabfileapi.services.impl.helpers.enums;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TipoTransacaoCnabEnumTest {

	private static final int NEGATIVO = -1;
	private static final int POSITIVO = 1;

	@Test
	void whenTipoTransacaoIsDebitoThenReturnMultiplicadorPositivo() {
		Assertions.assertEquals(POSITIVO, TipoTransacaoCnabEnum.DEBITO.getMultiplicador());
	}
	
	@Test
	void whenTipoTransacaoIsBoletoThenReturnMultiplicadorNegativo() {
		Assertions.assertEquals(NEGATIVO, TipoTransacaoCnabEnum.BOLETO.getMultiplicador());
	}
	
	@Test
	void whenTipoTransacaoIsFinanceiroThenReturnMultiplicadorNegativo() {
		Assertions.assertEquals(NEGATIVO, TipoTransacaoCnabEnum.FINANCIAMENTO.getMultiplicador());
	}
	
	@Test
	void whenTipoTransacaoIsCreditoThenReturnMultiplicadorPositivo() {
		Assertions.assertEquals(POSITIVO, TipoTransacaoCnabEnum.CREDITO.getMultiplicador());
	}
	
	@Test
	void whenTipoTransacaoIsVendasThenReturnMultiplicadorPositivo() {
		Assertions.assertEquals(POSITIVO, TipoTransacaoCnabEnum.VENDAS.getMultiplicador());
	}
	
	@Test
	void whenTipoTransacaoIsRecebimentoTEDThenReturnMultiplicadorPositivo() {
		Assertions.assertEquals(POSITIVO, TipoTransacaoCnabEnum.RECEBIMENTO_TED.getMultiplicador());
	}
	
	@Test
	void whenTipoTransacaoIsRecebimentoDOCThenReturnMultiplicadorPositivo() {
		Assertions.assertEquals(POSITIVO, TipoTransacaoCnabEnum.RECEBIMENTO_DOC.getMultiplicador());
	}
	
	@Test
	void whenTipoTransacaoIsAluguelThenReturnMultiplicadorNegativo() {
		Assertions.assertEquals(NEGATIVO, TipoTransacaoCnabEnum.ALUGUEL.getMultiplicador());
	}	
}
