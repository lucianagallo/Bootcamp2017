package main.java.entity;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import dao.ClimaDAO;
import main.java.connection.MyDataAccess;

@Component
public class Main {

	public static void main(String[] args) throws ParseException, SQLException {
		String confFile = "ApplicationContext.xml";
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(confFile);

		MyDataAccess conexion = (MyDataAccess) context.getBean("mda");

		conexion.createTables();
		int i = 1;
		// Ubicacion
		Ubicacion ubicacion = new UbicacionBuilder().withCiudad("Nome").withPais("United States").withRegion(" AK")
				.withId(i).build();
		// Viento
		Viento viento = new VientoBuilder().withTemperatura(37).withDireccion(4).withVelociodad(158).withId(i).build();
		// Ambiente
		Ambiente ambiente = new AmbienteBuilder().withHumedad(79).withIndiceUv(0).withPresion(1006.0)
				.withVisibilidad(16.0).withId(i).build();
		// Astronomia
		Astronomia astronomia = new AstronomiaBuilder().withAmanecer("6:45 am").withAtardecer("11:15 pm").withId(i)
				.build();

		double latitud = 64.499474;
		double longitud = -165.405792;

		ArrayList<ClimaDia> pronostico = new ArrayList<ClimaDia>();

		// Clima dia
		SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-mm-yyyy");
		String strFecha1 = "27-04-2017";
		Date fecha1 = formatoDelTexto.parse(strFecha1);
		int cod = 1;
		ClimaDia dia1 = new ClimaDiaBuilder().withCodigo(cod).withFecha(fecha1).withDia("Jue").withMax(38).withMin(27)
				.withDescripcion("Parcialmente nublado").build();
		String strFecha2 = "28-04-2017";
		Date fecha2 = formatoDelTexto.parse(strFecha2);
		cod++;
		ClimaDia dia2 = new ClimaDiaBuilder().withCodigo(cod).withFecha(fecha2).withDia("Vie").withMax(37).withMin(26)
				.withDescripcion("Nublado").withId(i).build();
		cod++;

		pronostico.add(dia1);
		pronostico.add(dia2);

		// Condicion
		String strFecha3 = "26-04-2017";
		Date fecha3 = formatoDelTexto.parse(strFecha3);
		Condicion condicion = new CondicionBuilder().withCodigo(30).withTemperatura(28).withDescripcion("Nublado")
				.withDia(fecha3).withUbicacion(ubicacion).withViento(viento).withAmbiente(ambiente)
				.withAstronimia(astronomia).withId(i).build();
		// Consulta
		Date fechaConsulta = new Date();
		Consulta consulta = new ConsultaBuilder().withFechaConsulta(fechaConsulta).withPronostico(pronostico)
				.withCondicion(condicion).withLatitud(latitud).withLongitud(longitud).withId(i).build();

		ClimaDAO dao = (ClimaDAO) context.getBean("climadiadao");
		dao.insert(dia1);
		dao.insert(dia2);
		dao = (ClimaDAO) context.getBean("ambientedao");
		dao.insert(ambiente);
		dao = (ClimaDAO) context.getBean("astronomiadao");
		dao.insert(astronomia);
		dao = (ClimaDAO) context.getBean("ubicaciondao");
		dao.insert(ubicacion);
		dao = (ClimaDAO) context.getBean("vientodao");
		dao.insert(viento);
		// viento.setTemperatura(12);
		// System.out.print(conexion.mostrarViento());
		// dao.update(viento);
		dao = (ClimaDAO) context.getBean("condiciondao");
		;
		dao.insert(condicion);
		dao = (ClimaDAO) context.getBean("consultadao");
		dao.insert(consulta);

		conexion.insertarConsultaClimaDia(consulta);

		System.out.print(conexion.mostrarConsulta());
		System.out.print(conexion.mostrarCondicion());

	}

}
