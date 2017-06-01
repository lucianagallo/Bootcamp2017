package main.java.entity;

public class UbicacionBuilder {
	private int id;
	private String ciudad;
	private String pais;
	private String region;

	public UbicacionBuilder withId(int i) {
		id = i;
		return this;
	}

	public UbicacionBuilder withCiudad(String c) {
		ciudad = c;
		return this;
	}

	public UbicacionBuilder withPais(String p) {
		pais = p;
		return this;
	}

	public UbicacionBuilder withRegion(String r) {
		region = r;
		return this;
	}

	public Ubicacion build() {
		Ubicacion u = new Ubicacion();
		u.setId(this.id);
		u.setCiudad(this.ciudad);
		u.setPais(this.pais);
		u.setRegion(this.region);
		return u;
	}
}
