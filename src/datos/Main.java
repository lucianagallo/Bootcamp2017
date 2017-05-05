package datos;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import connection.MyDataAccess;

public class Main {

	public static void main(String[] args) throws ParseException, SQLException {

		Date fechaConsulta = new Date();
		int tempActual = 36;
		String descripcion = "Nublado";
		MyDataAccess conexion = new MyDataAccess();

		Ubicacion ubicacion = new Ubicacion("Nome", "United States", " AK");
		Viento viento = new Viento(37, 158, 4);
		Ambiente ambiente = new Ambiente(79, 1006.0, 0, 16.0);
		Astronomia astronomia = new Astronomia("6:45 am", "11:15 pm");

		double latitud = 64.499474;
		double longitud = -165.405792;

		ArrayList<ClimaDia> pronostico = new ArrayList<ClimaDia>();

		SimpleDateFormat formatoDelTexto2 = new SimpleDateFormat("dd-mm-yyyy");
		String strFecha2 = "27-04-2017";
		Date fecha2 = formatoDelTexto2.parse(strFecha2);

		ClimaDia dia1 = new ClimaDia(34, fecha2, 38, "Jue", 38, 27, "Parcialmente nublado");

		String strFecha3 = "28-04-2017";
		Date fecha3 = formatoDelTexto2.parse(strFecha3);

		ClimaDia dia2 = new ClimaDia(28, fecha3, 37, "Vie", 38, 30, "Nublado");

		conexion.insertarClimaDia(dia1);
		conexion.insertarClimaDia(dia2);

		pronostico.add(dia1);
		pronostico.add(dia2);

		// Consulta consulta = new Consulta(fechaConsulta, pronostico,
		// ubicacion, viento, ambiente, astronomia, latitud,
		// longitud, tempActual, descripcion);

	}

}
