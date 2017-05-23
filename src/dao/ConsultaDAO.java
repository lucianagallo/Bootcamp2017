package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;

import main.java.connection.MyDataAccess;
import main.java.entity.Consulta;

public class ConsultaDAO implements ClimaDAO {
	private PreparedStatement prInsertar;
	@Autowired
	private MyDataAccess mda;

	@Override
	public void insert(Object o) {
		Connection con = mda.getConnection();
		Consulta c = (Consulta) o;
		try {
			prInsertar = con
					.prepareStatement("INSERT INTO CONSULTA (idConsulta,fechaConsulta,latitud,longitud,idCondicion)"
							+ "values(?,?,?,?,?)");
			prInsertar.setInt(1, c.getId());
			SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
			prInsertar.setString(2, f.format(c.getFechaConsulta()));
			prInsertar.setString(3, String.valueOf(c.getLatitud()));
			prInsertar.setString(4, String.valueOf(c.getLongitud()));
			prInsertar.setInt(5, c.getCondicion().getId());
			prInsertar.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Object o) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Object o) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object select(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
