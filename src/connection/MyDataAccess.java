package connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import datos.ClimaDia;

import java.sql.SQLException;

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
				System.out.print("Conexion exitosa");

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
		prInsertar = con
				.prepareStatement("INSERT INTO CLIMADIA (codigo,fecha,dia,temperatura,minima,maxima,descripcion)"
						+ "values(?,?,?,?,?,?,?)");
		prInsertar.setString(1, String.valueOf(cd.getCodigo()));
		SimpleDateFormat f= new SimpleDateFormat("yyyy-mm-dd");
		prInsertar.setString(2, f.format(cd.getFecha()));
		prInsertar.setString(3, cd.getDia());
		prInsertar.setString(4, String.valueOf(cd.getTemperatura()));
		prInsertar.setString(5, String.valueOf(cd.getMin()));
		prInsertar.setString(6, String.valueOf(cd.getMax()));
		prInsertar.setString(7, cd.getDescripcion());
		
		prInsertar.executeUpdate();

	}
}
