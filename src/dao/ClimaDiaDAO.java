package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import main.java.connection.MyDataAccess;
import main.java.entity.ClimaDia;

public class ClimaDiaDAO implements ClimaDAO {

	private PreparedStatement prInsertar;
	private PreparedStatement prUpdate;
	@Autowired
	MyDataAccess mda;

	@Override
	public void insert(Object o) {
		Connection con = mda.getConnection();
		ClimaDia cd = (ClimaDia) o;
		try {
			prInsertar = con
					.prepareStatement("INSERT INTO CLIMADIA (idclimadia, codigo,fecha,dia,minima,maxima,descripcion)"
							+ "values(?,?,?,?,?,?,?)");
			prInsertar.setInt(1, cd.getId());
			prInsertar.setString(2, String.valueOf(cd.getCodigo()));
			SimpleDateFormat f = new SimpleDateFormat("yyyy-mm-dd");
			prInsertar.setString(3, f.format(cd.getFecha()));
			prInsertar.setString(4, cd.getDia());
			prInsertar.setString(5, String.valueOf(cd.getMin()));
			prInsertar.setString(6, String.valueOf(cd.getMax()));
			prInsertar.setString(7, cd.getDescripcion());
			prInsertar.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Object o) {
		Connection con = mda.getConnection();
		ClimaDia cd = (ClimaDia) o;
		try {
			prUpdate = con.prepareStatement(
					"UPDATE CLIMADIA set fecha=? dia=? minima=? maxima=? descripcion=?" + "WHERE codigo=?");

			SimpleDateFormat f = new SimpleDateFormat("yyyy-mm-dd");
			prUpdate.setString(1, f.format(cd.getFecha()));
			prUpdate.setString(2, cd.getDia());
			prUpdate.setInt(3, cd.getMin());
			prUpdate.setInt(4, cd.getMax());
			prUpdate.setString(5, cd.getDescripcion());
			prUpdate.executeUpdate();
			prUpdate.setInt(6, cd.getCodigo());
			prUpdate.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(Object o) {
		// ObjectODO Auto-generated method stub

	}

	@Override
	public Object select(int id) {
		// ObjectODO Auto-generated method stub
		return null;
	}
}
