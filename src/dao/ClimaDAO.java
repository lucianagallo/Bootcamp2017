package dao;

public interface ClimaDAO {

	void insert(Object o);

	void update(Object o);

	void delete(Object o);

	Object select(int id);
}
