package main.java.entity;

public class UbicacionBuilder {
	private int id;
	private String ciudad;
	private String pais;
	private String region;

	UbicacionBuilder withId(int i) {
		id = i;
		return this;
	}

	UbicacionBuilder withCiudad(String c) {
		ciudad = c;
		return this;
	}

	UbicacionBuilder withPais(String p) {
		pais = p;
		return this;
	}

	UbicacionBuilder withRegion(String r) {
		region = r;
		return this;
	}

	Ubicacion build() {
		Ubicacion u = new Ubicacion();
		u.setId(this.id);
		u.setCiudad(this.ciudad);
		u.setPais(this.pais);
		u.setRegion(this.region);
		return u;
	}
}
