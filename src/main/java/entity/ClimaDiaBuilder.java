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

	public ClimaDiaBuilder withCodigo(int c) {
		codigo = c;
		return this;
	}

	public ClimaDiaBuilder withFecha(Date f) {
		fecha = f;
		return this;
	}

	public ClimaDiaBuilder withDia(String d) {
		dia = d;
		return this;
	}

	public ClimaDiaBuilder withMax(int m) {
		max = m;
		return this;
	}

	public ClimaDiaBuilder withMin(int m) {
		min = m;
		return this;
	}

	public ClimaDiaBuilder withDescripcion(String d) {
		descripcion = d;
		return this;
	}

	public ClimaDia build() {
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
