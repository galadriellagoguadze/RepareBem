package teste;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import reparebem.Reparo;

public class ReparoTest {
	private Reparo r;
	
	@Test
	void ajudePrecoMenor() {
		Reparo r = new Reparo("camisa",  "rasgo",  10.00);
		r.ajustePreco(50);
		assertEquals(5, r.getPreco());
	}
	
	@Test
	void ajudePrecoMaior() {
		Reparo r = new Reparo("camisa",  "rasgo",  10.00);
		r.ajustePreco(150);
		assertEquals(15, r.getPreco());
	}
}
