package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

import main.java.connection.MyDataAccess;
import main.java.entity.Ubicacion;

public class UbicacionDAO implements ClimaDAO {
	private PreparedStatement prInsertar;
	@Autowired
	private MyDataAccess mda;

	@Override
	public void insert(Object o) {
		Connection con = mda.getConnection();
		Ubicacion u = (Ubicacion) o;
		try {
			prInsertar = con
					.prepareStatement("INSERT INTO UBICACION (idUbicacion, ciudad,pais,region)" + "values(?,?,?,?)");
			prInsertar.setInt(1, u.getId());
			prInsertar.setString(2, u.getCiudad());
			prInsertar.setString(3, u.getPais());
			prInsertar.setString(4, u.getRegion());
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
