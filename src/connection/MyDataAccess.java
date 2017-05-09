package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import datos.Ambiente;
import datos.Astronomia;
import datos.ClimaDia;
import datos.Condicion;
import datos.Consulta;
import datos.Ubicacion;
import datos.Viento;

public class MyDataAccess {

	private String usuario = "root";
	private String pass = "1234";
	private Connection con = null;
	private static String db = "clima";
	static String url = "jdbc:mysql://localhost/" + db;
	private PreparedStatement prInsertar;

	public MyDataAccess() {
		try {
			Class.forName("com.mysql.jdbc.Connection");
			con = (Connection) DriverManager.getConnection(url, usuario, pass);

			if (con != null)
				System.out.print("Conexion exitosa" + "\n");

		} catch (SQLException e) {
			System.out.print("Error");
		} catch (ClassNotFoundException e) {
			System.out.print(e);
		}
	}

	public ResultSet query(String query) {
		ResultSet rs = null;
		try {
			Statement s = con.createStatement();
			rs = s.executeQuery(query);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rs;
	}

	public void insertarClimaDia(ClimaDia cd) throws SQLException {
		prInsertar = con.prepareStatement(
				"INSERT INTO CLIMADIA (codigo,fecha,dia,minima,maxima,descripcion)" + "values(?,?,?,?,?,?)");
		prInsertar.setString(1, String.valueOf(cd.getCodigo()));
		SimpleDateFormat f = new SimpleDateFormat("yyyy-mm-dd");
		prInsertar.setString(2, f.format(cd.getFecha()));
		prInsertar.setString(3, cd.getDia());
		prInsertar.setString(4, String.valueOf(cd.getMin()));
		prInsertar.setString(5, String.valueOf(cd.getMax()));
		prInsertar.setString(6, cd.getDescripcion());
		prInsertar.executeUpdate();

	}

	public void insertarUbicacion(Ubicacion u) throws SQLException {
		prInsertar = con.prepareStatement("INSERT INTO UBICACION (ciudad,pais,region)" + "values(?,?,?)");
		prInsertar.setString(1, u.getCiudad());
		prInsertar.setString(2, u.getPais());
		prInsertar.setString(3, u.getRegion());
		prInsertar.executeUpdate();

	}

	public void insertarAmbiente(Ambiente am) throws SQLException {
		prInsertar = con
				.prepareStatement("INSERT INTO AMBIENTE (humedad,presion,indiceUV,visibilidad)" + "values(?,?,?,?)");
		prInsertar.setString(1, String.valueOf(am.getHumedad()));
		prInsertar.setString(2, String.valueOf(am.getPresion()));
		prInsertar.setString(3, String.valueOf(am.getHumedad()));
		prInsertar.setString(4, String.valueOf(am.getVisibilidad()));
		prInsertar.executeUpdate();

	}

	public void insertarAstronomia(Astronomia ast) throws SQLException {
		prInsertar = con.prepareStatement("INSERT INTO ASTRONOMIA (amanecer, atardecer)" + "values(?,?)");
		prInsertar.setString(1, ast.getAmanecer());
		prInsertar.setString(2, ast.getAtardecer());
		prInsertar.executeUpdate();

	}

	public void insertarViento(Viento v) throws SQLException {
		prInsertar = con.prepareStatement("INSERT INTO VIENTO (temperatura,velocidad,direccion)" + "values(?,?,?)");
		prInsertar.setString(1, String.valueOf(v.getTemperatura()));
		prInsertar.setString(2, String.valueOf(v.getVelocidad()));
		prInsertar.setString(3, String.valueOf(v.getDireccion()));
		prInsertar.executeUpdate();

	}

	public void insertarCondicion(Condicion c, Ubicacion u, Ambiente a, Astronomia ast, Viento v) throws SQLException {
		prInsertar = con.prepareStatement(
				"INSERT INTO CONDICION (codigo, temperatura, dia, descripcion, idUbicacion, idAmbiente, idAstronomia, idViento)"
						+ "values(?,?,?,?,(SELECT idUbicacion FROM ubicacion WHERE ciudad = ? LIMIT 1),"
						+ "(SELECT idAmbiente FROM ambiente WHERE humedad = ? and presion = ? and indiceuv = ? and visibilidad = ? LIMIT 1),"
						+ "(SELECT idAstronomia FROM astronomia WHERE amanecer = ? and atardecer = ? LIMIT 1),"
						+ "(SELECT idViento FROM viento WHERE temperatura= ? and velocidad =? and direccion = ? LIMIT 1))");
		prInsertar.setString(1, String.valueOf(c.getCodigo()));
		prInsertar.setString(2, String.valueOf(c.getTemperatura()));
		SimpleDateFormat f = new SimpleDateFormat("yyyy-mm-dd");
		prInsertar.setString(3, f.format(c.getDia()));
		prInsertar.setString(4, c.getDescripcion());
		prInsertar.setString(5, u.getCiudad());
		prInsertar.setString(6, String.valueOf(a.getHumedad()));
		prInsertar.setString(7, String.valueOf(a.getPresion()));
		prInsertar.setString(8, String.valueOf(a.getIndiceUv()));
		prInsertar.setString(9, String.valueOf(a.getVisibilidad()));
		prInsertar.setString(10, ast.getAmanecer());
		prInsertar.setString(11, ast.getAtardecer());
		prInsertar.setString(12, String.valueOf(v.getTemperatura()));
		prInsertar.setString(13, String.valueOf(v.getVelocidad()));
		prInsertar.setString(14, String.valueOf(v.getDireccion()));
		prInsertar.executeUpdate();

	}

	public void insertConsulta(Consulta c, Condicion cond) throws SQLException {
		prInsertar = con.prepareStatement("INSERT INTO CONSULTA (fechaConsulta,latitud,longitud,idCondicion)"
				+ "values(?,?,?,(Select idcondicion FROM Condicion where codigo = ? LIMIT 1))");
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		prInsertar.setString(1, f.format(c.getFechaConsulta()));
		prInsertar.setString(2, String.valueOf(c.getLatitud()));
		prInsertar.setString(3, String.valueOf(c.getLongitud()));
		prInsertar.setString(4, String.valueOf(cond.getCodigo()));
		prInsertar.executeUpdate();

	}

	public void insertarConsultaClimaDia(Consulta c) throws SQLException {
		ArrayList<ClimaDia> lista = c.getPronostico();
		for (ClimaDia cd : lista) {
			prInsertar = con.prepareStatement("INSERT INTO CLIMADIA_CONSULTA (idConsulta,idClimaDia)"
					+ "values((SELECT c.idconsulta FROM consulta c INNER JOIN condicion con ON c.idCondicion=con.idcondicion WHERE c.fechaconsulta = ? and con.codigo = ? LIMIT 1),?)");
			SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
			prInsertar.setString(1, f.format(c.getFechaConsulta()));
			prInsertar.setString(2, String.valueOf(c.getCondicion().getCodigo()));
			prInsertar.setString(3, String.valueOf(cd.getCodigo()));
			prInsertar.executeUpdate();

		}
	}

	public String mostrarConsulta() throws SQLException {
		String s = "";
		ResultSet rs = prInsertar.executeQuery("SELECT * FROM consulta");
		while (rs.next()) {
			s = "fecha=  " + rs.getObject("fechaConsulta") + "  |  latitud=  " + rs.getObject("latitud")
					+ "  |  longitud=  " + rs.getObject("longitud") + "\n";
		}
		return s;
	}

	public String mostrarConsulta(Consulta c) throws SQLException {
		String s = "";
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		ResultSet rs = prInsertar.executeQuery(
				"SELECT * FROM consulta WHERE fechaconsulta =" + f.format(c.getFechaConsulta()) + " and latitud="
						+ String.valueOf(c.getLatitud()) + "and longitud=" + String.valueOf(c.getLongitud()));
		while (rs.next()) {
			s = "fecha=  " + rs.getObject("fechaConsulta") + "  |  latitud=  " + rs.getObject("latitud")
					+ "  |  longitud=  " + rs.getObject("longitud") + "\n";

			s += mostrarCondicion(c.getCondicion().getCodigo());
		}
		return s;
	}

	public String mostrarCondicion() throws SQLException {
		String s = "";
		ResultSet rs = prInsertar.executeQuery("SELECT * FROM condicion");
		while (rs.next()) {
			s = "codigo=  " + rs.getObject("codigo") + "  |  temperatura=  " + rs.getObject("temperatura")
					+ "  |  fecha=  " + rs.getObject("dia") + "  |  descripcion=  " + rs.getObject("descripcion")
					+ "\n";
		}
		return s;
	}

	public String mostrarCondicion(int codigo) throws SQLException {
		String s = "";
		ResultSet rs = prInsertar.executeQuery("SELECT * FROM condicion WHERE codigo =" + codigo);
		while (rs.next()) {
			s = "codigo=  " + rs.getObject("codigo") + "  |  temperatura=  " + rs.getObject("temperatura")
					+ "  |  fecha=  " + rs.getObject("dia") + "  |  descripcion=  " + rs.getObject("descripcion")
					+ "\n";
		}
		return s;
	}

}
