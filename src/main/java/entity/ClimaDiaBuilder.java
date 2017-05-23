package main.java.entity;

import java.util.Date;

public class ClimaDiaBuilder {
	private int id;
	private int codigo;
	private Date fecha;
	private String dia;
	private int max;
	private int min;
	private String descripcion;

	ClimaDiaBuilder withId(int i) {
		id = i;
		return this;
	}

	ClimaDiaBuilder withCodigo(int c) {
		codigo = c;
		return this;
	}

	ClimaDiaBuilder withFecha(Date f) {
		fecha = f;
		return this;
	}

	ClimaDiaBuilder withDia(String d) {
		dia = d;
		return this;
	}

	ClimaDiaBuilder withMax(int m) {
		max = m;
		return this;
	}

	ClimaDiaBuilder withMin(int m) {
		min = m;
		return this;
	}

	ClimaDiaBuilder withDescripcion(String d) {
		descripcion = d;
		return this;
	}

	ClimaDia build() {
		ClimaDia cd = new ClimaDia();
		cd.setId(this.id);
		cd.setCodigo(this.codigo);
		cd.setFecha(this.fecha);
		cd.setDia(this.dia);
		cd.setMax(this.max);
		cd.setMin(this.min);
		cd.setDescripcion(this.descripcion);
		return cd;
	}
}
