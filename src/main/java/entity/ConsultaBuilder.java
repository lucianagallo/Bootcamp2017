package main.java.entity;

import java.util.ArrayList;
import java.util.Date;

public class ConsultaBuilder {
	private int id;
	private Date fechaConsulta;
	private ArrayList<ClimaDia> pronostico;
	private Condicion condicion;
	private double latitud;
	private double longitud;

	ConsultaBuilder withId(int i) {
		id = i;
		return this;
	}

	ConsultaBuilder withFechaConsulta(Date f) {
		fechaConsulta = f;
		return this;
	}

	ConsultaBuilder withPronostico(ArrayList<ClimaDia> p) {
		pronostico = p;
		return this;
	}

	ConsultaBuilder withCondicion(Condicion c) {
		condicion = c;
		return this;
	}

	ConsultaBuilder withLatitud(double l) {
		latitud = l;
		return this;
	}

	ConsultaBuilder withLongitud(double l) {
		longitud = l;
		return this;
	}

	Consulta build() {
		Consulta c = new Consulta();
		c.setId(this.id);
		c.setCondicion(this.condicion);
		c.setFechaConsulta(this.fechaConsulta);
		c.setLatitud(this.latitud);
		c.setLongitud(this.longitud);
		c.setPronostico(this.pronostico);
		return c;
	}
}
