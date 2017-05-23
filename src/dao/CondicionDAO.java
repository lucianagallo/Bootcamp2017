package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;

import main.java.connection.MyDataAccess;
import main.java.entity.Condicion;

public class CondicionDAO implements ClimaDAO {
	private PreparedStatement prInsertar;
	@Autowired
	private MyDataAccess mda;

	@Override
	public void insert(Object o) {
		Connection con = mda.getConnection();
		Condicion c = (Condicion) o;
		try {
			prInsertar = con.prepareStatement(
					"INSERT INTO CONDICION (idCondicion, codigo, temperatura, dia, descripcion, idUbicacion, idAmbiente, idAstronomia, idViento)"
							+ "values(?,?,?,?,?,?,?,?,?)");
			prInsertar.setInt(1, c.getId());
			prInsertar.setInt(2, c.getCodigo());
			prInsertar.setInt(3, c.getTemperatura());
			SimpleDateFormat f = new SimpleDateFormat("yyyy-mm-dd");
			prInsertar.setString(4, f.format(c.getDia()));
			prInsertar.setString(5, c.getDescripcion());
			prInsertar.setInt(6, c.getUbicacion().getId());
			prInsertar.setInt(7, c.getAmbiente().getId());
			prInsertar.setInt(8, c.getAstronomia().getId());
			prInsertar.setInt(9, c.getViento().getId());
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
		return null;
	}
}
