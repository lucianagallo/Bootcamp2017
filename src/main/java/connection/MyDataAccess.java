package main.java.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import main.java.entity.ClimaDia;
import main.java.entity.Consulta;

public class MyDataAccess {
	private String usuario = "";
	private String pass = "";
	private Connection con = null;
	private String server = "org.h2.Driver";
	static String url = "jdbc:h2:mem:clima;DB_CLOSE_DELAY=-1";
	private PreparedStatement prInsertar;

	public MyDataAccess() {
		try {
			Class.forName(server);
			con = DriverManager.getConnection(url, usuario, pass);
			if (con != null)
				System.out.print("Conexion exitosa" + "\n");

		} catch (SQLException e) {
			System.out.print("Error");
		} catch (ClassNotFoundException e) {
			System.out.print(e);
		}
	}

	public Connection getConnection() {
		return con;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
	}

	public static String getUrl() {
		return url;
	}

	public static void setUrl(String url) {
		MyDataAccess.url = url;
	}

	public void createTables() throws SQLException {
		String createAmbiente = "CREATE TABLE ambiente(" + "idambiente int(11) NOT NULL,"
				+ "humedad int(11) DEFAULT NULL," + "presion double DEFAULT NULL," + "indiceUV int(11) DEFAULT NULL,"
				+ "visibilidad double DEFAULT NULL," + "PRIMARY KEY (idambiente))";
		PreparedStatement cps = con.prepareStatement(createAmbiente);
		cps.executeUpdate();
		cps.close();

		String createAstronomia = "CREATE TABLE astronomia(idastronomia integer NOT NULL,"
				+ "amanecer text,atardecer text, PRIMARY KEY(idastronomia))";
		cps = con.prepareStatement(createAstronomia);
		cps.executeUpdate();
		cps.close();

		String createClimaDia = "CREATE TABLE climadia (idClimaDia int(11) NOT NULL, codigo int(11) NOT NULL,fecha date DEFAULT NULL,"
				+ "dia tinytext, minima int(11) DEFAULT NULL, maxima int(11) DEFAULT NULL, descripcion tinytext, PRIMARY KEY (idClimaDia));";
		cps = con.prepareStatement(createClimaDia);
		cps.executeUpdate();
		cps.close();

		String createUbicacion = "CREATE TABLE ubicacion (" + "idUbicacion int(11) NOT NULL,"
				+ "ciudad tinytext NOT NULL," + "pais tinytext," + "region tinytext," + "PRIMARY KEY (idUbicacion));";
		cps = con.prepareStatement(createUbicacion);
		cps.executeUpdate();
		cps.close();

		String createViento = "CREATE TABLE viento (" + "idviento int(11) NOT NULL,"
				+ "temperatura int(11) DEFAULT NULL," + "velocidad int(11) DEFAULT NULL,"
				+ "direccion int(11) DEFAULT NULL," + "PRIMARY KEY (idviento));";
		cps = con.prepareStatement(createViento);
		cps.executeUpdate();
		cps.close();

		String createCondicion = "CREATE TABLE condicion (" + "idcondicion int(11) NOT NULL,"
				+ "codigo int(11) DEFAULT NULL," + "temperatura int(11) DEFAULT NULL," + "dia date DEFAULT NULL,"
				+ "descripcion text," + "idUbicacion int(11) DEFAULT NULL," + "idAmbiente int(11) DEFAULT NULL,"
				+ "idAstronomia int(11) DEFAULT NULL," + "idViento int(11) DEFAULT NULL," + "PRIMARY KEY (idcondicion),"
				+ "CONSTRAINT ambiente FOREIGN KEY (idAmbiente) REFERENCES ambiente (idambiente) ON DELETE NO ACTION ON UPDATE NO ACTION,"
				+ "CONSTRAINT astronomia FOREIGN KEY (idAstronomia) REFERENCES astronomia (idastronomia) ON DELETE NO ACTION ON UPDATE NO ACTION,"
				+ "CONSTRAINT viento FOREIGN KEY (idViento) REFERENCES viento (idviento) ON DELETE NO ACTION ON UPDATE NO ACTION);";
		cps = con.prepareStatement(createCondicion);
		cps.executeUpdate();
		cps.close();

		String createConsulta = "CREATE TABLE consulta (" + "idconsulta int(11) NOT NULL,"
				+ "fechaConsulta date DEFAULT NULL," + "latitud double DEFAULT NULL," + "longitud double DEFAULT NULL,"
				+ "idCondicion int(11) DEFAULT NULL," + "PRIMARY KEY (idconsulta),"
				+ "CONSTRAINT condicion FOREIGN KEY (idCondicion) REFERENCES condicion (idcondicion) ON DELETE NO ACTION ON UPDATE NO ACTION);";
		cps = con.prepareStatement(createConsulta);
		cps.executeUpdate();
		cps.close();

		String createClimaDiaConsulta = "CREATE TABLE climadia_consulta (" + "idConsulta int(11) NOT NULL,"
				+ "idClimaDia int(11) NOT NULL," + "PRIMARY KEY (idConsulta,idClimaDia),"
				+ "CONSTRAINT climaDia FOREIGN KEY (idClimaDia) REFERENCES climadia (idClimaDia) ON DELETE NO ACTION ON UPDATE NO ACTION,"
				+ "CONSTRAINT consulta FOREIGN KEY (idConsulta) REFERENCES consulta (idconsulta) ON DELETE NO ACTION ON UPDATE NO ACTION);";
		cps = con.prepareStatement(createClimaDiaConsulta);
		cps.executeUpdate();
		cps.close();

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

	public void insertarConsultaClimaDia(Consulta c) throws SQLException {
		ArrayList<ClimaDia> lista = c.getPronostico();
		for (ClimaDia cd : lista) {
			prInsertar = con.prepareStatement("INSERT INTO CLIMADIA_CONSULTA (idConsulta,idClimaDia)" + "values(?,?)");
			prInsertar.setInt(1, c.getId());
			prInsertar.setInt(2, cd.getId());
			prInsertar.executeUpdate();

		}
	}

	public String mostrarConsulta() throws SQLException {
		String s = "";
		PreparedStatement selectPreparedStatement = con.prepareStatement("SELECT * FROM consulta");
		ResultSet rs = selectPreparedStatement.executeQuery();
		while (rs.next()) {
			s = "fecha=  " + rs.getObject("fechaConsulta") + "  |  latitud=  " + rs.getObject("latitud")
					+ "  |  longitud=  " + rs.getObject("longitud") + "\n";
		}
		return s;
	}

	public String mostrarConsulta(Consulta c) throws SQLException {
		String s = "";
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");

		String query = "SELECT * FROM consulta WHERE fechaconsulta =" + f.format(c.getFechaConsulta()) + " and latitud="
				+ String.valueOf(c.getLatitud()) + "and longitud=" + String.valueOf(c.getLongitud());
		PreparedStatement selectPreparedStatement = con.prepareStatement(query);
		ResultSet rs = selectPreparedStatement.executeQuery();

		while (rs.next()) {
			s = "fecha=  " + rs.getObject("fechaConsulta") + "  |  latitud=  " + rs.getObject("latitud")
					+ "  |  longitud=  " + rs.getObject("longitud") + "\n";

			s += mostrarCondicion(c.getCondicion().getCodigo());
		}
		return s;
	}

	public String mostrarCondicion() throws SQLException {
		String s = "";
		PreparedStatement selectPreparedStatement = con.prepareStatement("SELECT * FROM condicion");
		ResultSet rs = selectPreparedStatement.executeQuery();

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
					+ "  |  fecha=  " + rs.getObject("dia") + "  |  descripcion= " + rs.getObject("descripcion").toString()
					+ "\n";
		}
		return s;
	}

	public String mostrarViento() throws SQLException {
		String s = "";
		ResultSet rs = prInsertar.executeQuery("SELECT * FROM viento");
		while (rs.next()) {
			s = "codigo=  " + rs.getObject("codigo") + "  |  temperatura=  " + rs.getObject("temperatura")
					+ "  |  direccion=  " + rs.getObject("direccion") + "  |  velocidad=  " + rs.getObject("velocidad")
					+ "\n";
		}
		return s;
	}

}
