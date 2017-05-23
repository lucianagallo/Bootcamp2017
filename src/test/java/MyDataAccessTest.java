package test.java;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.java.connection.MyDataAccess;

public class MyDataAccessTest {

	private MyDataAccess conexion;

	@Before
	public void setUp() {
		conexion = new MyDataAccess();
	}

	@Test
	public void getInstanceTest() {
		assertNotNull(conexion);
	}
}
