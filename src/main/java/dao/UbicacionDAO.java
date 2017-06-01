package main.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import main.java.connection.MyDataAccess;
import main.java.entity.Ubicacion;
import main.java.entity.UbicacionBuilder;

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
		Ubicacion u = new Ubicacion();
		u.setId(id);
		try {
			ResultSet rs = prInsertar.executeQuery("SELECT * FROM UBICACION WHERE idViento =" + id);

			while (rs.next()) {
				u.setCiudad(rs.getString("ciudad"));
				u.setPais(rs.getString("pais"));
				u.setRegion(rs.getString("region"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
}
	@Override
	public List<Object> selectAll() {
		List<Object> ubicaciones = new LinkedList<>();
		try {
			ResultSet rs = prInsertar.executeQuery("SELECT * FROM UBICACION");

			while (rs.next()) {
				Ubicacion u = new UbicacionBuilder().withId(rs.getInt("idUbicacion"))
				.withCiudad(rs.getString("ciudad"))
				.withPais(rs.getString("pais"))
				.withRegion(rs.getString("region"))
				.build();
				ubicaciones.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ubicaciones;
}
}