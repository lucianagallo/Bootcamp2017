package test.java;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.java.entity.ClimaDia;

public class ClimaDiaTest {

	@Test
	public void getDiaTest(){
		ClimaDia dia = new ClimaDia(1, null, "Jue", 38, 27, "Parcialmente nublado");
		String d = dia.getDia();
		assertEquals("Jue",d);
	}
}
