package main.java.entity;

public class Viento {
	private int id;
	private int temperatura;
	private int velocidad;
	private int direccion;
	
	public Viento(){}
	public Viento(int temperatura, int velocidad, int direccion) {
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
