package main.java.datos;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import main.java.connection.MyDataAccess;

public class Main {

	public static void main(String[] args) throws ParseException, SQLException {

		MyDataAccess conexion = MyDataAccess.getInstance();
		
		// Ubicacion
		Ubicacion ubicacion = new Ubicacion("Nome", "United States", " AK");
		// Viento
		Viento viento = new Viento(37, 158, 4);
		// Ambiente
		Ambiente ambiente = new Ambiente(79, 1006.0, 0, 16.0);
		// Astronomia
		Astronomia astronomia = new Astronomia("6:45 am", "11:15 pm");

		double latitud = 64.499474;
		double longitud = -165.405792;

		ArrayList<ClimaDia> pronostico = new ArrayList<ClimaDia>();

		// Clima dia
		SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-mm-yyyy");
		String strFecha2 = "27-04-2017";
		Date fecha2 = formatoDelTexto.parse(strFecha2);

		ClimaDia dia1 = new ClimaDia(81, fecha2, "Jue", 38, 27, "Parcialmente nublado");
		String strFecha3 = "28-04-2017";
		Date fecha3 = formatoDelTexto.parse(strFecha3);
		ClimaDia dia2 = new ClimaDia(82, fecha3, "Vie", 37, 30, "Nublado");

		pronostico.add(dia1);
		pronostico.add(dia2);

		// Condicion
		String strFecha4 = "26-04-2017";
		Date fecha4 = formatoDelTexto.parse(strFecha4);

		Condicion condicion = new Condicion(30, 28, "Nublado", fecha4, ubicacion, viento, ambiente, astronomia);
		// Consulta
		Date fechaConsulta = new Date();

		Consulta consulta = new Consulta(fechaConsulta, pronostico, condicion, latitud, longitud);
		
		//INSERT
		conexion.insertarClimaDia(dia1);
		conexion.insertarClimaDia(dia2);
		conexion.insertarAmbiente(ambiente);
		conexion.insertarAstronomia(astronomia);
		conexion.insertarUbicacion(ubicacion);
		conexion.insertarViento(viento);
		conexion.insertarCondicion(condicion, ubicacion, ambiente, astronomia, viento);
		conexion.insertConsulta(consulta, condicion);
		conexion.insertarConsultaClimaDia(consulta);
		
		//SELECT
		System.out.print(conexion.mostrarConsulta());
		System.out.print(conexion.mostrarCondicion());
	}

}
