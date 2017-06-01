package main.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import main.java.connection.MyDataAccess;
import main.java.entity.Viento;

public class VientoDAO implements ClimaDAO {
	private PreparedStatement prInsertar;
	private PreparedStatement prUpdate;
	@Autowired
	private MyDataAccess mda;

	@Override
	public void insert(Object o) {
		Connection con = mda.getConnection();
		Viento v = (Viento) o;
		try {
			prInsertar = con.prepareStatement(
					"INSERT INTO VIENTO (idViento, temperatura,velocidad,direccion)" + "values(?,?,?,?)");

			prInsertar.setInt(1, v.getId());
			prInsertar.setInt(2, v.getTemperatura());
			prInsertar.setInt(3, v.getVelocidad());
			prInsertar.setInt(4, v.getDireccion());
			prInsertar.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Object o) {
		Connection con = mda.getConnection();
		Viento v = (Viento) o;
		try {
			prUpdate = con
					.prepareStatement("UPDATE VIENTO SET temperatura=? velocidad=? direccion=?" + "WHERE idviento =?)");
			prUpdate.setString(1, String.valueOf(v.getTemperatura()));
			prUpdate.setString(2, String.valueOf(v.getVelocidad()));
			prUpdate.setString(3, String.valueOf(v.getDireccion()));
			prUpdate.setInt(4, v.getId());
			prUpdate.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(Object o) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object select(int id) {
		Viento v = new Viento();
		try {
			ResultSet rs = prInsertar.executeQuery("SELECT * FROM VIENTO WHERE idViento =" + id);

			while (rs.next()) {
				v.setTemperatura(rs.getInt("temperatura"));
				v.setDireccion(rs.getInt("direccion"));
				v.setVelocidad(rs.getInt("velocidad"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return v;
	}

	@Override
	public List<Object> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
