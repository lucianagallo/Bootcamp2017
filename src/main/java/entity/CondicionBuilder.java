package main.java.entity;

import java.util.Date;

public class CondicionBuilder {
	private int id;
	private int codigo;
	private int temperatura;
	private String descripcion;
	private Date dia;
	private Ubicacion ubicacion;
	private Viento viento;
	private Ambiente ambiente;
	private Astronomia astronomia;

	CondicionBuilder withId(int i) {
		id = i;
		return this;
	}

	CondicionBuilder withCodigo(int c) {
		codigo = c;
		return this;
	}

	CondicionBuilder withTemperatura(int t) {
		temperatura = t;
		return this;
	}

	CondicionBuilder withDescripcion(String d) {
		descripcion = d;
		return this;
	}

	CondicionBuilder withDia(Date d) {
		dia = d;
		return this;
	}

	CondicionBuilder withUbicacion(Ubicacion u) {
		ubicacion = u;
		return this;
	}

	CondicionBuilder withViento(Viento v) {
		viento = v;
		return this;
	}

	CondicionBuilder withAmbiente(Ambiente a) {
		ambiente = a;
		return this;
	}

	CondicionBuilder withAstronimia(Astronomia a) {
		astronomia = a;
		return this;
	}

	Condicion build() {
		Condicion c = new Condicion();
		c.setId(this.id);
		c.setAmbiente(this.ambiente);
		c.setAstronomia(this.astronomia);
		c.setCodigo(this.codigo);
		c.setDescripcion(this.descripcion);
		c.setDia(this.dia);
		c.setTemperatura(this.temperatura);
		c.setUbicacion(this.ubicacion);
		c.setViento(this.viento);
		return c;
	}

}
