package com.bycoderstec.cnabfileapi;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CnabFileApiApplicationTest {

	@Test
	void main() {
		CnabFileApiApplication.main(new String[] {});
		assertTrue(true);
	}

}
