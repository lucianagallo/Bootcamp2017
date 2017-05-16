package main.java.modelo;

public class Viento {
	private int temperatura;
	private int velocidad;
	private int direccion;
	
	public Viento(int temperatura, int velocidad, int direccion) {
		super();
		this.temperatura = temperatura;
		this.velocidad = velocidad;
		this.direccion = direccion;
	}
	public int getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(int temperatura) {
		this.temperatura = temperatura;
	}
	public int getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
	public int getDireccion() {
		return direccion;
	}
	public void setDireccion(int direccion) {
		this.direccion = direccion;
	}

}
