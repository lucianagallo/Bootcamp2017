package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

import main.java.connection.MyDataAccess;
import main.java.entity.Ambiente;

public class AmbienteDAO implements ClimaDAO {
	@Autowired
	MyDataAccess mda;
	private PreparedStatement prInsertar;

	@Override
	public void insert(Object o) {
		Connection con = mda.getConnection();
		Ambiente a = (Ambiente) o;
		try {
			prInsertar = con.prepareStatement(
					"INSERT INTO AMBIENTE (idAmbiente,humedad,presion,indiceUV,visibilidad)" + "values(?,?,?,?,?)");
			prInsertar.setInt(1, a.getId());
			prInsertar.setInt(2, a.getHumedad());
			prInsertar.setString(3, String.valueOf(a.getPresion()));
			prInsertar.setInt(4, a.getHumedad());
			prInsertar.setString(5, String.valueOf(a.getVisibilidad()));
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
