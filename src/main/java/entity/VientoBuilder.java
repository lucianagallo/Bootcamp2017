package main.java.entity;

public class VientoBuilder {
	private int id;
	private int temperatura;
	private int velocidad;
	private int direccion;

	VientoBuilder withTemperatura(int t) {
		temperatura = t;
		return this;
	}

	VientoBuilder withVelociodad(int v) {
		velocidad = v;
		return this;
	}

	VientoBuilder withDireccion(int d) {
		direccion = d;
		return this;
	}

	VientoBuilder withId(int i) {
		id = i;
		return this;
	}

	Viento build() {
		Viento v = new Viento();
		v.setId(this.id);
		v.setTemperatura(this.temperatura);
		v.setDireccion(this.direccion);
		v.setVelocidad(this.velocidad);
		return v;
	}
}
