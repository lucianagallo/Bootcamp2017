package main.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import main.java.connection.MyDataAccess;
import main.java.entity.Astronomia;

public class AstronomiaDAO implements ClimaDAO {
	private PreparedStatement prInsertar;
	@Autowired
	MyDataAccess mda;

	@Override
	public void insert(Object o) {
		Connection con = mda.getConnection();
		Astronomia a = (Astronomia) o;
		try {
			prInsertar = con
					.prepareStatement("INSERT INTO ASTRONOMIA (idAstronomia, amanecer, atardecer)" + "values(?,?,?)");
			prInsertar.setInt(1, a.getId());
			prInsertar.setString(2, a.getAmanecer());
			prInsertar.setString(3, a.getAtardecer());
			prInsertar.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(Object o) {

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

	@Override
	public List<Object> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
