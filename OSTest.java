package teste;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import reparebem.OS;

public class OSTest {
	private OS o;
	
	@Test
	void mudarStatus() {
		o = new OS("galadriella", "123", "camisa");
		assertEquals("Não iniciada", o.getStatus());
		o.mudarStatus("Concluída");
		assertEquals("Concluída", o.getStatus());
		o.mudarStatus("Em andamento");
		assertEquals("Em andamento", o.getStatus());
	}
}
